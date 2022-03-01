<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Book</title>
</head>
<body>
	<form action="editBookServlet" method="post">
		<p>Title: <input type="text" name="title" value="${bookToEdit.title}"></p>
		<p>Author: <input type="text" name="author" value="${bookToEdit.author}"></p>
		<p>ISBN: <input type="text" name="isbn" value="${bookToEdit.isbn}"></p>
		<p>Publisher: <input type="text" name="publisher" value="${bookToEdit.publisher}"></p>
		<p>Pages: <input type="number" name="numOfPages" value="${bookToEdit.numOfPages}"></p>
		<p>Chapters: <input type="number" name="numOfChapters" value="${bookToEdit.numOfChapters}"></p>
		<p>Is Series: <input type="checkbox" name="isSeries" value="${bookToEdit.isSeries}"></p>
		<p>Genre: <input type="text" name="genre" value="${bookToEdit.genre}"></p>
		<input type="hidden" name="id" value="${bookToEdit.id}">
		<input type="submit" value="Update Book">
		<input type="reset" value="Reset">
	</form>
</body>
</html>