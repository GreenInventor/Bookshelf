<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>Edit Book</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="style.css" rel="stylesheet">
	<!-- Tanner Patterson and Chris Pohlman -->
</head>
<body>
	<div id="container">
		<header id="top">
			<h1>Edit Book</h1>
		</header>
		<nav>
			<a href="index.html">Home</a>
			<a href="viewAllBooksServlet">View all Books</a>
			<a href="viewAllBookshelvesServlet">View all Bookshelves</a>
		</nav>
		<section>
			<form action="editBookServlet" method="post">
				<p>Title: <input type="text" name="title" value="${bookToEdit.title}"></p>
				<p>Author: <input type="text" name="author" value="${bookToEdit.author}"></p>
				<p>ISBN: <input type="text" name="isbn" value="${bookToEdit.isbn}"></p>
				<p>Publisher: <input type="text" name="publisher" value="${bookToEdit.publisher}"></p>
				<p>Pages: <input type="number" name="numOfPages" value="${bookToEdit.numOfPages}"></p>
				<p>Chapters: <input type="number" name="numOfChapters" value="${bookToEdit.numOfChapters}"></p>
				<p>Is Series: <input type="checkbox" name="isSeries" value="${bookToEdit.isSeries}"></p>
				<p>Genre: <input type="text" name="genre" value="${bookToEdit.genre}"></p>
				<input type="hidden" name="id" value="${bookToEdit.id}"><br>
				<hr>
				<br>
				<input type="submit" value="Update Book">
				<input type="reset" value="Reset">
			</form>
		</section>
		<footer>
				<p>Java II Partner Project Week 6-7. Tanner Patterson and Chris Pohlman.</p>
		</footer>
	</div>
</body>
</html>