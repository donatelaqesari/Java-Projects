<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/main.css">
    <title>Title</title>
</head>
<body>
<h1> Here's Your Omikuji!</h1>
<div class="container block">
    <p> In <c:out value="${numbers}"/> years, you will live in
        <c:out value="${city}"/> with <c:out value="${person}"/> as your roommate,
        <c:out value="${hobby}"/> for a living. The next time you see a <c:out value="${thing}"/>, you will have good
        luck.
        Also, <c:out value="${comment}"/>
    </p>
    <a href="/"> Go Back!</a>
</div>
</body>
</html>