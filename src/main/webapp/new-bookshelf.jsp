<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add new Bookshelf</title>
</head>
<body>
	<form action="createNewBookshelfServlet" method="post">
		Bookshelf Name: <input type="text" name="name">
		Available Books: <select name="allBooksToAdd" multiple size="5">
			<c:forEach items="${requestScope.allBooks}" var = "currentBook">
				<option value="${currentBook.id}">${currentBook.title} by ${currentBook.author}</option>
			</c:forEach>
		</select>
		<input type="submit" value="Create Bookshelf">
	</form>
	<a href = "index.html">Home</a>
	<a href="addbook.html">Add new Books</a>
</body>
</html>