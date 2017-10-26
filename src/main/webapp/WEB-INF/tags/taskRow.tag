<%@ tag language="java" pageEncoding="utf-8" %>

<%@ attribute name="task" type="com.sda.spring.model.Task" required="true" %>
<%@ attribute name="id" type="java.lang.Integer" required="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<tr>
    <th scope="row">${id}</th>
    <td>${task.name}</td>
    <td>${task.comment}</td>
    <td>${task.priority}</td>
    <td><fmt:formatDate value="${task.dateCreated}" pattern="d.mm.yyyy"></td>
    <td>
        <a href="details?id=${task.id}">
            <button type="button" class="btn btn-default">Details</button>
        </a>

        <a href="edit?id=${task.id}">
            <button type="button" class="btn btn-info">Edit</button>
        </a>

        <a href="delete?id=${task.id}">
            <button type="button" class="btn btn-danger">Delete</button>
        </a>

    </td>
</tr>