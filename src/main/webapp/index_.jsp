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
                <h2>Welcome to boxes catalogue</h2>
                <p>
                    Here you can find box or create your own!
                </p>
                <c:choose>
                    <c:when test="${not empty boxCount}">
                        <p class="text-info">Boxes in catalogue: <c:out value="${boxCount}"></c:out> </p>
                        <hr />
                        <c:choose>
                            <c:when test="${boxesNum < 0}">
                                <p>Last <c:out value="${boxesNum}"></c:out> boxes: </p>
                            </c:when>
                            <c:otherwise>
                                <p>All boxes: </p>
                            </c:otherwise>
                        </c:choose>
                        <table class="table table-hover table-border">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Width</th>
                                    <th>Depth</th>
                                    <th>Height</th>
                                    <th>Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${boxes}" var="box">
                                    <tr>
                                        <td><c:out value="${box.getId()}"></c:out></td>
                                        <td><c:out value="${box.getWidth()}"></c:out></td>
                                        <td><c:out value="${box.getDepth()}"></c:out></td>
                                        <td><c:out value="${box.getHeight()}"></c:out></td>
                                        <td>
                                            <a href="/single?id=<c:out value="${box.getId()}"></c:out>" class="text-info">
                                                <i class="fa fa-fw fa-pencil"></i> Details and edit
                                            </a><br />
                                            <a href="/delete?id=<c:out value="${box.getId()}"></c:out>" class="text-danger">
                                                <i class="fa fa-fw fa-times"></i> Delete
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:when>
                    <c:otherwise>
                        <p class="text-danger">Error: can't get boxCount!</p>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
<%@ include file="footer.jsp" %>