<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 30.05.2019
  Time: 14:52
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
<h1></h1>
<p>Id zlecenia: ${order.id} </p>
<p>Id pojazdu: ${order.car_id} </p>
<p>Id pracownika: ${order.employee_id} </p>
<p>Data przyjęcia: ${order.receive_date} </p>
<p>Planowana data rozpoczęcia: ${order.planned_start_date} </p>
<p>Data rozpoczęcia: ${order.start_date} </p>
<p>Data zakończenia: ${order.end_date} </p>
<p>Opis problemu: ${order.problem_desc} </p>
<p>Opis naprawy: ${order.repair_desc} </p>
<p>Status: ${order.status_desc} </p>
<p>Cena naprawy: ${order.repair_price} </p>
<p>Cena części: ${order.parts_price} </p>
<p>Koszt roboczogodziny: ${order.man_hour} </p>
<p>Ilość roboczogodzin: ${order.work_hours} </p>
<br/>
<a href="<c:url value="/orderEdit?id=${order.id}"></c:url>">Edytuj</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="<c:url value="/orderDelete?id=${order.id}"></c:url>">Usuń</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="<c:url value="/orders"></c:url>">Zlecenia</a>
<%@include file="WEB-INF/footer.jsp"%>
</body>
</html>
