<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 01.06.2019
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<%@include file="WEB-INF/header.jsp"%>
<h1>Pojazdy</h1>
<table>
    <thead>
    <td>Id pojazdu</td>
    <td>Id klienta</td>
    <td>Marka</td>
    <td>Model</td>
    <td>Rok produkcji</td>
    <td>Nr rejestracyjny</td>
    <td>Data przeglądu</td>
    <td>Edytuj</td>
    <td>Usuń</td>
    </thead>
    <c:forEach items="${cars}" var="car">
        <tr>
            <td>${car.id}</td>
            <td>${car.customer_id}</td>
            <td>${car.brand}</td>
            <td>${car.model}</td>
            <td>${car.prod_year}</td>
            <td>${car.reg_nr}</td>
            <td>${car.review_date}</td>
            <td><a href="<c:url value='/carEdit?id=${car.id}'></c:url>">...</a></td>
            <td><a href="<c:url value='/carDelete?id=${car.id}'></c:url>">...</a></td>
        </tr>
    </c:forEach>
</table><br/>
<a href="<c:url value="/carInsert"></c:url>">Nowy</a>
<%@include file="WEB-INF/footer.jsp"%>
</body>
</html>

