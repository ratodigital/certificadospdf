<html>
<body>
<h1>Envie o PDF modelo do certificado</h1>
<form action="${blobstore.createUploadUrl('/upload.groovy')}"
method="post" enctype="multipart/form-data">
PDF:<input type="file" name="pdfFile"><br/>
CSV:<input type="file" name="csvFile"><br/>
<input type="submit" value="Submit">
</form>
</body>
</html>
