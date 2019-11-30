<%@ page import="pl.javagda28.CarServis.jsp.model.Car.Car" %>
<%@ page import="pl.javagda28.CarServis.jsp.model.ServiceRequest.ServiceRequest" %><%--
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
    <title>Service Request Form</title>
</head>
<body>
<jsp:include page="/JSP-Navigators/general-navigator.jsp"/>

<h1>SERVICE REQUEST FORM/h1>
<%
    ServiceRequest _serviceRequest = null;
    if (request.getAttribute("serviceRequestEditRequest") != null)
    {
        _serviceRequest = (ServiceRequest) request.getAttribute("serviceRequestEditRequest");
    }
%>

<form action="<%=_serviceRequest!=null ? "/SERVICE-REQUEST-EDIT-SERVLET": "/SERVICE-REQUEST-ADD-SERVLET" %>" method="post">

    <input type="hidden" name="serviceRequestIdNumber" value="${requestScope.serviceRequestEditRequest.getId()}">

    Content: <input type="text" name="serviceRequestParam_content" value="<%= _serviceRequest!=null ? _serviceRequest.getContent() : "" %>"/><br/>

    Urgent: <input type="checkbox" name="serviceRequestParam_urgent" <%= _serviceRequest != null && _serviceRequest.isUrgent() ? "checked" : ""%>/><br/><br/>

    <input type="submit"/>
</form>

</body>
</html>
