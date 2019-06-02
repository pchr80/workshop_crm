<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 31.05.2019
  Time: 16:50
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
<h1>Klienci</h1>
<table>
    <thead>
    <td>Id klienta</td>
    <td>Imię</td>
    <td>Nazwisko</td>
    <td>Data urodzenia</td>
    <td>Edytuj</td>
    <td>Usuń</td>
    <td>Pojazdy klienta</td>
    </thead>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.name}</td>
            <td>${customer.surname}</td>
            <td>${customer.birth_date}</td>
            <td><a href="<c:url value='/customerEdit?id=${customer.id}'></c:url>">...</a></td>
            <td><a href="<c:url value='/customerDelete?id=${customer.id}'></c:url>">...</a></td>
            <td><a href="<c:url value='/cars?customer_id=${customer.id}'></c:url>">...</a></td>
        </tr>
    </c:forEach>
</table><br/>
<a href="<c:url value="/customerInsert"></c:url>">Nowy</a>
<%@include file="WEB-INF/footer.jsp"%>
</body>
</html>
