<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>All Books</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Language</th>
        <th>Number of Pages</th>
    </tr>
    </thead>
    <tbody>
    <!-- loop over all the books to show the details as in the wireframe! -->
    <c:forEach items="${books}" var="book">
        <tr>
            <td><c:out value="${book.id}"></c:out></td>
            <td><a href="/books/${book.id}"><c:out value="${book.title}"></c:out></a></td>
            <td><c:out value="${book.language}"></c:out></td>
            <td><c:out value="${book.numberOfPages}"></c:out></td>
        </tr>

    </c:forEach>
    </tbody>
</table>
</body>
</html>