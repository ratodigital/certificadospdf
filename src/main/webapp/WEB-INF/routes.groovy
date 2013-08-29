
//get "/", forward: "/WEB-INF/pages/index.gtpl"

get "/favicon.ico", redirect: "/images/certificados.png"

get "/", forward: "/WEB-INF/pages/index.gtpl"
get "/upload", forward: "/upload.groovy"
get "/success", forward: "/WEB-INF/pages/success.gtpl"
get "/failure", forward: "/WEB-INF/pages/failure.gtpl"


