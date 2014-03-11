<%@include file="WEB-INF/jspf/header.jspf" %>
<c:set var="countA" value="0" scope="page"/>
<c:set var="countB" value="0" scope="page"/>
<script>
//    window.onload = function check(theForm);
    function saveChecked(id, priority)
    {
        var result = result + id, ", " + priority + ";";
                document.getElementById("checkedSecond").value = result;
    }

    function checkA()
    {
        var amount = ${poolaamount} - 1;
        for (var i = amount; i >= 0; i--)
        {
            var firstACheck = document.getElementById('firstA' + i);
            if (firstACheck.checked)
            {
                saveChecked(i, 1);
            }
            else{
                
            }
            var secondACheck = document.getElementById('secondA' + i);
            if (secondACheck.checked)
            {
                saveChecked(i, 2);
            }
        }
    }

    function checkB()
    {
        var amount = ${poolbamount} - 1;
        for (var i = amount; i >= 0; i--)
        {
            var firstBCheck = document.getElementById('firstB' + i);
            if (firstBCheck.checked)
            {
                saveChecked(i, 1);
            }
            var secondBCheck = document.getElementById('secondB' + i);
            if (secondBCheck.checked)
            {
                saveChecked(i, 2);
            }
        }
    }

    function saveAll()
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
<div>
    <form name="tabel_formA" action="Controller" method="POST">
        <table name="" style="width: 300px; float: left;">
            <tr>
                <td colspan="4">Pulje A</td>
            </tr>
            <c:forEach var="subject" items="${poolA}">
                <tr>
                    <td>${subject.subjectName}</td>
                    <td><input type="checkbox" name="${subject.id}_1" value="firstA" id="firstA${countA}"></td>
                    <td><input type="checkbox" name="${subject.id}_2" value="secondA" id="secondA${countA}"></td>
                <c:set var="countA2" value="${countA + 1}" scope="page"/>
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
                    <td><input type="checkbox" name="${subject.id}_1" value="firstB" id="firstB${countB}"></td>
                    <td><input type="checkbox" name="${subject.id}_2" value="secondB" id="secondB${countB}"></td>
                <c:set var="countB2" value="${countB + 1}" scope="page"/>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>
<button class="sendSecond" name="command" value="savePriorities" type="submit" onclick="saveAll();">Send mine prioriteter</button>
<input type="hidden" name="checked" value="" id="checkedSecond">

<%@include file="WEB-INF/jspf/footer.jspf" %>