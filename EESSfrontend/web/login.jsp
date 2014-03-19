<%@include file="/WEB-INF/jspf/header.jspf" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <div class="centerBody">

            <h2>Login</h2>
            Log ind med dit ID og kodeord.<br>
            <br>
            <form name="j_security_check" action="FrontController" onsubmit="return validateFormOnSubmit(login);" method="POST">
                <div style="width: 700px;">
                    <span class="textBox">ID Nummer:</span><input class="form-field" type="text" name="j_username"><br>
                    <span class="textBox">Kodeord:</span><input class="form-field" type="password" name="j_password"><br>
                </div>
                <button class="customButton" type="submit" name="command" value="login_command">Login</button>
                <button class="customButton" type="submit" name="command" value="toMain">Cancel</button>
            </form>
        </div>
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
    </body>
</html>