<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 03/07/2021
  Time: 10:51 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Creat</title>
</head>
<body>
<center>
    <h1>Customer List</h1>
    <h2>
        <a href="/customers?action=customers">List All Customer</a>
    </h2>
</center>
<div align="center">
<form method="post">
    <table border="1" cellpadding="5">
        <caption><h2>Add customer</h2></caption>
        <tr>
            <th>Name customer: </th>
            <td><input type="text" name="name" id="name"></td>
        </tr>
        <tr>
            <th>Age customer: </th>
            <td><input type="text" name="age" id="age"></td>
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
