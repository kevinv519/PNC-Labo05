<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search student</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700" rel="stylesheet">
<style>
	body {
		font-family: 'Open Sans', 'sans-serif';
	}
</style>
</head>
<body class="bg-light">
	<div class="container bg-white p-4">
		<c:if test="${!(empty student)}">
			<span style="font-size:1.5em;"><strong>Student ID:</strong> ${student.cStudent }</span><br>
			<span style="font-size:1.5em;"><strong>First name:</strong> ${student.sName }</span><br>
			<span style="font-size:1.5em;"><strong>Last name:</strong> ${student.lName }</span><br>
			<span style="font-size:1.5em;"><strong>Age:</strong> ${student.sAge }</span><br>
			<span style="font-size:1.5em;"><strong>Status:</strong> ${student.activoDelegate }</span>
		</c:if>
		
		<c:if test="${not empty noResult }">
			<h4 class="alert alert-warning">${noResult }</h4>
		</c:if>
		<br>
		<br>
		<a href="${pageContext.request.contextPath}/" class="btn btn-outline-primary">Go back</a>
	</div>
</body>
</html>