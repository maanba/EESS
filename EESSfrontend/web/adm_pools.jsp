<%@include file="WEB-INF/jspf/header.jspf" %>

<script>
    function moveBetweenLists(listFrom, listTo) {
        var SelID = '';
        var SelText = '';
        // Move rows from SS1 to SS2 from bottom to top
        for (var i = listFrom.options.length - 1; i >= 0; i--)
        {
            if (listFrom.options[i].selected == true)
            {
                SelID = listFrom.options[i].value;
                SelText = listFrom.options[i].text;
                var newRow = new Option(SelText, SelID);
                listTo.options[listTo.length] = newRow;
                listFrom.options[i] = null;
            }
        }
    }

    function getById(id) {
        return document.getElementById(id);
    }

    function init() {
        checkHappiness();
        derp();
    }

    var students = [];

    function initArray() {
        var studentList = document.getElementById("pools_list_students");
        for (i = 0; i < studentList.length; i++) {
            var studentString = studentList[i].value;
            var student = JSON.parse(studentString);
            students[i] = student;
        }
    }

    function checkHappiness() {
        var poolA = document.getElementById("pools_list_a");
        for (i = 0; i < students.length; i++) {
            var student = students[i];
            student["happiness"] = 0;
            console.log(student.name);
            for (j = 0; j < student.firstPriorities.length; j++) {
                var subject = student.firstPriorities[j].subjectName;
                for (l = 0; l < poolA.length; l++) {
                    console.log(poolA[l].value);
                }
            }
        }
    }

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

    addLoadEvent(initArray);
    addLoadEvent(checkHappiness);
</script>

<div id="pools_container">
    <div style="float: left;">
        <label id="pool_Label_none">Subjects</label>
        <select id="pools_list_none" multiple="true">
            <c:forEach var="subject" items="${subjects_none}">
                <option>${subject}</option>
            </c:forEach>
        </select>
    </div>
    <div id="pools_button_container">
        <br/>
        <br/>
        <br/>
        <br/>
        <div id="button_a_container">
            <input type="button" class="pool_button_arrow" value="==>>" onclick="moveBetweenLists(getById('pools_list_none'), getById('pools_list_a'));" />
            <div>
                <input type="button" class="pool_button_arrow" value="<<==" onclick="moveBetweenLists(getById('pools_list_a'), getById('pools_list_none'));" />
            </div>
        </div>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <div>
            <input type="button" class="pool_button_arrow" value="==>>" onclick="moveBetweenLists(getById('pools_list_none'), getById('pools_list_b'));" />
            <div>
                <input type="button" class="pool_button_arrow" value="<<==" onclick="moveBetweenLists(getById('pools_list_b'), getById('pools_list_none'));" />
            </div>
        </div>

    </div>

    <div style="float: left">
        <Label class="pool_Label">Pool A</Label>
        <div>
            <select class="pools_list_ab" id="pools_list_a" multiple="true">
                <c:forEach var="subject" items="${subjects_a}">
                    <option value="${subject}">${subject}</option>
                </c:forEach>
            </select>
        </div>

        <label class="pool_Label">Pool B</label>
        <div>
            <select class="pools_list_ab" id="pools_list_b" multiple="true">
                <c:forEach var="subject" items="${subjects_b}">
                    <option value="${subject}">${subject}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div>
        <label id="pool_Label_students">Students</label>
        <c:set var="count" value="0" scope="page" />
        <select multiple="true" id="pools_list_students">
            <c:forEach var="student" items="${student_list}">
                <option value='${json_students[count]}'>${student.name}</option>
                <c:set var="count" value="${count + 1}" scope="page" />
            </c:forEach>
        </select>
    </div>
</div>



<%@include file="WEB-INF/jspf/footer.jspf" %>