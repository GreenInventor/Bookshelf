<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>All Bookshelves</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="style.css" rel="stylesheet">
	<!-- Tanner Patterson and Chris Pohlman -->
</head>
<body>
	<div id="container">
		<header id="top">
			<h1>All Bookshelves</h1>
		</header>
		<nav>
			<a href="index.html">Home</a>
			<a href="viewAllBooksServlet">View all Books</a>
			<a href="viewAllBookshelvesServlet">View all Bookshelves</a>
		</nav>
		<section>
			<form method="post" action = "bookshelfnavigationservlet">
			<table>
			<c:forEach items = "${requestScope.allBookshelves }" var="currentBookshelf">
				<tr>
					<td><input type = "radio" name="id" value="${currentBookshelf.bookShelfId}"></td>
					<td><h2>${currentBookshelf.name}</h2></td>
				</tr>
				<c:forEach items = "${requestScope.bookList}" var = "currentBook">
					<tr>
						<td><p>Title: ${currentBook.title}</p></td>
						<td><p>| Author: ${currentBook.author}</p></td>
						<td><p>| ISBN: ${currentBook.isbn}</p></td>
						<td><p>| Publisher: ${currentBook.publisher}</p></td>
						<td><p>| Pages: ${currentBook.numOfPages}</p></td>
						<td><p>| Chapters: ${currentBook.numOfChapters}</p></td>
						<td><p>| Is a Series: ${currentBook.isSeries}</p></td>
						<td><p>| Genre: ${currentBook.genre}</p></td>
					</tr>
				</c:forEach>
			</c:forEach>
			</table>
			<h3 id="bordertop">Please select an option:</h3>
			<br>
			<input type="submit" value="Add Bookshelf" name="doThisToBookshelf">
			<input type="submit" value="Edit Bookshelf" name="doThisToBookshelf">
			<input type="submit" value="Delete Bookshelf" name="doThisToBookshelf">
			</form>
		</section>
		<footer>
			<p>Java II Partner Project Week 6-7. Tanner Patterson and Chris Pohlman.</p>
		</footer>
	</div>
</body>
</html>