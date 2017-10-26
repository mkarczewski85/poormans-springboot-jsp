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
                    </c:otherwise>">
                </c:choose>
            </h1>
        <form:form method="post" action="/add" modelAttribute="task">
            <table>
                <tr>
                    <td><form:label path="name">Name</form:label></td>
                    <td><form:input path="name"/></td>
                </tr>

                <tr>
                    <td><form:label path="comment">Comment</form:label></td>
                    <td><form:input path="comment"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Save"></td>
                </tr>
            </table>
        </form:form>
        </div>
    </div>
</div>