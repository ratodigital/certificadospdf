<% include '/WEB-INF/includes/header.gtpl'%>

	<!-- Main jumbotron for a primary marketing message or call to action -->
	<div class="jumbotron">
	  <div class="container">
	    <h1>Certificados PDF <small>Beta</small></h1>
	    <p>A maneira mais fácil e rápida de enviar certificados de participação em cursos e eventos por e-mail. Com apenas 3 passos todos os participantes recebem um email padrão com o certificado anexado em formato PDF.</p>
	    <p><a href="/upload" class="btn btn-success btn-lg">Enviar certificados &raquo;</a></p>
	  </div>
	</div>
	
	<div class="container">
		<!-- Example row of columns -->
		<div class="row">
			<div class="col-lg-4">
  			<img src="/images/pdf.png" width="128px" height="128px" alt="PDF">
			  <h2>1. Template PDF</h2>
			  <p>Crie e faça upload do PDF contendo o modelo do certificado. Usando o LibreOffice Writer, use o desenhador de formulários para criar campos de texto somente leitura. Exporte para PDF e faça o upload.</p>
			  <p><a href="#divPdf" id="btnPdf" type="button" data-toggle="button" class="btn btn-primary" onclick="showDivPdf();"><span class="glyphicon glyphicon-info-sign"></span> Saiba mais</a></p>
			</div>
			<div class="col-lg-4">
  			<img src="/images/csv.png" width="128px" height="128px" alt="CSV">
			  <h2>2. Dados CSV</h2>
			  <p>Os dados do evento/participante (nome, e-mail, data, carga horária, curso, etc) devem ser informados em um arquivo texto separado por virgulas (formato CSV). A primeira linha contem o nome dos campos.</p>
			  <p><a href="#divCsv" id="btnCsv" type="button" data-toggle="button" class="btn btn-primary" onclick="showDivCsv();"><span class="glyphicon glyphicon-info-sign"></span> Saiba mais</a></p>
			</div>
			<div class="col-lg-4">
        <img src="/images/email.png" width="128px" height="128px" alt="Email">
			  <h2>3. Enviar Email</h2>
			  <p>Configure o nome do remetente, o assunto e o texto da mensagem a ser encaminhada a cada participante. Você também poderá ver uma prévia de como ficará o certificado pronto.</p>
			  <p><a href="#divEmail" id="btnEmail" type="button" data-toggle="button" class="btn btn-primary" onclick="showDivEmail();"><span class="glyphicon glyphicon-info-sign"></span> Saiba mais</a></p>
			</div>
	</div>

	<% include '/WEB-INF/includes/divPdf.gtpl' %>	
	<% include '/WEB-INF/includes/divCsv.gtpl' %>		
	<% include '/WEB-INF/includes/divEmail.gtpl' %>

	
<% include '/WEB-INF/includes/footer.gtpl' %>

