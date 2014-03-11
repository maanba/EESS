<%@include file="WEB-INF/jspf/header.jspf" %>
SKRIV KODE HER

<form name="firstElection" action="Controller" method="POST">
    <button type="submit" name="command" value="toFirstElectionPage">Vælg prioriteter</button>
    <button type="submit" name="command" value="toSecondElectionPage">Vælg prioriteter2</button>
</form>

<%@include file="WEB-INF/jspf/footer.jspf" %>