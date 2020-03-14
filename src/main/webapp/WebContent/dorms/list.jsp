<%--
  Created by IntelliJ IDEA.
  User: Raul
  Date: 29.10.2017
  Time: 13:30
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
    <style>
        .table-striped tbody tr:nth-of-type(2n+1) {
            background-color: rgba(255,0,0,.05);
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-4">
            <a href="?action=showForm">Add dorm</a>
        </div>
    </div>
    <table class="table table-striped">
        <tr>
            <th>#</th>
            <th>Name</th>
            <th>Room Size</th>
            <th>Type</th>
            <th># of rooms</th>
            <th colspan="2">Actions</th>
        </tr>
        <c:forEach items="${dormList}" var="dorm">
            <tr>
                <td><c:out value="${dorm.dormId}"/></td>
                <td><c:out value="${dorm.name}"/></td>
                <td><c:out value="${dorm.roomSize}"/></td>
                <td><c:out value="${dorm.dormType}"/></td>
                <td><c:out value="${dorm.numberOfRooms}"/></td>
                <td>
                    <a href='?action=delete&id=<c:out value="${dorm.dormId}"/>'
                       onclick="return confirm('Are you sure?')">Delete</a>
                </td>
                <td>
                    <a href='?action=showForm&id=<c:out value="${dorm.dormId}"/>'>Edit</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
</body>
</html>
