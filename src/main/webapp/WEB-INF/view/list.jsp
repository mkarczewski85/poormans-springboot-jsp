<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%--@elvariable id="task" type="com.sda.spring.model.Task"--%>

<jsp:include page="common/header.jsp"/>
<jsp:include page="common/nav.jsp"/>

<div class="container">

    <div class="row" style="padding-top: 100px">

        <div class="col-md-12">
            <h1>Tasks list</h1>
            <table class="table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Task name</th>
                    <th>Comment</th>
                    <th>Priority</th>
                    <th>Date created</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <c:forEach items="${tasks}" var="task" varStatus="iter">
                    <tag:taskRow task="${task}" id="${iter.index+1}"/>
                </c:forEach>
                </tbody>
            </table>

        </div>
        <div class="col-md-12">
            <a href="/new">
                <button type="button" class="btn btn-success">Add new</button>
            </a>
        </div>
        <hr>
    </div>

</div>
<jsp:include page="common/footer.jsp"/>










