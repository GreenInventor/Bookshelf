<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>View All Books</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="style.css" rel="stylesheet">
	<!-- Tanner Patterson and Chris Pohlman -->
</head>
<body>
	<div id="container">
		<header id="top">
			<h1>Book List</h1>
		</header>
		<nav>
			<a href="index.html">Home</a>
			<a href="viewAllBooksServlet">View all Books</a>
			<a href="viewAllBookshelvesServlet">View all Bookshelves</a>
		</nav>
		<section>
			<form method="post" action="bookNavigationServlet">
			<table>
			<c:forEach items="${requestScope.allBooks}" var="currentBook">
			<tr>
				<td><input type="radio" name="id" value="${currentBook.id}"></td>
				<td><p>Title: ${currentBook.title}  |</p></td>
				<td><p>Author: ${currentBook.author}  |</p></td>
				<td><p>ISBN: ${currentBook.isbn}  |</p></td>
				<td><p>Publisher: ${currentBook.publisher}  |</p></td>
				<td><p>Pages: ${currentBook.numOfPages}  |</p></td>
				<td><p>Chapters: ${currentBook.numOfChapters}  |</p></td>
				<td><p>Is a Series: ${currentBook.isSeries}  |</p></td>
				<td><p>Genre: ${currentBook.genre}</p></td>
			</tr>
			</c:forEach>
			</table>
			<h3 id="bordertop">Please select an option:</h3>
			<br>
			<input type="submit" value="Add Book" name="doThisToBook">
			<input type="submit" value="Edit Book" name="doThisToBook">
			<input type="submit" value="Delete Book" name="doThisToBook">
			</form>
		</section>
		<footer>
			<p>Java II Partner Project Week 6-7. Tanner Patterson and Chris Pohlman.</p>
		</footer>
	</div>
</body>
</html>