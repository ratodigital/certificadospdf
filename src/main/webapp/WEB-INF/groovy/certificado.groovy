import util.*

import com.google.appengine.api.blobstore.BlobKey 
import com.google.appengine.api.blobstore.BlobInfo

println params

def blob = new BlobKey(params.pdfKey) 
blob.withStream { inputStream -> 
	def pdf = new PDF()
	pdf.open(inputStream) 
	def outputPdfName = "${params.pdfName}_preenchido.pdf"
  def pdfStamper = files.createNewBlobFile("application/pdf", outputPdfName)
  pdfStamper.withOutputStream(locked: true, finalize: true) { outputStream ->
	  pdf.preparePdfStamper(outputStream)
	  params.fieldName.eachWithIndex { field, i ->
    	pdf.changeFieldValue(field, params.fieldValue[i])
    }
  }
  pdf.closeAll()  
  
  BlobInfo inf = pdfStamper.blobKey.info
  response.setHeader("Content-Type", "application/pdf");
  response.setHeader("Content-Length", String.valueOf(inf.size));
  response.setHeader("Content-Disposition", "attachment;filename=\"$outputPdfName\"");
  blobstore.serve(pdfStamper.blobKey, response)
  pritln
}

//println params
