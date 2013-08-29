    <hr>
    
    <div id="footer">
      <div class="container">
        <p class="text-muted credit">Desenvolvido por <a href="http://github.com/ratodigital">Rato Digital</a>, 2013.</p>

      </div>
    </div>
    
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="/js/jquery-1.7.2.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
	  <script>
		  (jQuery)(document)
			  .on('change', '.btn-file :file', function() {
				  var input = (jQuery)(this),
				  numFiles = input.get(0).files ? input.get(0).files.length : 1,
				  label = input.val();//.replace(/\\/g, '/').replace(/.*/\\/, '');
				  input.trigger('fileselect', [numFiles, label]);
		  });
		
		  (jQuery)(document).ready( function() {
			  (jQuery)('.btn-file :file').on('fileselect', function(event, numFiles, label) {
				
				  var input = (jQuery)(this).parents('.input-group').find(':text'),
					  log = numFiles > 1 ? numFiles + ' files selected' : label;
				
				  if( input.length ) {
					  input.val(log);
				  } else {
					  if( log ) alert(log);
				  }
				
			  });
		  });		
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
