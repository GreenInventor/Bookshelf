<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Bookshelf</title>
</head>
<body>
	<form action="editBookshelfServlet" method="post">
		<input type="hidden" name="id" value="${bookshelfToEdit.bookShelfId}">
		Bookshelf Name: <input type="text" name="bookshelfName" value="${bookshelfToEdit.name}"><br>
		Available Books:<br>
		<select name="booksToAdd" multiple size="5">
		<c:forEach items="${requestScope.allBooks}" var = "currentBook">
			<option value="${currentBook.id}">${currentBook.title} by ${currentBook.author}</option>
		</c:forEach>
		</select>
		<br>
		<input type="reset" value="Reset">
		<input type="submit" value="Edit Bookshelf and Add Books">
	</form>
	<br>
	<a href = "index.html">Home</a>
	<a href="addbook.html">Add new Books</a>
</body>
</html>