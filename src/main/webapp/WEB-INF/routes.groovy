
get "/", forward: "/WEB-INF/pages/index.gtpl"
get "/datetime", forward: "/datetime.groovy"

get "/favicon.ico", redirect: "/images/gaelyk-small-favicon.png"

get "/cert", forward: "/cert.groovy"

get "/upload", forward: "/WEB-INF/pages/upload.gtpl"
get "/success", forward: "/WEB-INF/pages/success.gtpl"
get "/failure", forward: "/WEB-INF/pages/failure.gtpl"
