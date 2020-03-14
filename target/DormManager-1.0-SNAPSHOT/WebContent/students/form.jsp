<%--
  Created by IntelliJ IDEA.
  User: Raul
  Date: 06.11.2017
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <form method="post" action="/students">
        <input type="hidden" name="action" value='<c:out value="${action}"/>'>
        <input name="studentId" type="hidden" value='<c:out value="${studentId}"/>'>
        <div class="form-group">
            <input name="name" type="text" placeholder="Name" value='<c:out value="${name}"/>'>
        </div>
        <div class="form-group">
            <input name="admissionMean" type="number" step="0.01" placeholder="Admission mean" value='<c:out value="${admissionMean}"/>'>
        </div>
        <div class="form-group">
            <input name="civilStatus" type="text" placeholder="Civil status" value='<c:out value="${civilStatus}"/>'>
        </div>
        <div class="form-group">
            <input name="gender" type="text" placeholder="Gender" value='<c:out value="${gender}"/>'>
        </div>
        <div class="form-group">
            <input name="age" type="number" placeholder="Age" value='<c:out value="${age}"/>'>
        </div>
        <div class="form-group">
            <input name="currentYear" type="number" placeholder="Current year" value='<c:out value="${currentYear}"/>'>
        </div>
        <div class="form-group">
            <input name="cnp" type="text" placeholder="CNP" value='<c:out value="${cnp}"/>'>
        </div>
        <div class="form-group">
            <input name="email" type="text" placeholder="Email" value='<c:out value="${email}"/>'>
        </div>
        <div class="form-group">
            <input name="phoneNumber" type="text" placeholder="Phone #" value='<c:out value="${phoneNumber}"/>'>
        </div>
        <div class="form-group">
            <input name="faculty" type="text" placeholder="Faculty" value='<c:out value="${faculty}"/>'>
        </div>
        <div class="form-group">
            <input name="dormRef" type="number" placeholder="Dorm Ref" value='<c:out value="${dormRef}"/>'>
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
