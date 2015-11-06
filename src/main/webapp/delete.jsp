<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="header.jsp" %>
<div class="container">
    <div class="jumbotron">
        <h1 class="page-title">Boxes catalogue</h1>
    </div>
    <div class="row">
        <div class="col-md-12">
            <h1 class="page-header">${title}. ${subtitle}</h1>
        </div>
        <div class="col-md-3">
            <%@ include file="sidebar.jsp" %>
        </div>
        <div class="col-md-9">
            <h2>Input box details</h2>
            <form action="/delete" method="POST" class="form form-horizontal">
                <input type="hidden" name="id" value="<c:out value="${box.getId()}"></c:out>" />
                <p>Are you sure to delete this box?</p>
                <p>Description: <c:out value="${box.getDescription()}"></c:out></p>
                <p>Width: <c:out value="${box.getWidth()}"></c:out></p>
                <p>Height: <c:out value="${box.getHeight()}"></c:out></p>
                <p>Depth: <c:out value="${box.getDepth()}"></c:out></p>
                <hr />
                <div class="form-group text-right">
                    <a href="/" class="btn btn-secondary">Abort</a>
                    <input type="submit" value="Delete" class="btn btn-primary" />
                </div>
            </form>

        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>