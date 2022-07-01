<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>Add an Album</title>
</head>
<body>
<div class="container">
<h1> Create a new album</h1>
<hr>
<h3>HTMLS forms Way </h3>
<form action="/new" method="post">
    <p>Album Name:</p>
    <input name="albumName" type="text">
    <p>Band Name:</p>
    <input name="bandName" type="text">
    <p>Year:</p>
    <input name="year" type="text">
    <button>Add Album</button>
</form>
</div>
</body>
</html>