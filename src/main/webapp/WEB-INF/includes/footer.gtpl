    <hr>
    
    <div id="footer">
      <div class="container">
        <p class="text-muted credit">Desenvolvido por <a href="http://github.com/ratodigital">Rato Digital</a>, 2013.</p>

      </div>
    </div>
    
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->

    <script src="/js/bootstrap.min.js"></script>
		<script>
		
		function showDivPdf() {
			toogle('divPdf');
      hide('divCsv');      
      hide('divEmail');
      toogleOff('btnCsv');
      toogleOff('btnEmail');
      window.location = '#divPdf';
		}
		
		function showDivCsv() {
      hide('divPdf');
			toogle('divCsv');
      hide('divEmail');      			
      toogleOff('btnPdf');
      toogleOff('btnEmail');
      window.location = '#divCsv';      
		}

		function showDivEmail() { 
      hide('divPdf');
      hide('divCsv');      
			toogle('divEmail');
      toogleOff('btnPdf');
      toogleOff('btnCsv');
      window.location = '#divEmail';
		}

		function show(divId) {
  		(jQuery)('#'+divId).show();
		}
				
		function hide(divId) {
  		(jQuery)('#'+divId).hide();
		}
		
		function toogleOff(btn) {
//		  (jQuery)('#'+btn).button('reset');
      (jQuery)('#'+btn).removeClass('active');
    }
    
		function toogle(divId, showOrHide) {
      if (((jQuery)('#'+divId).css("display") == 'none')) {
        show(divId);
      } else {
        hide(divId);
      }
		}
		
    function scrollToDiv(element,navheight){
      var offset = element.offset();
      var offsetTop = offset.top;
      var totalScroll = offsetTop-navheight;
      (jQuery)('body,html').animate({
        scrollTop: totalScroll
      }, 500);
    }		
    
    function submitPreview() {
      document.getElementById('status').value = "PREVIEW";
      document.pdfForm.submit();
    }
    
    function submitForm() {
      document.getElementById('status').value = "SEND_EMAILS";
      document.pdfForm.submit();
    }					    
		</script>		
		<script>
		  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
		  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
		  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
		  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

		  ga('create', 'UA-43602420-1', 'certificadospdf.appspot.com');
		  ga('send', 'pageview');

		</script>	  
  </body>
</html>
