<%@include file="WEB-INF/jspf/header.jspf" %>
<c:set var="countA" value="0" scope="page"/>
<c:set var="countB" value="0" scope="page"/>
<script>
//    window.onload = function check(theForm);
    function saveChecked(id, priority, pool)
    {
        var result = document.getElementById("checked").value + "," + id + "," + priority + "," + pool + ";";
        document.getElementById("checked").value = result;
    }

    function checkA()
    {
        var amount = ${poolaamount} - 1;
        var numberOfCheckedA = 0;
        var numberOfCheckedB = 0;
        for (var i = amount; i >= 0; i--){
            var firstACheck = document.getElementById('firstA' + i);
            var secondACheck = document.getElementById('secondA' + i);
            if (firstACheck.checked){
                saveChecked(firstACheck.name, 1, "A");
                numberOfCheckedA++;
            }
            if (secondACheck.checked){
                saveChecked(secondACheck.name, 2, "A");
                numberOfCheckedB++;
            }
        }
        console.log(numberOfCheckedA + " ," + numberOfCheckedB);
        if ((numberOfCheckedA === 1) && (numberOfCheckedB === 1)){
            return true;
        } else {
            return false;
        }
    }

    function checkB()
    {
        var amount = ${poolbamount} - 1;
        var numberOfCheckedA = 0;
        var numberOfCheckedB = 0;
        for (var i = amount; i >= 0; i--)
        {
            var firstBCheck = document.getElementById('firstB' + i);
            var secondBCheck = document.getElementById('secondB' + i);
            if (firstBCheck.checked){
                saveChecked(firstBCheck.name, 1, "B");
                numberOfCheckedA++;
            }
            if (secondBCheck.checked){
                saveChecked(secondBCheck.name, 2, "B");
                numberOfCheckedB++;
            }
        }
        console.log(numberOfCheckedA + " ," + numberOfCheckedB);
        if ((numberOfCheckedA === 1) && (numberOfCheckedB === 1)){
            return true;
        } else {
            return false;
        }
    }

    function checkAll()
    {
        var boolA = checkA();
        var boolB = checkB();
        console.log(boolA + " ," + boolB);
        if (boolA && boolB){
            return true;
        } else {
            return false;
        }
        
    }
</script>

<div>
    <p>
    <h1>Vejledning</h1>
    V�lg en f�rste prioritet og en anden prioritet i hver af puljerne.
</p>
</div>
<div>
    <form name="tabel_formA" action="Controller" method="POST">
        <table name="" style="width: 300px; float: left;">
            <tr>
                <td colspan="4">Pulje A</td>
            </tr>
            <c:forEach var="subject" items="${poolA}">
                <tr>
                    <td>${subject.subjectName}</td>
                    <td><input type="checkbox" name="${subject.id}" value="firstA" id="firstA${countA}"></td>
                    <td><input type="checkbox" name="${subject.id}" value="secondA" id="secondA${countA}"></td>
                <c:set var="countA" value="${countA + 1}" scope="page"/>
                </tr>
            </c:forEach>
        </table>
    </form>
    <form name="tabel_formB" action="Controller" method="POST" style="height: 150px;">
        <table name="" style="width: 300px;">
            <tr>
                <td colspan="4">Pulje B</td>
            </tr>
            <c:forEach var="subject" items="${poolB}">
                <tr>
                    <td>${subject.subjectName}</td>
                    <td><input type="checkbox" name="${subject.id}" value="firstB" id="firstB${countB}"></td>
                    <td><input type="checkbox" name="${subject.id}" value="secondB" id="secondB${countB}"></td>
                <c:set var="countB" value="${countB + 1}" scope="page"/>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>
<form onsubmit="return checkAll();" method="POST">
    <button class="sendSecond" name="command" value="savesecondpriorities" type="submit"/>Save priorities</button>
    <input type="hidden" name="checked" value="" id="checked">
</form>

<%@include file="WEB-INF/jspf/footer.jspf" %>