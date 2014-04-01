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
            document.onload = function() 
            {
                timer();
            };
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
                if (UrlExists('http://localhost:8080/EESSfrontend/electivesubjects.dat')) {
                    var loader = document.getElementById('loader');
                    loader.style.display = 'none';
                    var downloadlink = document.getElementById('link');
                    downloadlink.style.display = 'block';

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
        <h1>download link vises indenfor 10 sekunder</h1>
        <img src="http://localhost:8080/EESSfrontend/loading.gif" id="loader" style="height: 50px; width: 50px;"/>
        <div style="display: none" id="link">
            <a href="http://localhost:8080/EESSfrontend/electivesubjects.dat" download="electivesubjects.dat">Download</a>
        </div>
    </body>
</html>
