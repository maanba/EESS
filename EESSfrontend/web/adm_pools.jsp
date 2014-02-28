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
    
    function getById(id){
        return document.getElementById(id);
    }
</script>

<div id="pools_container">
    <div style="float: left;">
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

    <div>
        <div>
            <select class="pools_list_ab" id="pools_list_a" multiple="true">
                <!--<option>A</option>-->
                <c:forEach var="subject" items="${subjects_a}">
                    <option>${subject}</option>
                </c:forEach>
            </select>
        </div>

        <div>
            <select class="pools_list_ab" id="pools_list_b" multiple="true">
                <!--<option>B</option>-->
                <c:forEach var="subject" items="${subjects_b}">
                    <option>${subject}</option>
                </c:forEach>
            </select>
        </div>
    </div>
</div>



<%@include file="WEB-INF/jspf/footer.jspf" %>