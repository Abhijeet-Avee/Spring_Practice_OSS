<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add new employee</title>
<style>
	.error{
	color: #EF1313;
	font-style: italic;
	}
</style>
</head>
<body>

<form:form action="addupdateemp" method="post" modelAttribute="emp">
	<form:hidden path="id"/><br/>
	Enter employee name:<form:input path="name"/><form:errors path="name" class="error"/><br/>
	Enter employee salary:<form:input path="salary"/><form:errors path="salary" class="error"/><br/>
	<input type ="submit"/>
</form:form>
</body>
</html>