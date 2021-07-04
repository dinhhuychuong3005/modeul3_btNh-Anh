<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 04/07/2021
  Time: 3:29 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>Edit Customer</h1>
    <h2>
        <a href="customers?/action=customers">List all customer</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <c:if test="${customer != null}">
                <input type="hidden" name="id" value="${customer.id}"/>
            </c:if>
            <tr>
                <th>Customer Name:</th>
                <td>
                    <input type="text" name="name" value="${customer.name}"/>
                </td>
            </tr>
            <tr>
                <th>Customer age:</th>
                <td>
                    <input type="text" name="age" value="${customer.age}"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
