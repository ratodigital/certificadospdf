import util.*

import com.google.appengine.api.blobstore.BlobKey 
import com.google.appengine.api.blobstore.BlobInfo

def blobs = blobstore.getUploadedBlobs(request)
def blob = blobs["pdfFile"]

blob.withStream { inputStream -> 
	def pdf = new PDF()
	pdf.open(inputStream) 
	def fields = pdf.listFormFields()
	def pdfStamper = files.createNewBlobFile("application/pdf", "certificadoSaida.pdf")
	pdfStamper.withOutputStream(locked: true, finalize: true) { outputStream ->
		pdf.preparePdfStamper(outputStream)
		pdf.changeFieldValue("NOME_INSTITUICAO",'TAKOAKARANAKOMBI')
		pdf.closeAll()
	}
	BlobInfo inf = pdfStamper.blobKey.info
	response.setHeader("Content-Type", "application/pdf");
	response.setHeader("Content-Length", String.valueOf(inf.size));
	response.setHeader("Content-Disposition", "attachment;filename=\"" + 'certificadout.pdf' + "\"");
	blobstore.serve(pdfStamper.blobKey, response)
}

/*
response.status = 302
 
if (blob) {
redirect "/success?key=${blob.keyString}"
} else {
redirect "/failure"
}
*/
