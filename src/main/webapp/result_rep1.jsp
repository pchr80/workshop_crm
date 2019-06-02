<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 02.06.2019
  Time: 01:11
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
<h1>Raport 1</h1>
<table>
    <thead>
    <td>Imię i nazwisko</td>
    <td>Ilość roboczogodzin</td>
    </thead>
    <c:forEach items="${rep1List}" var="rep1">
        <tr>
            <td>${rep1.name}</td>
            <td>${rep1.work_hours}</td>
        </tr>
    </c:forEach>
</table><br/>
<!-- <a href="<c:url value="/carInsert"></c:url>">Nowy</a> -->
<%@include file="WEB-INF/footer.jsp"%>
</body>
</html>
