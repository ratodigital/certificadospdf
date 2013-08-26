import util.*

import com.google.appengine.api.blobstore.BlobKey 

blobstore.each { b ->
  println "$b.blobKey.keyString $b.filename $b.creation $b.contentType $b.size<br/>"
  def blob = b.blobKey 
  blob.delete()
}

