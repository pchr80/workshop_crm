<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 31.05.2019
  Time: 02:04
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
<h1>Zlecenia</h1>
<table>
    <thead>
    <td>Id zlecenia</td>
    <td>Id pojazdu</td>
    <td>Id pracownika</td>
    <td>Data rozpoczęcia naprawy</td>
    <td>Opis naprawy</td>
    <td>Szczegóły</td>
    </thead>
    <c:forEach items="${actOrders}" var="actOrder">
        <tr>
            <td>${actOrder.id}</td>
            <td>${actOrder.car_id}</td>
            <td>${actOrder.employee_id}</td>
            <td>${actOrder.start_date}</td>
            <td>${actOrder.repair_desc}</td>
            <td><a href="<c:url value='orderDetails?id=${actOrder.id}'></c:url>"> ... </a></td>
        </tr>
    </c:forEach>
</table><br/>
<a href="<c:url value="/orderInsert"></c:url>">Nowe</a>
<%@include file="WEB-INF/footer.jsp"%>
</body>
</html>
