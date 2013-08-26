<html>
<body>
<h1>Envie o CSV com os dados dos participantes</h1>
<form action="${blobstore.createUploadUrl('/uploadcsv.groovy')}"
method="post" enctype="multipart/form-data">
  <input name="pdfKey" type="hidden" value="$request.pdfKey">
  <input name="pdfName" type="hidden" value="$request.pdfName">  
  <input type="file" name="csvFile">
  <input type="submit" value="Submit">
</form>
</body>
</html>
