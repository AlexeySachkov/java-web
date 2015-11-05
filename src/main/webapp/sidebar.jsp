<ul class="list-group">
    <li class="list-group-item"><a href="/"><i class="fa fa-fw fa-home"></i> Main page</a></li>
    <li class="list-group-item"><a href="/add"><i class="fa fa-fw fa-plus"></i> Add Box</a></li>
    <c:if test="${page == 'single'}">
        <li class="list-group-item"></li>
        <li class="list-group-item"><a href="/delete&id=${box.id}>"><i class="fa fa-fw fa-times"></i> Delete Box</a></li>
    </c:if>
</ul>