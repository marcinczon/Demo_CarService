<%@ page import="pl.javagda28.CarServis.jsp.model.Car.Car" %><%--
  Created by IntelliJ IDEA.
  User: Marcin
  Date: 28.11.2019
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Car Form</title>
</head>
<body>
<jsp:include page="/JSP-Navigators/general-navigator.jsp"/>

<h1>Car Form</h1>
<%
    Car _car = null;
    if (request.getAttribute("carEditRequest") != null)
    {
        _car = (Car) request.getAttribute("carEditRequest");
    }
%>

<form action="<%=_car!=null ? "/CAR-EDIT-SERVLET": "/CAR-ADD-SERVLET" %>" method="post">

    <input type="hidden" name="carIdNumber" value="${requestScope.carEditRequest.getId()}">

    Brands: <select name="carParam_brand">
        <c:forEach var="brand" items="${requestScope.brandList}">
            <option value="${brand}" ${brand == requestScope.carEditRequest.getBrand() ? "selected" : ""}>
                    ${brand}
            </option>
        </c:forEach>
    </select> <br/>

    Registration Number: <input type="text" name="carParam_registrationNumber" value="<%= _car!=null ? _car.getRegistrationNumber() : "" %>"/><br/>

    Owner Second Name: <input type="text" name="carParam_ownerSecondName" value="<%= _car!=null ? _car.getOwnerSecondName() : "" %>"/><br/>

    Production Date: <input type="number" name="carParam_productionDate" step="1" min="1990" max="2019" value="<%= _car!=null ?  _car.getProductionDate() : "1990" %>"/><br/>

    Car Millage: <input type="number" name="carParam_carMillage" min="0" value="<%= _car!=null ? _car.getCarMillage() : "0" %>"/><br/>

    <input type="submit"/>
</form>

</body>
</html>
