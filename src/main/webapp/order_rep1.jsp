<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 02.06.2019
  Time: 00:01
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="WEB-INF/header.jsp"%>
<br/>
<form action="report_1" method="POST">
    <table>
        <tr>
            <td>Data od:</td>
            <td><input type="date" name="date_from"></td>
        </tr>
        <tr>
            <td>Data do:</td>
            <td><input type="date" name="date_to"></td>
        </tr>
    </table>
    <br/>
    <input type="submit" value="Generuj raport">
</form>
<%@include file="WEB-INF/footer.jsp"%>
</body>
</html>
