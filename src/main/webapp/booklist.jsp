<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Books</title>
</head>
<body>
	<h1>Book List:</h1>
	<form method="post" action="bookNavigationServlet">
	<table>
		<c:forEach items="${requestScope.allBooks}" var="currentBook">
		<tr>
			<td><input type="radio" name="id" value="${currentBook.id}"></td>
			<td>${currentBook.title}</td>
			<td>${currentBook.author}</td>
			<td>${currentBook.isbn}</td>
			<td>${currentBook.publisher}</td>
			<td>${currentBook.numOfPages}</td>
			<td>${currentBook.numOfChapters}</td>
			<td>${currentBook.isSeries}</td>
			<td>${currentBook.genre}</td>
		</tr>
		</c:forEach>
	</table>
	<h3>Please select an option:</h3>
	<br>
	<input type="submit" value="Add Book" name="doThisToBook">
	<input type="submit" value="Edit Book" name="doThisToBook">
	<input type="submit" value="Delete Book" name="doThisToBook">
	</form>
	<br><a href = "viewAllBookshelvesServlet">View All Bookshelves</a>
</body>
</html>

<!-- persistance exception, bookid not found in book -->
<!-- <td><input type="radio" name="id" value="${currentBook.bookid}"></td> -->

<!-- persistance exception, isSeries not found in book -->
<!-- <td>${currentBook.isSeries}</td> -->