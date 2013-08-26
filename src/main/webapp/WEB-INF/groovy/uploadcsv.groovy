import util.*

import com.google.appengine.api.blobstore.BlobKey 
import com.google.appengine.api.blobstore.BlobInfo

def blobs = blobstore.getUploadedBlobs(request)
def csvFile = blobs["csvFile"]

println csvFile.filename+"<br/>"

//println params

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
println "$params.pdfKey DATA:" + csvData

def pdfFile = new BlobKey(params.pdfKey) 
pdfFile.withStream { pdfInputStream -> 
  csvData.each {
    def pdf = memcache[params.pdfKey]  
    //def pdf = new PDF()
    //pdf.open(pdfInputStream) 
    def outputPdfName = "${params.pdfName}.pdf"
    def pdfStamper = files.createNewBlobFile("application/pdf", outputPdfName)
    pdfStamper.withOutputStream(locked: true, finalize: true) { outputStream ->
      pdf.preparePdfStamper(outputStream)
      pdf.listFormFields().each { fieldName ->
        pdf.changeFieldValue(fieldName, csvData[fieldName])
        println "mudando campo $fieldName para ${csvData[fieldName]}"
      }
      pdf.closeAll()
    }
  }
}

/*
      fieldsList.each{ fields ->
      	//pdf.changeFieldValue(field, fieldValues[i])
      	fields.entrySet().each { field ->
      	  println "$field.key -> $field.value"
        	//pdf.changeFieldValue(field.key, field.value)
      	}
      }
*/

//println "gerando pdf $outputPdfName"

  /*
  BlobInfo inf = pdfStamper.blobKey.info
  response.setHeader("Content-Type", "application/pdf");
  response.setHeader("Content-Length", String.valueOf(inf.size));
  response.setHeader("Content-Disposition", "attachment;filename=\"$outputPdfName\"");
  blobstore.serve(pdfStamper.blobKey, response)
  */
  

//def fieldValues = fields
/*
println "$fieldValues <br/>"
def pdfFile = new BlobKey(params.pdfKey) 
pdfFile.withStream { pdfInputStream -> 
  def pdf = new PDF()
  pdf.open(pdfInputStream) 
  def outputPdfName = "${params.pdfName}_preenchido.pdf"
  def pdfStamper = files.createNewBlobFile("application/pdf", outputPdfName)
  pdfStamper.withOutputStream(locked: true, finalize: true) { outputStream ->
    pdf.preparePdfStamper(outputStream)
    fieldNames.eachWithIndex { field, i ->
    	//pdf.changeFieldValue(field, fieldValues[i])
    	pdf.changeFieldValue(field, fieldsMap[field])
    }
    pdf.closeAll()
  }
  
  BlobInfo inf = pdfStamper.blobKey.info
  response.setHeader("Content-Type", "application/pdf");
  response.setHeader("Content-Length", String.valueOf(inf.size));
  response.setHeader("Content-Disposition", "attachment;filename=\"$outputPdfName\"");
  blobstore.serve(pdfStamper.blobKey, response)
  
  println "gerando pdf $outputPdfName"
}
*/
