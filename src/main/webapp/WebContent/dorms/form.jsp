<%--
  Created by IntelliJ IDEA.
  User: Raul
  Date: 06.11.2017
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dorms</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <form method="post" action="/dorms">
        <input type="hidden" name="action" value='<c:out value="${action}"/>'>
        <input name="dormId" type="hidden" value='<c:out value="${dormId}"/>'>
        <div class="form-group">
            <input name="name" type="text" placeholder="Name" value='<c:out value="${name}"/>'>
        </div>
        <div class="form-group">
            <input name="roomSize" type="number" placeholder="Room size" value='<c:out value="${roomSize}"/>'>
        </div>
        <div class="form-group">
            <input name="dormType" type="text" placeholder="Dorm type" value='<c:out value="${dormType}"/>'>
        </div>
        <div class="form-group">
            <input name="numberOfRooms" type="number" placeholder="Number of rooms" value='<c:out value="${numberOfRooms}"/>'>
        </div>
        <div class="form-group">
            <input type="submit" value='<c:out value="${buttonLabel}"/>'>
        </div>

    </form>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
</body>
</html>
