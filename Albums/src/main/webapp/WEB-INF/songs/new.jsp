<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>Add new Song</title>
</head>
<body>
<div class="container">
    <h1>Add a new song </h1>
    <a href="/new">Add an album</a>
    <hr>
    <%--@elvariable id="song" type=""--%>
    <form:form method="POST" action="/song/newSong" modelAttribute="song">
        <div class="form-control">
            <form:label path="name">Song Name:</form:label>
            <form:errors path="name"/>
            <form:input path="name" type="text"/>
        </div>
        <div class="form-control">
            <form:label path="length">Length:</form:label>
            <form:errors path="length"/>
            <form:input path="length" type="text"/>
        </div>
        <form:select path="albumSongIsON">
            <c:forEach items="${albums}" var="album">
                <option value="${album.id}">${album.bandName} ${album.albumName}</option>
            </c:forEach>
        </form:select>

        <button>Add Song</button>
    </form:form>
</div>
</body>
</html>