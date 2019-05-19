<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${action} student</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700" rel="stylesheet">
<style>
	body {
		font-family: 'Open Sans', 'sans-serif';
		min-height:100vh;
	}

    legend {
        border-bottom: 1px #3e3e3e dotted;
    }

    .custom-form {
        box-shadow: 0 10px 40px -14px rgba(0,0,0,0.25);
    }
</style>
</head>
<body class="bg-light">
    <div class="container pt-4">
        <div class="row">
            <div class="col-md-8 offset-md-4 col-lg-6 offset-lg-3">
                <form:form action="${pageContext.request.contextPath}/saveStudent" class="bg-white p-4 custom-form"
                modelAttribute="student" method="POST" autocomplete="off">
                    <fieldset>
                        <legend class="mb-3">Student information</legend>
                        <form:input type="hidden" path="cStudent" />
                        <div class="form-group">
                            <label for="">First name:</label>
                            <form:input type="text" cssClass="form-control" path="sName" />
                        </div>
                        <div class="form-group">
                            <label for="">Last name:</label>
                            <form:input type="text" cssClass="form-control" path="lName" />
                        </div>
                        <div class="form-group">
                            <label for="">Age:</label>
                            <form:input type="number" cssClass="form-control" path="sAge" min="1" step="1" value="${(not empty student.sAge)? student.sAge : 18 }" />
                        </div>
                        <div class="form-group">
                            <div class="form-check">
                                <form:checkbox path="bActivo" id="checkActive" cssClass="form-check-input" />
                                <label for="checkActive">Is student active?</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-outline-primary">Save</button>
                            <a href="${pageContext.request.contextPath }" class="btn btn-outline-secondary">Discard changes</a>
                        </div>
                    </fieldset>
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>