<%@include file="WEB-INF/jspf/header.jspf" %>
<c:set var="count" value="0" scope="page"/>
<script type="text/javascript">
    //window.onload = function check();
    function saveChecked(id, priority)
    {
        var result = document.getElementById("checked").value + "," + id + "," + priority + ";";
        document.getElementById("checked").value = result;
        console.log(result);
    }
    
    function check()
    {
        console.log(${subamount});
        console.log(${count});
        var amount = ${subamount}-1;
        console.log(amount + " is amount");
        for(var i = amount; i >= 0; i--)
        {
            console.log("hej fra din forløkke");
            var firstCheck = document.getElementById('first'+i);
            var secondCheck = document.getElementById('second'+i);
            if(firstCheck.checked)
            {
                saveChecked(firstCheck.name, 1);
                console.log(firstCheck.name + " = firstCheck.name");
            }
            if(secondCheck.checked)
            {
                saveChecked(secondCheck.name, 2);
                console.log(secondCheck.name + " = secondCheck.name");
            }
        }
    }
</script>

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
            <td><input type="checkbox" name="${subject.id}" value="first" id="first${count}"></td>
            <td><input type="checkbox" name="${subject.id}" value="second" id="second${count}"></td>
            <c:set var="count" value="${count + 1}" scope="page"/>
        </tr>
    </c:forEach>
</table>
    <input type="hidden" name="checked" value="" id="checked">
    <div>
        <button name="command" value="savePriorities" type="submit" onclick="check();">Send mine prioriteter</button>
    </div>
</form>

<%@include file="WEB-INF/jspf/footer.jspf" %>