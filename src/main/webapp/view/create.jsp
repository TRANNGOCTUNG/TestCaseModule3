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
    <title>Creat</title>
</head>
<body>
<center>
    <h2><a href="/staff?action=staff">List All User</a></h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New User</h2>
            </caption>
            <tr>
                <th>Name</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Email</th>
                <td>
                    <input type="text" name="email" id="email" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Address</th>
                <td>
                    <input type="text" name="address" id="address" size="45"/>
                </td>
            </tr>
            <tr>
                <th>phone_number</th>
                <td>
                    <input type="text" name="phone_number" id="phone_number" size="45"/>
                </td>
            </tr>
            <tr>
                <th>salary</th>
                <td>
                    <input type="text" name="salary" id="salary" size="45"/>
                </td>
            </tr>
            <tr>
                <th>department_name</th>
                <td>
                    <input type="text" name="department_name" id="department_name" size="45"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save">

                </td>
            </tr>
        </table>
    </form>

</div>
</body>
</html>
