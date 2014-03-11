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
        console.clear();
        var poolA = document.getElementById("pools_list_a");
        var poolB = document.getElementById("pools_list_b");
        var listStudents = document.getElementById("pools_list_students");
        for (i = 0; i < students.length; i++) {
            var student = students[i];
            var hasSubjectInA = false;
            var hasSubjectInB = false;
            student["happiness"] = 0;
            for (j = 0; j < student.firstPriorities.length; j++) {
                var subject = student.firstPriorities[j].subjectName;
                for (l = 0; l < poolA.length; l++) {
                    if (hasSubjectInA == false) {
                        var poolSubject = poolA[l].value;
                        poolSubject = JSON.parse(poolSubject).subjectName;
                        if (poolSubject == subject) {
                            student["happiness"] = student["happiness"] + 50;
                            hasSubjectInA = true;
                        }
                    }
                }
            }
            for (j = 0; j < student.secondPriorities.length; j++) {
                var subject = student.secondPriorities[j].subjectName;
                for (l = 0; l < poolA.length; l++) {
                    if (hasSubjectInA == false) {
                        var poolSubject = poolA[l].value;
                        poolSubject = JSON.parse(poolSubject).subjectName;
                        if (poolSubject == subject) {
                            student["happiness"] = student["happiness"] + 25;
                            hasSubjectInA = true;
                        }
                    }
                }
            }
            // FOR POOL B:
            for (j = 0; j < student.secondPriorities.length; j++) {
                var subject = student.secondPriorities[j].subjectName;
                for (l = 0; l < poolB.length; l++) {
                    if (hasSubjectInB == false) {
                        var poolSubject = poolB[l].value;
                        poolSubject = JSON.parse(poolSubject).subjectName;
                        if (poolSubject == subject) {
                            student["happiness"] = student["happiness"] + 50;
                            hasSubjectInB = true;
                        }
                    }
                }
            }
            for (j = 0; j < student.secondPriorities.length; j++) {
                var subject = student.secondPriorities[j].subjectName;
                for (l = 0; l < poolB.length; l++) {
                    if (hasSubjectInB == false) {
                        var poolSubject = poolB[l].value;
                        poolSubject = JSON.parse(poolSubject).subjectName;
                        if (poolSubject == subject) {
                            student["happiness"] = student["happiness"] + 25;
                            hasSubjectInB = true;
                        }
                    }
                }
            }
        }
        students.sort(function(a, b) {
            return a.happiness - b.happiness;
        });
        for (i = 0; i < students.length; i++) {
            var student = students[i];
            var option = listStudents[i];
            option.text = student.name;
            option.value = student;
            if (student.happiness >= 75) {
                option.style.backgroundColor = "#00FF00";
            } else if (student.happiness >= 50) {
                option.style.backgroundColor = "yellow";
            } else {
                option.style.backgroundColor = "#FF1313";
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

    function generateHiddenFields() {
        var form = document.forms['form_save_pools'];
        var listnone = getById("pools_list_none");
        for (i = 0; i < listnone.options.length; i++) {
            var input = document.createElement('input');
            input.type = 'hidden';
            input.name = 'subjects_none';
            input.value = listnone.options[i].value;
            form.appendChild(input);
        }
        var lista = getById("pools_list_a");
        for (i = 0; i < lista.options.length; i++) {
            var input = document.createElement('input');
            input.type = 'hidden';
            input.name = 'subjects_a';
            input.value = lista.options[i].value;
            form.appendChild(input);
        }
        var listb = getById("pools_list_b");
        for (i = 0; i < listb.options.length; i++) {
            var input = document.createElement('input');
            input.type = 'hidden';
            input.name = 'subjects_b';
            input.value = listb.options[i].value;
            form.appendChild(input);
        }
        return true;
    }

    function populateLists() {
        var iniListNone = getById("pools_list_none");
        var subjectsnone = '${subjects_none}';
        var iniListA = getById("pools_list_a");
        var subjectsA = '${subjects_a}';
        subjectsnone = JSON.parse(subjectsnone);
        subjectsA = JSON.parse(subjectsA);
        var iniListB = getById("pools_list_b");
        var subjectsB = '${subjects_b}';
        subjectsB = JSON.parse(subjectsB);
        for (i = 0; i < subjectsnone.length; i++) {
            var opt = document.createElement('option');
            opt.value = JSON.stringify(subjectsnone[i]);
            opt.innerHTML = subjectsnone[i].subjectName + " - " + subjectsnone[i].teacher;
            iniListNone.appendChild(opt);
        }
        for (i = 0; i < subjectsA.length; i++) {
            var opt = document.createElement('option');
            opt.value = JSON.stringify(subjectsA[i]);
            opt.innerHTML = subjectsA[i].subjectName + " - " + subjectsA[i].teacher;
            iniListA.appendChild(opt);
        }
        for (i = 0; i < subjectsB.length; i++) {
            var opt = document.createElement('option');
            opt.value = JSON.stringify(subjectsB[i]);
            opt.innerHTML = subjectsB[i].subjectName + " - " + subjectsB[i].teacher;
            iniListB.appendChild(opt);
        }
    }

    addLoadEvent(populateLists);
    addLoadEvent(initArray);
    addLoadEvent(checkHappiness);
</script>

<div id="pools_container">
    <div style="float: left;">
        <label id="pool_Label_none">Subjects</label>
        <select id="pools_list_none" multiple="true">
            <%--<c:forEach var="subject" items="${subjects_none}">--%>
                <!--<option>${subject}</option>-->
            <%--</c:forEach>--%>

        </select>
    </div>
    <div id="pools_button_container">
        <br/>
        <br/>
        <br/>
        <br/>
        <div id="button_a_container">
            <input type="button" class="pool_button_arrow" value="==>>" onclick="moveBetweenLists(getById('pools_list_none'), getById('pools_list_a'));
                    checkHappiness();" />
            <div>
                <input type="button" class="pool_button_arrow" value="<<==" onclick="moveBetweenLists(getById('pools_list_a'), getById('pools_list_none'));
                        checkHappiness();" />
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
            <input type="button" class="pool_button_arrow" value="==>>" onclick="moveBetweenLists(getById('pools_list_none'), getById('pools_list_b'));
                    checkHappiness();" />
            <div>
                <input type="button" class="pool_button_arrow" value="<<==" onclick="moveBetweenLists(getById('pools_list_b'), getById('pools_list_none'));
                        checkHappiness();" />
            </div>
        </div>

    </div>

    <div style="float: left">
        <Label class="pool_Label">Pool A</Label>
        <div>
            <select class="pools_list_ab" id="pools_list_a" multiple="true">
                <%--<c:forEach var="subject" items="${subjects_a}">--%>
                    <!--<option value="${subject}">${subject}</option>-->
                <%--</c:forEach>--%>
            </select>
        </div>

        <label class="pool_Label">Pool B</label>
        <div>
            <select class="pools_list_ab" id="pools_list_b" multiple="true">
                <%--<c:forEach var="subject" items="${subjects_b}">--%>
                    <!--<option value="${subject}">${subject}</option>-->
                <%--</c:forEach>--%>
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
        <div>
            <form id="form_save_pools" method="post" onsubmit="return generateHiddenFields();" action="Controller?command=save_pools">
                <input type="submit" class="button_std" value="Submit" />
            </form>
        </div>
    </div>
</div>



<%@include file="WEB-INF/jspf/footer.jspf" %>