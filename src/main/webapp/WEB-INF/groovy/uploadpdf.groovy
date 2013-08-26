import util.*

import com.google.appengine.api.blobstore.BlobKey 
import com.google.appengine.api.blobstore.BlobInfo

def blobs = blobstore.getUploadedBlobs(request)
def pdfFile = blobs["pdfFile"]

pdfFile.withStream { inputStream -> 
	def pdf = new PDF()
	pdf.open(inputStream) 
	memcache[pdfFile.keyString] = pdf
	request.pdfKey = pdfFile.keyString
	request.pdfName = pdfFile.filename
//	request.fields = pdf.listFormFields()
	forward "WEB-INF/pages/uploadcsv.gtpl"
}
