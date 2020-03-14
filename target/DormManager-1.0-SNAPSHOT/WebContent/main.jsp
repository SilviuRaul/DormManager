<%@ page import="java.util.Date" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%--
  Created by IntelliJ IDEA.
  User: Chris
  Date: 28.10.2017
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>
    You are the ${requestScope.get("data")} ADMIN!!!!
</h1>
<a href="/students">Students</a><br/>
<a href="/dorms">Dorms</a>
<ul>
   <c:forEach items="${girls}" var="girl">
        <li><c:out value="${girl}"/></li>
    </c:forEach>
    <c:forEach items="Ion, Pavel, George" var="hugh">
        <li><c:out value="${hugh}"/></li>
    </c:forEach>
</ul>
</body>
</html>
