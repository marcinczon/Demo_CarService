<%--
  Created by IntelliJ IDEA.
  User: Marcin
  Date: 28.11.2019
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Car List</title>

    <style>
        td {
            border: 1px solid #000;
        }
    </style>

</head>
<body>
<jsp:include page="/JSP-Navigators/general-navigator.jsp"/>

<h1>CAR LIST</h1>

<table style="border: 1px solid #000; width: 100%;">

    <tr>
        <th>Id</th>
        <th>Brand</th>
        <th>Registraction number</th>
        <th>Owner</th>
        <th>Production date</th>
        <th>Millage</th>
    </tr>

    <c:forEach var="car" items="${requestScope.carList}" varStatus="loop">
        <tr>
            <td>${car.getId()}</td>
            <td>${car.getBrand()}</td>
            <td>${car.getRegistrationNumber()}</td>
            <td>${car.getOwnerSecondName()}</td>
            <td>${car.getProductionDate()}</td>
            <td>${car.getCarMillage()}</td>



            <td><a href="/CAR-EDIT-SERVLET?carIdNumber=${car.getId()}">Edit</a></td>
            <td><a href="/CAR-REMOVE-SERVLET?carIdNumber=${car.getId()}">Delete</a></td>
        </tr>
    </c:forEach>


</table>


</body>
</html>
