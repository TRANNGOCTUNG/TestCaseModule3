<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ngoct
  Date: 5/29/2023
  Time: 10:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>list</title>
</head>
<body>
<center>
    <h1><a href="/staff?action=create">Add new User</a> </h1>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>address</th>
            <th>phone_number</th>
            <th>salary</th>
            <th>department_name</th>
            <th>Action</th>
        </tr>
        <c:forEach var="staff" items="${staffList}">
            <tr>
                <td><c:out value="${staff.id}"></c:out></td>
                <td><c:out value="${staff.name}"></c:out></td>
                <td><c:out value="${staff.email}"></c:out></td>
                <td><c:out value="${staff.address}"></c:out></td>
                <td><c:out value="${staff.phone_number}"></c:out></td>
                <td><c:out value="${staff.salary}"></c:out></td>
                <td><c:out value="${staff.department_name}"></c:out></td>
                <td>
                    <a href="/staff?action=edit&id=${staff.id}">edit</a>
                    <a href="/staff?action=delete&id=${staff.id}">delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
