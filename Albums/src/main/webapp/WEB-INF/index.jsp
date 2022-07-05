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
    <h1>Welcome to Records </h1>
    <a href="/new">Add an album</a> <a href="/song/new">Add a new Song</a>
    <hr>
    <table class="table table-striped table-dark">
        <thead>
        <tr>
            <th>Id</th>
            <th>Album Name</th>
            <th>Band Name</th>
            <th>Year</th>
        </tr>

        <%-- put all the staff inside the head --%>
        <c:forEach items="${allAlbums}" var="album">
            <tr>
                <td>${album.id}</td>
                <td><a href="/details/${album.id}">${album.albumName}</a></td>
                <td>${album.bandName}</td>
                <td>${album.year}</td>
            </tr>

        </c:forEach>

        </thead>

    </table>

</div>
</body>
</html>