<% include '/WEB-INF/includes/header.gtpl' %>

	<!-- Main jumbotron for a primary marketing message or call to action -->
	<div class="jumbotron">
	  <div class="container">
	    <h1>Certificados PDF <small>Beta</small></h1>
	    <p>A maneira mais fácil e rápida de enviar certificados de participação em cursos e eventos por e-mail. Com apenas 3 passos todos os participantes recebem um email padrão com o certificado anexado em formato PDF.</p>
	  </div>
	</div>
	
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
					<h2>Enviando email com os certificados</h2>	
			</div>
		</div>
		<hr>
		<!-- Example row of columns -->
		<div class="row">
			<div class="col-lg-6">
				<img class="img-thumbnail" width="640" height="480" src="/images/emailscreen.png">
			</div>
			<div class="col-lg-6">
				<div class="panel-group" id="accordion">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
									Preview
								</a>
							</h4>
						</div>
						<div id="collapseOne" class="panel-collapse collapse in">
							<div class="panel-body">
								<p>Antes de enviar os e-mails você poderá visualizar como ficará o PDF gerado. Para que os campos do template PDF
								sejam preenchidos corretamente, é obrigatório que eles tenham <b>os mesmos nomes informados na primeira linha do arquivo CSV</b>.</p>
							</div>
						</div>
					</div>				
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
									Email e nome do remetente
								</a>
							</h4>
						</div>
						<div id="collapseTwo" class="panel-collapse collapse">
							<div class="panel-body">
								<p>O email do rementente sempre será certificadospdf@gmail.com. <a href="https://github.com/ratodigital/certificadospdf/issues/new">Entre em contato</a> caso
								deseje personalizar com um e-mail da sua organização. O nome do remetente poderá ser customizado livremente.</p>
							</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
									E-mail do destinatário
								</a>
							</h4>
						</div>
						<div id="collapseThree" class="panel-collapse collapse">
							<div class="panel-body">
								<p>Cada certificado será enviado individualmente para um destinatário, por isso é obrigatório
								que o arquivo CSV possua um campo chamado <b>email</b>, o qual será utilizado como endereço de destino.</p>
							</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseFour">
									Assunto e mensagem
								</a>
							</h4>
						</div>
						<div id="collapseFour" class="panel-collapse collapse">
							<div class="panel-body">
								<p>Digite livremente o assunto e a mensagem a serem encaminhados em cada e-mail. Você poderá usar
								todos os campos que configurou no arquivo CSV, usando a notação <b>\$nome_do_campo</b></p>
							</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseFive">
									Enviando os certificados
								</a>
							</h4>
						</div>
						<div id="collapseFive" class="panel-collapse collapse">
							<div class="panel-body">
								Concluídas as configurações é só clicar no botão para Enviar os certificados. Até 50 e-mails podem ser enviados por vez. 
								<a href="https://github.com/ratodigital/certificadospdf/issues/new">Entre em contato</a> caso
								deseje aumentar este limite.</p>
							</div>
						</div>
					</div>	
				
					<br>
					<p><a class="btn btn-primary" href="/">Voltar para página inicial</a></p>					
				</div>
			</div>
	</div>
	
<% include '/WEB-INF/includes/footer.gtpl' %>

