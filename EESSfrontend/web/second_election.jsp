<%@include file="WEB-INF/jspf/header.jspf" %>
<c:set var="countA" value="0" scope="page"/>
<c:set var="countB" value="0" scope="page"/>
<script>
//    window.onload = function check(theForm);
    function saveChecked(id, priority)
    {
        var result = result + id, ", " + priority + ";";
        document.getElementById("checked").value = result;
    }
    
    function checkA()
    {
        console.log(${poolaamount});
        console.log(${countA});
        var amount = ${poolaamount}-1;
        for(var i = amount; i >= 0; i--)
        {
            console.log("hej fra din forløkke");
            var firstCheck = document.getElementById('first'+i);
            var secondCheck = document.getElementById('second'+i);
            if(firstCheck.checked)
            {
                saveChecked(i, 1);
                console.log("YAY! FirstCheck == checked");
            }
            if(secondCheck.checked)
            {
                saveChecked(i, 2);
            }
        }
    }
    function checkB()
    {
        console.log(${poolbamount});
        console.log(${countB});
        var amount = ${poolaamount}-1;
        for(var i = amount; i >= 0; i--)
        {
            console.log("hej fra din forløkke");
            var firstCheck = document.getElementById('first'+i);
            var secondCheck = document.getElementById('second'+i);
            if(firstCheck.checked)
            {
                saveChecked(i, 1);
                console.log("YAY! FirstCheck == checked");
            }
            if(secondCheck.checked)
            {
                saveChecked(i, 2);
            }
        }
    }
    
    function checkAll()
    {
        checkA();
        checkB();
    }
</script>

<div>
    <p>
    <h1>Vejledning</h1>
    Vælg en første prioritet og en anden prioritet i hver af puljerne.
</p>
</div>
<form name="tabel_formA" action="Controller" method="POST">
    <table name="" style="width:300px">
        <tr>
            <td rowspan="4">Pulje A</td>
        </tr>
        <c:forEach var="subject" items="${poolA}">
            <tr>
                <td>${subject.subjectName}</td>
                <td><input type="checkbox" name="${subject.id}_1" value="first" id="first${countA}"></td>
                <td><input type="checkbox" name="${subject.id}_2" value="second" id="second${countA}"></td>
            <c:set var="count" value="${countA + 1}" scope="page"/>
            </tr>
        </c:forEach>
    </table>
</form>
<form name="tabel_formB" action="Controller" method="POST">
    <table name="" style="width:300px">
        <tr>
            <td rowspan="4">Pulje B</td>
        </tr>
        <c:forEach var="subject" items="${poolB}">
            <tr>
                <td>${subject.subjectName}</td>
                <td><input type="checkbox" name="${subject.id}_1" value="first" id="first${countB}"></td>
                <td><input type="checkbox" name="${subject.id}_2" value="second" id="second${countB}"></td>
            <c:set var="count" value="${countB + 1}" scope="page"/>
            </tr>
        </c:forEach>
    </table>
</form>
<%@include file="WEB-INF/jspf/footer.jspf" %>