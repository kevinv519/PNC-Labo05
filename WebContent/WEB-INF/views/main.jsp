<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search student</title>
<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700" rel="stylesheet">
<style>
	body {
		font-family: 'Open Sans', 'sans-serif';
		margin: 1.5em;
	}
</style>
</head>
<body>
	<form action="${pageContext.request.contextPath}/" method="post">
		Student ID: <input type="number" name="studentId" min="1" step="1" style="margin-left: 1em;">
		<button type="submit" style="margin-left: 1em;">Search ...</button>
	</form>
	
	<c:if test="${!(empty student)}">
		<br><br>
		<span style="font-size:1.5em;"><strong>Student ID:</strong> ${student.cStudent }</span><br>
		<span style="font-size:1.5em;"><strong>First name:</strong> ${student.sName }</span><br>
		<span style="font-size:1.5em;"><strong>Last name:</strong> ${student.lName }</span><br>
		<span style="font-size:1.5em;"><strong>Age:</strong> ${student.sAge }</span>
	</c:if>
	<h4>${noResult }</h4>
</body>
</html>