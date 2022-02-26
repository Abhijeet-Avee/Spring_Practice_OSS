<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EmployeeApplication</title>

<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}
td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}
tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>
<table>
	<thead>
		<tr>
			<th>id</th>
			<th>name</th>
			<th>salary</th>
			<th>delete</th>
			<th>update</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${employees}" var="employee">
			<tr>
				<td>${employee.id}</td>
				<td>${employee.name}</td>
				<td>${employee.salary}</td>
				<td><a href="delemp?id=<c:out value="${employee.id}"/>">delete</a></td>
				<td><a href="updateemp?id=<c:out value="${employee.id}"/>">update</a></td>
			</tr>
		</c:forEach>
		
	</tbody>
</table>

<br>
<a href="addemp">add new employee</a>
</body>
</html>








