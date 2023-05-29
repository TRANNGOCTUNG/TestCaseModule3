<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ngoct
  Date: 5/29/2023
  Time: 10:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/staff?action=staff">List all customer</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Edit user</h2>
            </caption>
            int id,String name, String email, String address, String phone_number, double salary,String department_name
            <c:if test="${newStaff != null}">
                <input type="hidden" name="id" value="${newStaff.id}"/>
            </c:if>
            <tr>
                <th>Staff Name</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${newStaff.name}'/>"/>
                </td>
            </tr>
            <tr>
                <th>Email</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${newStaff.email}'/>"/>
                </td>
            </tr>
            <tr>
                <th>Address</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${newStaff.address}'/>"/>
                </td>
            </tr>
            <tr>
                <th>Phone Number</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${newStaff.phone_number}'/>"/>
                </td>
            </tr>
            <tr>
                <th>Salary</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${newStaff.salary}'/>"/>
                </td>
            </tr>
            <tr>
                <th>department_name</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${newStaff.department_name}'/>"/>
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
