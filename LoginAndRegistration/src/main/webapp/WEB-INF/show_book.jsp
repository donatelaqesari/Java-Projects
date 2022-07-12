<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
     <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <meta charset="UTF-8">
    <title>Books</title>
</head>
<body>
<div class="container">
<h1>${book.title}</h1>
    <br>
    <p><a href="/books">back to the shelves</a></p>
    <br>
    <span style="color: red">${user.firstName}</span>
    <span> read </span>
    <span style="color: purple">${book.title}</span>
    <span> by </span>
    <span style="color: green">${book.author}</span>
    <br>
    <span>Here are ${user.firstName}'s thoughts:</span>
    <hr>
    <p>${book.thoughts}</p>

    <%-- edit if the book was posted by the person who loged in --%>
<%-- <c:if test = "${user__id == book.user.id}"> --%>
     <hr>
     <a href="/books/edit/${book.id}">Edit</a>
<%-- </c:if> --%>
</div>
</body>
</html>