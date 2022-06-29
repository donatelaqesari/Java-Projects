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
<c:forEach items="${allBooks}" var="books">
    <h1>${books.title}</h1>
    <div class="information">
        <h3> Description: ${books.description} </h3>
        <h3>Language: ${books.language}</h3>
        <h3>Number of pages: ${books.numberOfPages} </h3>
    </div>

</c:forEach>
</body>
</html>