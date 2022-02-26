<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add new employee</title>
</head>
<body>

<form:form action="addupdateemp" method="post" modelAttribute="emp">
	<form:hidden path="id"/><br/>
	Enter emp name:<form:input path="name"/><br/>
	Enter emp salary:<form:input path="salary"/><br/>
	<input type ="submit"/>
</form:form>
</body>
</html>