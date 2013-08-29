<div class="row" id="divCsv" style="display: none;">
  <div class="page-header">
    <hr>
    <h2><a><span class="glyphicon glyphicon-info-sign"></span></a> Gerando dados texto separados por vírgula (arquivos CSV)</h2>	
  </div>
  <div class="col-lg-6">
	  <img class="img-thumbnail" width="640" height="480" src="/images/datacsv.png">
  </div>  
  <div class="col-lg-6">
	  <div class="panel-group" id="csvAccordion">
		  <div class="panel panel-default">
			  <div class="panel-heading">
				  <h4 class="panel-title">
					  <a class="accordion-toggle" data-toggle="collapse" data-parent="#csvAccordion" href="#csvCollapseOne">
						  Primeira linha
					  </a>
				  </h4>
			  </div>
			  <div id="csvCollapseOne" class="panel-collapse collapse in">
				  <div class="panel-body">
					  A primeira linha deve conter o nome dos campos separados por vírgula. Os nomes tem que ser <b>exatamente iguais aos campos
					  do template pdf</b>. <b>Obrigatoriamente</b> um dos campos deve se chamar <b>email</b>, para que as mensagens com o certificado
					  anexado possam ser encaminhadas.
				  </div>
			  </div>
		  </div>
		  <div class="panel panel-default">
			  <div class="panel-heading">
				  <h4 class="panel-title">
					  <a class="accordion-toggle" data-toggle="collapse" data-parent="#csvAccordion" href="#csvCollapseTwo">
						  Registros
					  </a>
				  </h4>
			  </div>
			  <div id="csvCollapseTwo" class="panel-collapse collapse">
				  <div class="panel-body">
					  <p>Cada registro deve ocupar uma única linha, com os campos separados por vírgula. Você deve garantir que no conteúdo dos c
					  campos não tenha o caractere vírgula <b>(,)</b>, para evitar erros na leitura.</p>
				  </div>
			  </div>
		  </div>
		  <div class="panel panel-default">
			  <div class="panel-heading">
				  <h4 class="panel-title">
					  <a class="accordion-toggle" data-toggle="collapse" data-parent="#csvAccordion" href="#csvCollapseThree">
						  Exportando de Planilhas para CSV
					  </a>
				  </h4>
			  </div>
			  <div id="csvCollapseThree" class="panel-collapse collapse">
				  <div class="panel-body">
					  <p>As planilhas eletrônicas mais conhecidas (Excell e LibreOffice) possuem a funcionalidade de exportar
					  para arquivos CSV. Basta escolher o menu <b>Arquivo/Salvar como</b> e selecionar o formato adequado (normalmente "Texto CSV" ou "Arquivo CSV".</p>
				  </div>
			  </div>
		  </div>
	  </div> <!-- panel-group -->
  </div> <!-- col-lg-6 -->
</div> <!-- row -->
