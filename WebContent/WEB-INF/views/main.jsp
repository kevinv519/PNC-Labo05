<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of students</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700" rel="stylesheet">
<style>
	body {
		font-family: 'Open Sans', 'sans-serif';
		min-height: 100vh;
	}
</style>
</head>
<body class="bg-light">
	<div class="container bg-white p-5">
		<c:if test="${ !empty success }">
			<div class="alert alert-${success? "success" : "warning"}">
				${message}
			</div>
		</c:if>
		
		<form action="${pageContext.request.contextPath}/search" class="form-inline mb-2" method="get">
			<label for="">Student ID:</label>
			<input type="number" name="studentId" min="1" step="1" class="form-control ml-3">
			<button type="submit" class="btn btn-light ml-3">Search ...</button>
		</form>
		
		<a href="${pageContext.request.contextPath}/add-student" class="btn btn-outline-primary">Add new student</a>
		
		<br><br>
		<table class="table table-striped table-bordered">
			<tr class="bg-success text-white">
				<th>Name</th>
				<th>Last Name</th>
				<th class="text-center">Age</th>
				<th>Status</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${students}" var="student">
				<tr>
					<td class="align-middle">${student.sName}</td>
					<td class="align-middle">${student.lName}</td>
					<td class="align-middle text-center">${student.sAge}</td>
					<td class="align-middle">${student.activoDelegate}</td>
					<td class="align-middle">
						<a href="${pageContext.request.contextPath}/edit-student/${student.cStudent}" class="btn btn-info">Edit</a>
						<a href="${pageContext.request.contextPath}/delete-student/${student.cStudent}" class="btn btn-danger">Delete</a>
					</td>
				</tr>	
			</c:forEach>
		</table>
	</div>

</body>
</html>