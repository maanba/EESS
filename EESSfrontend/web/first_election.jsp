<%@include file="WEB-INF/jspf/header.jspf" %>

<form name="tabel_form" action="Controller" method="POST">
<table style="width:300px">
<tr>
  <td>Fag</td>
  <td>1. prioritet</td>
  <td>2. prioritet</td>
</tr>
    <c:forEach var="subject" items="${subjects}">
        <tr>
            <td>${subject.name}</td>
            <td><input type="checkbox" name="${subject.name}" value="first"></td>
            <td><input type="checkbox" name="${subject.name}" value="second"></td>
        </tr>
    </c:forEach>
</table>
    <div>
        <button name="save_priorities" value="savePriorities">Send mine prioriteter</button>
    </div>
</form>

<%@include file="WEB-INF/jspf/footer.jspf" %>