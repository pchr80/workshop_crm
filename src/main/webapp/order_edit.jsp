<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 30.05.2019
  Time: 17:57
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
<form action="orderEdit" method="POST">
    <table>
            <tr>
                <td>Id zlecenia:</td>
                <td><input type="text" name="id" value="${order.id}" readonly="readonly"></td>
            </tr>
            <tr>
                <td>Id pojazdu:</td>
                <td><input type="text" name="car_id" value="${order.car_id}"></td>
            </tr>
        <tr>
            <td>Id pracownika:</td>
            <td><input type="text" name="employee_id" value="${order.employee_id}"></td>
        </tr>
        <tr>
            <td>Data przyjęcia:</td>
            <td><input type="date" name="receive_date" value="${order.receive_date}"></td>
        </tr>
        <tr>
            <td>Planowana data rozpoczęcia:</td>
            <td><input type="date" name="planned_start_date" value="${order.planned_start_date}"></td>
        </tr>
        <tr>
            <td>Data rozpoczęcia:</td>
            <td><input type="date" name="start_date" value="${order.start_date}"></td>
        </tr>
        <tr>
            <td>Data zakończenia:</td>
            <td><input type="date" name="end_date" value="${order.end_date}"></td>
        </tr>
        <tr>
            <td>Opis problemu:</td>
            <td><input type="text" name="problem_desc" value="${order.problem_desc}"></td>
        </tr>
        <tr>
            <td>Opis naprawy:</td>
            <td><input type="text" name="repair_desc" value="${order.repair_desc}"></td>
        </tr>
        <tr>
            <td>Status</td>
            <td>
                <!-- <input type="text" name="status_desc" value="${order.status_desc}"> -->
                <select name="status_code">
                    <option value="CANC" <c:if test="${order.status_code == 'CANC'}">selected</c:if>>Rezygnacja</option>
                    <option value="DONE" <c:if test="${order.status_code == 'DONE'}">selected</c:if>>Gotowy do odbioru</option>
                    <option value="PRAC" <c:if test="${order.status_code == 'PRAC'}">selected</c:if>>Zatwierdzone koszty naprawy</option>
                    <option value="RECE" <c:if test="${order.status_code == 'RECE'}">selected</c:if>>Przyjęty</option>
                    <option value="REPR" <c:if test="${order.status_code == 'REPR'}">selected</c:if>>W naprawie</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Cena naprawy:</td>
            <td><input type="number" name="repair_price" min="0.00" step="0.01" value="${order.repair_price}"></td>
        </tr>
        <tr>
            <td>Cena części:</td>
            <td><input type="number" name="parts_price" min="0.00" step="0.01" value="${order.parts_price}"></td>
        </tr>
        <tr>
            <td>Koszt roboczogodziny:</td>
            <td><input type="number" name="man_hour" min="0.00" step="0.01" value="${order.man_hour}"></td>
        </tr>
        <tr>
            <td>Ilość roboczogodzin:</td>
            <td><input type="number" name="work_hours" min="0.00" step="0.01" value="${order.work_hours}"></td>
        </tr>
    </table>
    <br/>
    <input type="submit" value="Zapisz">&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="<c:url value="/orders"></c:url>">Zlecenia</a>
</form>
<%@include file="WEB-INF/footer.jsp"%>
</body>
</html>
