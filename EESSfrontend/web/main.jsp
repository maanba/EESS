<%@include file="WEB-INF/jspf/header.jspf" %>
SKRIV KODE HER

<form name="firstElection" action="Controller" method="POST">
    <button type="submit" name="command" value="toFirstElectionPage">V�lg prioriteter</button>
    <button type="submit" name="command" value="toSecondElectionPage">V�lg prioriteter2</button>
    <button type="submit" name="command" value="toAdministrationPage">Administration</button>
</form>

<%@include file="WEB-INF/jspf/footer.jspf" %>