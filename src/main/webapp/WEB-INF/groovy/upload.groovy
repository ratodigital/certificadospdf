import util.*

import com.google.appengine.api.blobstore.BlobKey 
import com.google.appengine.api.blobstore.BlobInfo
import com.google.appengine.api.files.FileReadChannel
import java.nio.channels.Channels

def blobs = blobstore.getUploadedBlobs(request)

//CSV
def csvFile = blobs["csvFile"]
println csvFile.filename+"<br/>"
def csvData = []
csvFile.withStream { csvInputStream ->
  def fieldNames = []
  def f = 1 
  csvInputStream.splitEachLine(",") { fields ->
    if (f++==1) {
      fieldNames = fields      
    } else {
      def fieldsMap = [:]
      fieldNames.eachWithIndex { key, index ->
        fieldsMap[key] = fields[index]
      }
      csvData << fieldsMap
    }
  }
}
println "CSVDATA=$csvData<br/>"


//PDF
def pdfFile = blobs["pdfFile"]
pdfFile.withStream { inputStream -> 
  def pdf = new PDF()
  pdf.open(inputStream) 
  csvData.each { data ->
    println "DATA=$data<br/>"  
    def outputPdfName = "${pdfFile.filename}"
    def pdfStamper = files.createNewBlobFile("application/pdf", outputPdfName)
    pdfStamper.withOutputStream(locked: true, finalize: true) { outputStream ->
      pdf.preparePdfStamper(outputStream)
      pdf.listFormFields().each { fieldName ->
        pdf.changeFieldValue(fieldName, data[fieldName])
        println "mudando campo $fieldName para ${data[fieldName]}<br/>"
      }
      pdf.closeAll()
    }

    FileReadChannel ch = files.openReadChannel(pdfStamper, true);
    byte[] pdfBytes = getBytes(Channels.newInputStream(ch))

    println "enviando $outputPdfName email para ${data['email']}"
    mail.send from: "serge@ratodigital.com",
    to: ${data['email']},
    subject: "Seu certificado está pronto!",
    textBody: "Pegaí seu certificado! -- Rato Digital",
    attachment: [data: pdfBytes, fileName: "$outputPdfName"]    
    /*
    BlobInfo inf = pdfStamper.blobKey.info
    response.setHeader("Content-Type", "application/pdf");
    response.setHeader("Content-Length", String.valueOf(inf.size));
    response.setHeader("Content-Disposition", "attachment;filename=\"$outputPdfName\"");
    blobstore.serve(pdfStamper.blobKey, response)
    */
  }
}

def byte[] getBytes(InputStream is) throws IOException {
    ByteArrayOutputStream buffer = new ByteArrayOutputStream();

    int len;
    byte[] data = new byte[100000]; // adapt buffer size to your needs
    while ((len = is.read(data, 0, data.length)) != -1) {
        buffer.write(data, 0, len);
    }

    buffer.flush();
    return buffer.toByteArray();
}
