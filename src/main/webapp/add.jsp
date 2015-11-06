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
            <form action="/add" method="POST" class="form form-horizontal">
                <div class="form-group">
                    <label for="box-description" class="control-label col-sm-3">Description</label>
                    <div class="col-sm-9">
                        <textarea id="box-description" name="description" class="form-control"></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label for="box-width" class="control-label col-sm-3">Width</label>
                    <div class="col-sm-9">
                        <input type="number" min="1" id="box-width" name="width" value="10" class="form-control" required />
                    </div>
                </div>
                <div class="form-group">
                    <label for="box-height" class="control-label col-sm-3">Height</label>
                    <div class="col-sm-9">
                        <input type="number" min="1" id="box-height" name="height" value="10" class="form-control" required />
                    </div>
                </div>
                <div class="form-group">
                    <label for="box-depth" class="control-label col-sm-3">Depth</label>
                    <div class="col-sm-9">
                        <input type="number" min="5" max="10" id="box-depth" name="depth" value="10" class="form-control" required />
                    </div>
                </div>
                <hr />
                <div class="form-group text-right">
                    <input type="submit" value="Add" class="btn btn-primary" />
                </div>
            </form>

        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>