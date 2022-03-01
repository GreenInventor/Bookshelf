<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Bookshelves</title>
</head>
<body>
	<form method="post" action = "bookshelfnavigationservlet">
		<table>
			<c:forEach items = "${requestScope.allBookshelves }" var="currentBookshelf">
				<tr>
					<td><input type = "radio" name="id" value="${currentBookshelf.bookShelfId}"></td>
					<td><h2>${currentBookshelf.name}</h2></td>
				</tr>
				<c:forEach items = "${currentBookshelf.books}" var = "currentBook">
					<tr>
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
			</c:forEach>
		</table>
		<input type="submit" value = "delete" name="doThisToBookshelf">
		<input type="submit" value="edit" name="doThisToBookshelf">
		<input type="submit" value = "add" name="doThisToBookshelf">
	</form>
	<br><br>
	<a href="addbook.html">Insert a new Book</a>	
	<a href="index.html">Home</a>
</body>
</html>