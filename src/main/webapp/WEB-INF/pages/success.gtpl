<% include '/WEB-INF/includes/header.gtpl' %>

	<!-- Main jumbotron for a primary marketing message or call to action -->
	<div class="jumbotron">
	  <div class="container">
	    <h1>Certificados PDF <small>Beta</small></h1>
	    <p>A maneira mais fácil e rápida de enviar certificados de participação em cursos e eventos por e-mail. Com apenas 3 passos todos os participantes recebem um email padrão com o certificado anexado em formato PDF.</p>
	  </div>
	</div>
	
	<div class="container">
		<!-- Example row of columns -->
		<div class="row">
			<div class="col-lg-12">
         <%
          def alertType = (request.status=='OK') ? 'alert-success' : 'alert-error'
         %>
			   <div class="alert $alertType">$request.message</div>
			   
			   <p class="text-center"><a href="/" type="button" class="btn btn-primary btn-lg">Página Inicial</a></p>
			</div>
	</div>
	
<% include '/WEB-INF/includes/footer.gtpl' %>

