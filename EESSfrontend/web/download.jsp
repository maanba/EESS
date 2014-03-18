<%-- 
    Document   : download
    Created on : 18-03-2014, 09:32:38
    Author     : Janne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script>
            var count = 30;

            var counter = setInterval(timer, 1000); //1000 will  run it every 1 second

            function timer()
            {
                count = count - 1;
                if (count <= 0)
                {
                    clearInterval(counter);
                    return;
                }
                if (UrlExists('http://localhost:8080/EESSfrontend/electivesubjects.dat')){
                    var downloadlink = Document.getElementById('link');
                    downloadlink.hidden = false;
                }
            }

            function UrlExists(url)
            {
                var http = new XMLHttpRequest();
                http.open('HEAD', url, false);
                http.send();
                return http.status !== 404;
            }
        </script>
        <title>Download Page</title>
    </head>
    <body>
        <h1>Højreklik og gem linket på nedenstående link for at hente data filen</h1>
        <a href="http://localhost:8080/EESSfrontend/electivesubjects.dat" download="electivesubjects.dat" type="hidden" id="link">Download
        </a>
    </body>
</html>
