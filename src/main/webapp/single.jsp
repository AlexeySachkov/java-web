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
            <h2>Box details</h2>
            <c:choose>
                <c:when test="${not empty box}">
                    <form action="/single" method="POST" class="form form-horizontal">
                        <input type="hidden" name="id" value="<c:out value="${box.getId()}"></c:out>" />
                        <div class="form-group">
                            <label class="control-label col-sm-3">ID</label>
                            <div class="col-sm-9">
                                <p class="form-control-static"><c:out value="${box.getId()}"></c:out></p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="box-description" class="control-label col-sm-3">Description</label>
                            <div class="col-sm-9">
                                <textarea id="box-description" name="description" class="form-control"><c:out value="${box.getDescription()}"></c:out></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="box-width" class="control-label col-sm-3">Width</label>
                            <div class="col-sm-9">
                                <input type="number" min="1" id="box-width" name="width" value="<c:out value="${box.getWidth()}"></c:out>" class="form-control" required />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="box-height" class="control-label col-sm-3">Height</label>
                            <div class="col-sm-9">
                                <input type="number" min="1" id="box-height" name="height" value="<c:out value="${box.getHeight()}"></c:out>" class="form-control" required />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="box-depth" class="control-label col-sm-3">Depth</label>
                            <div class="col-sm-9">
                                <input type="number" min="1" id="box-depth" name="depth" value="<c:out value="${box.getDepth()}"></c:out>" class="form-control" required />
                            </div>
                        </div>
                        <hr />
                        <div class="form-group text-right">
                            <input type="submit" value="Save" class="btn btn-primary" />
                        </div>
                    </form>
                </c:when>
                <c:otherwise>
                    <p class="text-danger">Cannot find box with specified if!</p>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>