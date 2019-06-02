<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 01.06.2019
  Time: 18:40
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
<form action="carEdit" method="POST">
    <table>
        <tr>
            <td>Id pojazdu:</td>
            <td><input type="text" name="id" value="${car.id}" readonly="readonly"></td>
        </tr>
        <tr>
            <td>Id klienta:</td>
            <td><input type="text" name="customer_id" value="${car.customer_id}"></td>
        </tr>
        <tr>
            <td>Marka:</td>
            <td><input type="text" name="brand" value="${car.brand}"></td>
        </tr>
        <tr>
            <td>Model:</td>
            <td><input type="text" name="model" value="${car.model}"></td>
        </tr>
        <tr>
            <td>Rok produkcji:</td>
            <td><input type="text" name="prod_year" value="${car.prod_year}"></td>
        </tr>
        <tr>
            <td>Nr rejestracyjny:</td>
            <td><input type="text" name="reg_nr" value="${car.reg_nr}"></td>
        </tr>
        <tr>
            <td>Data przeglądu:</td>
            <td><input type="date" name="review_date" value="${car.review_date}"></td>
        </tr>
    </table>
    <br/>
    <input type="submit" value="Zapisz">&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="<c:url value="/cars"></c:url>">Pojazdy</a>
</form>
<%@include file="WEB-INF/footer.jsp"%>
</body>
</html>
