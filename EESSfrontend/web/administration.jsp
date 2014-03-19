<%@include file="WEB-INF/jspf/header.jspf" %>
<script>
    function addLoadEvent(func) {
        var oldonload = window.onload;
        if (typeof window.onload != 'function') {
            window.onload = func;
        } else {
            window.onload = function() {
                if (oldonload) {
                    oldonload();
                }
                func();
            }
        }
    }

    function loadData() {
        var table = document.getElementById('subject_table');

        var asubject = '${subjectA}';
        asubject = JSON.parse(asubject);
        var row = table.insertRow(1);
        var cell1 = row.insertCell(0);
        cell1.innerHTML = asubject.subjectName;
        var cell2 = row.insertCell(1);
        cell2.innerHTML = asubject.teacher;
        var cell3 = row.insertCell(2);
        cell3.innerHTML = '${studentsSubjectA}';

        var bsubject = '${subjectB}';
        bsubject = JSON.parse(bsubject);
        var row = table.insertRow(2);
        var cell1 = row.insertCell(0);
        cell1.innerHTML = bsubject.subjectName;
        var cell2 = row.insertCell(1);
        cell2.innerHTML = bsubject.teacher;
        var cell3 = row.insertCell(2);
        cell3.innerHTML = '${studentsSubjectB}';
        

        var csubject = '${subjectC}';
        csubject = JSON.parse(csubject);
        var row = table.insertRow(3);
        var cell1 = row.insertCell(0);
        cell1.innerHTML = csubject.subjectName;
        var cell2 = row.insertCell(1);
        cell2.innerHTML = csubject.teacher;
        var cell3 = row.insertCell(2);
        cell3.innerHTML = '${studentsSubjectC}';

        var dsubject = '${subjectD}';
        dsubject = JSON.parse(dsubject);
        var row = table.insertRow(4);
        var cell1 = row.insertCell(0);
        cell1.innerHTML = dsubject.subjectName;
        var cell2 = row.insertCell(1);
        cell2.innerHTML = dsubject.teacher;
        var cell3 = row.insertCell(2);
        cell3.innerHTML = '${studentsSubjectD}';



    }
    addLoadEvent(loadData);
</script>
<h1>Opsummering<h1/>
    </br>
    <form name="tabel_form" action="Controller" method="POST">
        <table name="" style="width:800px" id="subject_table">
            <tr>
                <td>Fag</td>
                <td>Lærer</td>
                <td>Elever</td>
            </tr>
        </table>
        <input type="text" name="checked" value="" id="checked">
        <div>
            <button name="command" value="createFile" type="submit" onclick="" action="Controller?command=createFile">Gem som .txt fil</button>
        </div>
    </form>

    <%@include file="WEB-INF/jspf/footer.jspf" %>