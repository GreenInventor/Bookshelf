<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Add New Bookshelf</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="style.css" rel="stylesheet">
	<!-- Tanner Patterson and Chris Pohlman -->
</head>
<body>
	<div id="container">
		<header id="top">
			<h1>Add New Bookshelf</h1>
		</header>
		<nav>
			<a href="index.html">Home</a>
			<a href="viewAllBooksServlet">View all Books</a>
			<a href="viewAllBookshelvesServlet">View all Bookshelves</a>
		</nav>
		<section>
			<form action="createNewBookshelfServlet" method="post">
				<p>Bookshelf Name: <input type="text" name="name"></p>
				<p>Available Books:</p><select name="allBooksToAdd" multiple size="5">
					<c:forEach items="${requestScope.allBooks}" var = "currentBook">
						<option value="${currentBook.id}">${currentBook.title} by ${currentBook.author}</option>
					</c:forEach>
				</select><br>
				<hr>
				<br>
				<input type="submit" value="Create Bookshelf">
				<input type="reset" value="Reset">
			</form>
		</section>
		<footer>
			<p>Java II Partner Project Week 6-7. Tanner Patterson and Chris Pohlman.</p>
		</footer>
	</div>
</body>
</html>