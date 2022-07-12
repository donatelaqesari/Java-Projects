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
<h2>HI ${user.firstName} ${user.lastName}</h2> <%-- user same as the addatribute--%>
    <p>Books from everyone's shelves:</p>
    <p><a href="/newBook">+ Add to my shelf!</a></p>
    <p><a href="/logout">logout</a></p>

<hr>
<table class="table table-striped table-bordered">
    <thead class="table-dark">
    <tr>
        <td class="text-center">ID</td>
        <td class="text-center">Title</td>
        <td class="text-center">Author Name</td>
        <td class="text-center">Posted By</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${allBooks}">
        <tr>
            <td class="text-center">${book.id}</td>
            <td class="text-center"><a href="/books/${book.id}">${book.title}</a></td>
            <td class="text-center">${book.author}"</td>
            <td class="text-center">${book.user.firstName}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>