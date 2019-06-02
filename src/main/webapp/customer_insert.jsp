<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 31.05.2019
  Time: 21:48
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
<form action="customerInsert" method="POST">
    <table>
        <tr>
            <td>Id klienta:</td>
            <td><input type="text" name="id" readonly="readonly"></td>
        </tr>
        <tr>
            <td>Imię:</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>Nazwisko:</td>
            <td><input type="text" name="surname"</td>
        </tr>
        <tr>
            <td>Data urodzenia:</td>
            <td><input type="date" name="birth_date"></td>
        </tr>
    </table>
    <br/>
    <input type="submit" value="Zapisz">&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="<c:url value="/customers"></c:url>">Klienci</a>
</form>
<%@include file="WEB-INF/footer.jsp"%>
</body>
</html>
