<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="common/header.jsp"/>
<jsp:include page="common/nav.jsp"/>


<div class="container">
    <div class="row" style="padding-top: 100px">
        <div class="col-md-12">
            <h1>
                <c:choose>
                    <c:when test="${empty task.id}">
                        Add new task
                    </c:when>
                    <c:otherwise>
                        Edit task
                    </c:otherwise>
                </c:choose>
            </h1>

            <form:form method="post" action="/add" modelAttribute="task" class="form-group row">

                <form:hidden path="id"/>
                <form:label path="name" class="col-sm-2 col-form-label">Name</form:label>
                <div class="col-sm-10">
                    <form:input path="name" class="form-control"/>
                </div>

                <form:label path="comment" class="col-sm-2 col-form-label">Comment</form:label>
                <div class="col-sm-10">
                    <form:input path="comment" class="form-control"/>
                </div>

                <form:label path="priority" class="col-sm-2 col-form-label">Priority</form:label>
                <div class="col-sm-10">
                    <form:input path="priority" class="form-control"/>
                </div>

                <form:label path="deadline" class="col-sm-2 col-form-label">Deadline</form:label>
                <div class="col-sm-10">
                    <form:input path="deadline" class="form-control" type="datetime-local"/>
                </div>

                <div class="form-group row">
                    <div class="col-sm-10">
                        <input type="submit" value="Save" class="btn btn-primary">
                    </div>
                </div>
            </form:form>

        </div>
    </div>
</div>