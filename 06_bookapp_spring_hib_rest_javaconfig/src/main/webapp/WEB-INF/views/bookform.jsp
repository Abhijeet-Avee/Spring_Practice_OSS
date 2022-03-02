<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add new employee</title>
<style>
	.error{
	color: #EF1313;
	font-style: italic;
	}
</style>
</head>
<body>

<form:form action="addupdatebook" method="post" modelAttribute="bookForm">
	<form:hidden path="id"/><br/>
	<p>ENTER BOOK DETAILS</p>
	<br/><br/>
	ISBN :		<form:input path="isbn"/><form:errors path="isbn" class="error"/><br/><br/>
	Title :		<form:input path="title"/><form:errors path="title" class="error"/><br/><br/>
	Author :	<form:input path="author"/><form:errors path="author" class="error"/><br/><br/>
	Price :		<form:input path="price"/><form:errors path="price" class="error"/><br/><br/>
	<input type ="submit"/>
</form:form>

</body>
</html>