<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Application</title>

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
			<th>Id</th>
			<th>ISBN</th>
			<th>Title</th>
			<th>Author</th>
			<th>Price</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${books}" var="book">
			<tr>
				<td>${book.id}</td>
				<td>${book.isbn}</td>
				<td>${book.title}</td>
				<td>${book.author}</td>
				<td>${book.price}</td>
				<td><a href="delbook?id=<c:out value="${book.id}"/>">delete</a></td>
				<td><a href="updatebook?id=<c:out value="${book.id}"/>">update</a></td>
			</tr>
		</c:forEach>
		
	</tbody>
</table>
	<br>
	<a href="addbook">Add Book</a>
</body>
</html>