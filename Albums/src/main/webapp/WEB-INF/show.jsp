<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>Album Details</title>
</head>
<body>
<div class="container">
    <h1>Album Details </h1>
    <p>Added By: <i> <a
            href="/profile/${albumDetails.owner.id}">${albumDetails.owner.firstName} ${albumDetails.owner.lastName}</a></i>
    </p>
    <p>Name: ${albumDetails.albumName}</p>
    <p>Band Name: ${albumDetails.bandName}</p>
    <p>Year: ${albumDetails.year}</p>
    <hr>
    <h3>Liked By</h3>
    <ul>
        <c:forEach items="${albumDetails.likers}" var="user">
            <li>${user.firstName} ${user.lastName}</li>
        </c:forEach>
    </ul>
    <hr>
    <h3>Track Listings</h3>
    <hr>
    <c:forEach items="${albumDetails.songs}" var="song">
        <ul>
            <li>
                    ${song.name} - <i>${song.length}</i>
            </li>
        </ul>
    </c:forEach>
</div>
</body>
</html>