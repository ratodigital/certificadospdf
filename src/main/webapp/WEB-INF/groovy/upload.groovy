import util.*

import com.google.appengine.api.blobstore.BlobKey 
import com.google.appengine.api.blobstore.BlobInfo
import com.google.appengine.api.files.FileReadChannel
//import java.nio.channels.Channels

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
//def pdfStamper 


//csvData.each { data ->
for (data in csvData) {
	String outputPdfName
	byte[] outputPdfBytes
	def pdfStamper
  pdfFile.withStream { inputStream -> 
  	def pdf = new PDF()
	  pdf.open(inputStream) 
    log.info "***DATA=$data<br/>"  
  
    outputPdfName = "${data['email']}_${pdfFile.filename}"
    pdfStamper = files.createNewBlobFile("application/pdf", outputPdfName)
    pdfStamper.withOutputStream(locked: true, finalize: true) { outputStream ->
      pdf.preparePdfStamper(outputStream)
      pdf.listFormFields().each { fieldName ->
        pdf.changeFieldValue(fieldName, data[fieldName])
        println "mudando campo $fieldName para ${data[fieldName]}<br/>"
      }
      pdf.closeAll()
		}
	}
		BlobInfo inf = pdfStamper.blobKey.info
		outputPdfBytes = blobstore.fetchData(pdfStamper.blobKey, 0, inf.size	- 1) 
			
    println "enviando $outputPdfName email para ${data['email']}"	    
    //sendMails(outputPdfBytes, outputPdfName)
    Mail.send("serge@ratodigital.com","serge",data['email'],data['email'],"seu certificado esta pronto","Pegai em anexo",outputPdfName,outputPdfBytes)
    /*
    response.setHeader("Content-Type", "application/pdf");
    response.setHeader("Content-Length", String.valueOf(inf.size));
    response.setHeader("Content-Disposition", "attachment;filename=\"$outputPdfName\"");
    blobstore.serve(pdfStamper.blobKey, response)	    
	  */
	/*

*/
	//pdf.closePdf()	
	pdfStamper.delete()
}
pdfFile.delete()
csvFile.delete()

def sendMaild(a,f) {
	println "mail sent"
}

def sendMail(attach, fileName) {
	mail.send (from: "serge@ratodigital.com",
		to: ${data['email']},
		subject: "Seu certificado está pronto!",
		textBody: "Pegaí seu certificado! -- Rato Digital",
		attachment: [data: attach, fileName: "$fileName"])
}	