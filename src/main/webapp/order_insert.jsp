<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 31.05.2019
  Time: 12:35
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
<form action="orderInsert" method="POST">
    <table>
        <tr>
            <td>Id pojazdu:</td>
            <td><input type="text" name="car_id"></td>
        </tr>
        <tr>
            <td>Id pracownika:</td>
            <td><input type="text" name="employee_id"></td>
        </tr>
        <tr>
            <td>Data przyjęcia:</td>
            <td><input type="date" name="receive_date"></td>
        </tr>
        <tr>
            <td>Planowana data rozpoczęcia:</td>
            <td><input type="date" name="planned_start_date"></td>
        </tr>
        <tr>
            <td>Data rozpoczęcia:</td>
            <td><input type="date" name="start_date"></td>
        </tr>
        <tr>
            <td>Data zakończenia:</td>
            <td><input type="date" name="end_date"></td>
        </tr>
        <tr>
            <td>Opis problemu:</td>
            <td><input type="text" name="problem_desc"></td>
        </tr>
        <tr>
            <td>Opis naprawy:</td>
            <td><input type="text" name="repair_desc"></td>
        </tr>
        <tr>
            <td>Status</td>
            <td>
                <!-- <input type="text" name="status_desc" value="${order.status_desc}"> -->
                <select name="status_code">
                    <option value="CANC">Rezygnacja</option>
                    <option value="DONE">Gotowy do odbioru</option>
                    <option value="PRAC">Zatwierdzone koszty naprawy</option>
                    <option value="RECE">Przyjęty</option>
                    <option value="REPR">W naprawie</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Cena naprawy:</td>
            <td><input type="number" name="repair_price" min="0.00" step="0.01"></td>
        </tr>
        <tr>
            <td>Cena części:</td>
            <td><input type="number" name="parts_price" min="0.00" step="0.01"></td>
        </tr>
        <tr>
            <td>Koszt roboczogodziny:</td>
            <td><input type="number" name="man_hour" min="0.00" step="0.01"></td>
        </tr>
        <tr>
            <td>Ilość roboczogodzin:</td>
            <td><input type="number" name="work_hours" min="0.00" step="0.01"></td>
        </tr>
    </table>
    <br/>
    <input type="submit" value="Zapisz">
</form>
<%@include file="WEB-INF/footer.jsp"%>
</body>
</html>
