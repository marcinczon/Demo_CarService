<%@ page import="pl.javagda28.CarServis.jsp.model.ServiceRequest.ServiceRequest" %>
<%@ page import="java.net.ContentHandler" %><%--
  Created by IntelliJ IDEA.
  User: Marcin
  Date: 28.11.2019
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>SERVICE REQUEST LIST</title>

    <style>
        td {
            border: 1px solid #000;
        }
    </style>

</head>
<body>
<jsp:include page="/JSP-Navigators/general-navigator.jsp"/>

<h1>SERVICE REQUEST LIST</h1>

<table style="border: 1px solid #000; width: 100%;">

    <tr>
        <th>Id</th>
        <th>Created</th>
        <th>Realized</th>
        <th>Content</th>
        <th>Urgent</th>
    </tr>

    <c:forEach var="serviceRequest" items="${requestScope.serviceRequestList}" varStatus="loop">

        <tr>
            <td>${serviceRequest.getId()}</td>
            <td>${serviceRequest.getCreateDate()}</td>
            <td>${serviceRequest.getDoneDate()}</td>
            <td>${serviceRequest.getContent()}</td>
            <td>${serviceRequest.isUrgent()}</td>

            <td><a href="/SERVICE-REQUEST-EDIT-SERVLET?serviceRequestIdNumber=${serviceRequest.getId()}">Edit</a></td>
            <td><a href="/SERVICE-REQUEST-REMOVE-SERVLET?serviceRequestIdNumber=${serviceRequest.getId()}">Delete</a>

                <c:if test="${serviceRequest.getDoneDate()==null}">
                      <td><a href="/SERVICE-REQUEST-DONE-SERVLET?serviceRequestIdNumber=${serviceRequest.getId()}">Done</a>
                </c:if>
            </td>
        </tr>
    </c:forEach>


</table>


</body>
</html>
