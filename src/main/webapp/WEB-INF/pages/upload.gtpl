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
      <div class="progress">
        <%
        def percent = 33
        def title = "Template PDF (1/3)"
        if (request.status == 'GETCSV') {
          percent = 66
          title = "Dados CSV (2/3)"
        } else if (request.status == 'GETMSGDATA') {
          title = "Enviar Email (3/3)"
          percent = 100
        }
        %>
        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="${percent}" aria-valuemin="0" aria-valuemax="100" style="width: ${percent}%">
        </div>
      </div>
    </div>
    <div class="page-header">
      <h1>$title<!--<small>subtitle</small>--></h1>
    </div>        
	  <div class="row">
	    <div class="col-md-2">  
        <%
        def image = "pdf"
        if (request.status == 'GETCSV') {
          image = "csv"
        } else if (request.status == 'GETMSGDATA') {
          image = "email"
        }
        %>	    
  	    <img src="/images/${image}.png" width="128px" height="128px" alt="PDF">    
	    </div>	  
	    
	    <div class="col-md-10">

        <form id="pdfForm" class="form-horizontal" role="form" action="${blobstore.createUploadUrl('/upload.groovy')}"
        method="post" enctype="multipart/form-data">
          <input name="pdfKey" type="hidden" value="$request.pdfKey"/>
          <input name="pdfName" type="hidden" value="$request.pdfName"/>  
          <input name="pdfFields" type="hidden" value="$request.pdfFields"/>    

          <%
          if (request.status == 'GETPDF') {
          %>       
          <input name="status" type="hidden" value="GETCSV"/>          
  			  <div class="form-group input-lg">
    			  <label for="file" class="col-lg-2 control-label">PDF</label>
					  <span class="input-group-btn">
              <input type="file" name="pdfFile"/><br/>
					  </span>
				  </div>   
				  <%  
          } else if (request.status == 'GETCSV') {
          %>
          <input type="hidden" name="status" value="GETMSGDATA">
  			  <div class="form-group input-lg">
    			  <label for="file" class="col-lg-2 control-label">CSV</label>
					  <span class="input-group-btn">
              <input type="file" name="csvFile"/><br/>
					  </span>
				  </div>              
          <%
          } else if (request.status == 'GETMSGDATA') {
          %>
          <input type="hidden" id="status" name="status" value="SENDPDF"/>  
          <input name="csvKey" type="hidden" value="$request.csvKey"/>          
          
          <div class="form-group">
            <label for="fromEmail" class="col-lg-2 control-label">Email do rementente</label>
            <div class="col-lg-10">
              <input type="email" class="form-control" id="fromEmail" placeholder="Email" value="certificadospdf@gmail.com" disabled>
            </div>
          </div>
          
          <div class="form-group">
            <label for="fromName" class="col-lg-2 control-label">Nome do rementente</label>
            <div class="col-lg-10">
              <input type="text" class="form-control" id="fromName" value="Certificados PDF">
            </div>
          </div>    
          
          <div class="form-group">
            <label for="subject" class="col-lg-2 control-label">Assunto</label>
            <div class="col-lg-10">
              <input type="text" class="form-control" id="subject" value="Seu certificado está pronto!">
            </div>
          </div>    
          
          <div class="form-group">
            <label for="message" class="col-lg-2 control-label">Mensagem *</label>
            <div class="col-lg-10">
                <textarea name="message" class="form-control" rows="5">
Olá,

Seu certificado de participação segue em anexo.

Atenciosamente
---
Certificados PDF
certificadospdf.appspot.com
                </textarea>
            </div>
          </div>              

          <div class="form-group">
            <label for="message" class="col-lg-2 control-label"></label>
            <div class="col-lg-10">
                * Você pode utilizar os campos $request.pdfFields
            </div>
          </div>    

          <br/> 
          <div class="form-actions">
            <%
            }
            def submitButton = "Próximo <span class=\"glyphicon glyphicon-chevron-right\">"
            if (request.status == 'GETMSGDATA') {
            %>
            <div class="pull-left">
              <button class="btn btn-primary btn-lg" onclick="submitPreview();"><span class="glyphicon glyphicon-eye-open"></span> Preview</button>
              <script type="text/javascript">
                function submitPreview() {
                  document.getElementById('status').value = "PREVIEW";
                  document.pdfForm.submit();
                }
              </script>  
            </div>
            <%
              submitButton = "Enviar certificados <span class=\"glyphicon glyphicon-ok\">"            
            }
            %>
            <div class="pull-right">
              <button class="btn btn-primary btn-lg" onclick="document.pdfForm.submit();">$submitButton</span></button>
            </div>
          </div>
        </form>	                             

      </div>
    </div>
  </div>
<% include '/WEB-INF/includes/footer.gtpl' %>

