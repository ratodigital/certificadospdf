<% import com.google.appengine.api.blobstore.BlobKey %>
<html>
<body>
<h1>$request.pdfName</h1>
 
<div>

<form action="/csv" method="post">
  <input name="pdfKey" type="hidden" value="$request.pdfKey">
  <input name="pdfName" type="hidden" value="$request.pdfName">  
<%
request.fields.each { f->
%>
  <p>$f:<input type="hidden" name="fieldName" value="$f"/><input type="text" name="fieldValue"/></p>
<%
}
%>
  <input type="submit" value="Informar CSV">
<!--  <input type="button" value="Informar CSV" onclick="window.location='/csv'"> -->
</form>
</body>
</html>
