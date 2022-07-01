<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div class="container">
    <h1>All Dogs </h1>
    <a href="/new">Add dog</a>
    <hr>
    <table class="table table-striped table-dark">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Breed</th>
            <th>Age</th>
        </tr>

        <%-- put all the staff inside the head --%>
        <c:forEach items="${allDogs}" var="dog">
            <tr>
                <td>${dog.id}</td>
                <td>${dog.name}</td>
                <td>${dog.breed}</td>
                <td>${dog.age}</td>
            </tr>

        </c:forEach>

        </thead>

    </table>

</div>
</body>
</html>