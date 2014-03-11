<%@include file="WEB-INF/jspf/header.jspf" %>

<form name="tabel_form" action="Controller" method="POST">
<table name="" style="width:300px">
<tr>
  <td>Fag</td>
  <td>1. prioritet</td>
  <td>2. prioritet</td>
</tr>
    <c:forEach var="subject" items="${subjects}">
        <tr> 
            <td>${subject.subjectName}</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <c:set var="count" value="${count + 1}" scope="page"/>
        </tr>
    </c:forEach>
</table>
    <input type="text" name="checked" value="" id="checked">
    <div>
        <button name="command" value="savePriorities" type="submit" onclick="check();">Send mine prioriteter</button>
    </div>
</form>

<%@include file="WEB-INF/jspf/footer.jspf" %>