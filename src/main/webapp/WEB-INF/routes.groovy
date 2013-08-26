
//get "/", forward: "/WEB-INF/pages/index.gtpl"
get "/datetime", forward: "/datetime.groovy"

get "/favicon.ico", redirect: "/images/gaelyk-small-favicon.png"

//post "/certificado", forward: "/certificado.groovy"
get "/", forward: "/WEB-INF/pages/uploadpdf.gtpl"
get "/uploadcsv", forward: "/WEB-INF/pages/uploadcsv.gtpl"

get "/success", forward: "/WEB-INF/pages/success.gtpl"
get "/failure", forward: "/WEB-INF/pages/failure.gtpl"
