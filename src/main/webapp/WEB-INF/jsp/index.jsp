<%-- 
    Document   : index
    Created on : Dec 31, 2015, 5:12:46 PM
    Author     : Teimourikia
--%>
<%-- 
    Note that the JSTL library is included in the POM. This is for jsp rendering. 
    The “taglib” is included to allow the context path to be popped into the request 
    (HttpServletRequest) when the page renders.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RAMIRES</title>
        <link rel="stylesheet" type="text/css" href="/WEB-INF/resources/css.site.css"/>
        <script src="/WEB-INF/resources/js/js.js"></script>
    </head>
    <body>
        <h1>Hello World!</h1>
        Test Says: <span class="blue">${msg}</span>
    </body>
</html>
