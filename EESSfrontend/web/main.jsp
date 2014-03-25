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
    
    function statusCheck() {
        var status = '${status}';
        var div = document.getElementById("statusDiv");
        if (status.length == 0) {
            div.style.display = 'none';
        }
    }
    
    addLoadEvent(statusCheck); 
</script>

<div id="statusDiv">
    ${status}
</div>

Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi ac ornare ligula, sed feugiat mi. Nam in lorem tempor nibh tempor lobortis ac a urna. Integer blandit risus orci, vitae lobortis neque suscipit et. Curabitur sed aliquet neque. Aenean blandit nunc sit amet dignissim hendrerit. Proin commodo nisl ac nunc posuere, eu rhoncus libero mattis. Sed turpis risus, elementum pellentesque quam et, bibendum tempus felis. In ac magna ac est congue posuere sed et neque. Aliquam eu dui ac orci rhoncus lobortis eget a quam. Suspendisse malesuada rhoncus felis, ut euismod mauris tristique ac. Donec euismod varius semper. Etiam volutpat ut turpis quis commodo. Vivamus posuere turpis eget porta convallis. Nulla rutrum lacus sit amet fringilla mollis.

<ul>
<li>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</li>
<li>Morbi porta nibh quis urna mattis ornare.</li>
<li>Vestibulum vitae justo imperdiet, condimentum turpis eget, faucibus tortor.</li>
</ul>

<%@include file="WEB-INF/jspf/footer.jspf" %>