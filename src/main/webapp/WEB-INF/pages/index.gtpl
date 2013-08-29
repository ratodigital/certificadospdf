<% include '/WEB-INF/includes/header.gtpl'%>

	<!-- Main jumbotron for a primary marketing message or call to action -->
	<div class="jumbotron">
	  <div class="container">
	    <h1>Certificados PDF <small>Beta</small></h1>
	    <p>A maneira mais fácil e rápida de enviar certificados de participação em cursos e eventos por e-mail. Com apenas 3 passos todos os participantes recebem um email padrão com o certificado anexado em formato PDF.</p>
	    <p ><a href="/upload" class="btn btn-success btn-lg">Enviar certificados</a></p>
	  </div>
	</div>
	
	<div class="container">
		<!-- Example row of columns -->
		<div class="row">
			<div class="col-lg-4">
  			<img src="/images/pdf.png" width="128px" height="128px" alt="PDF">
			  <h2>1. Template PDF</h2>
			  <p>Crie e faça upload do PDF contendo o modelo do certificado. Usando o LibreOffice Writer, use o desenhador de formulários para criar campos de texto somente leitura. Exporte para PDF e faça o upload.</p>
			  <p><a data-toggle="modal" href="/pdf" class="btn btn-primary">Saiba mais &raquo;</a></p>
			</div>
			<div class="col-lg-4">
  			<img src="/images/csv.png" width="128px" height="128px" alt="CSV">
			  <h2>2. Dados CSV</h2>
			  <p>Os dados do evento/participante (nome, e-mail, data, carga horária, curso, etc) devem ser informados em um arquivo texto separado por virgulas (formato CSV). A primeira linha contem o nome dos campos.</p>
			  <p><a class="btn btn-primary" href="https://support.google.com/mail/answer/12119?hl=pt-BR">Saiba mais &raquo;</a></p>
			</div>
			<div class="col-lg-4">
        <img src="/images/email.png" width="128px" height="128px" alt="Email">
			  <h2>3. Enviar Email</h2>
			  <p>Configure o nome do remetente, o assunto e o texto da mensagem a ser encaminhada a cada participante. Você também poderá ver uma prévia de como ficará o certificado pronto.</p>
			  <p><a class="btn btn-primary" href="/email">Saiba mais &raquo;</a></p>
			</div>
	</div>
	
 
	
  <!-- sample modal content -->
  <div id="csv" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">

        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          <h4 class="modal-title" id="myModalLabel">Template PDF</h4>
        </div>
        <div class="modal-body">

					<div class="flex-video widescreen" style="margin: 0 auto;text-align:center;">
						<iframe width="360" height="270" src="//www.youtube.com/embed/0dCuRrNmUI8" frameborder="0" allowfullscreen></iframe>
					<div>
          <h4>Criando seu template de certificado em PDF</h4>	
          <p>Você pode usar qualquer ferramenta para criação de PDF. Com o <a href="http://pt-br.libreoffice.org/libreoffice/writer/">LibreOffice Writer</a> é simples e gratuito!</p>
          <p>Crie um novo documento texto. Escolha <b>Formatar/Página</b> e configure a orientação <b>Paisagem</b>, que é o mais comum.</p>
          <p>Se você tiver uma imagem de fundo, adicione-a (menu <b>Inserir/Figura/De um arquivo</b>) na página, clique com o botão
          direito e escolha o menu <b>Quebra automática/No plano de fundo</b>. Posicione a imagem no lugar adequado.</p>
          <p>As informações estáticas podem ser desenhadas como texto normal ou como campos texto das ferramenta de desenho
          ou designer de formulários. As duas últimas alternativas são melhores, pois tem-se maior controle sobre a posição dos textos.</p>
          <p>Para criar os campos, selecione a opção <b>Design de formulários</b> do menu <b>Exibir/Barra de ferramentas</b>.</p>
          <p>Ative o <i>modo de design</i>. Inclua <i>Campos de rótulo</i> para informações fixas. Nas propriedades, escolha tamanho e tipo de fonte.</p>
          <p>Para campos variáveis utilize <i>Caixas de texto</i>. Defina o tipo de Borda e marque <b>Sim</b> na propriedade <i>Somente leitura</i>.
          Escolha a propridade <i>Ancorar</i> com o valor <b>Na página</b>, para facilitar o posicionamento do campo em qualquer lugar do certificado.</p>
          <p>Salve seu arquivo, para eventuais modificações futuras e, exporte para PDF (menu <b>Arquivo/Exportar como PDF</b>). Mantenha
          as opções padrões e seu template PDF está pronto!</p>
          <p>Se desejar, baixe este <a href="#" class="tooltip-test" title="Exemplos">ZIP com alguns exemplos</a>.</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
        </div>

      </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
  </div><!-- /.modal -->	
<% include '/WEB-INF/includes/footer.gtpl' %>

