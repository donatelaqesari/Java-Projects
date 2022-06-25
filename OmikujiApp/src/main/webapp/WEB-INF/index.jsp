<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/main.css">
    <title>Omikuji</title>
</head>
<body>
<h1> Send an Omikuji!</h1>
<div class="container">
    <form action="/process" method="post">
        <h3>Pick any number from 5 to 25 </h3>
        <input class="formfields" type="number" name="numbers">
        <h3> Enter the name of any city</h3>
        <input class="formfields" type="text" name="city">
        <h3> Enter the name of any real person</h3>
        <input class="formfields" type="text" name="person">
        <h3> Enter professional endeavor or hobby</h3>
        <input class="formfields" type="text" name="hobby">
        <h3> Enter any type of living thing </h3>
        <input class="formfields" type="text" name="thing">
        <h3>Say something nice to someone:</h3>
        <h3><input class="formfieldscomment" type="textarea" name="comment"></h3>
        <h3> Send and show a friend</h3>
        <h3><input class="formfieldsbutton" type="submit" value="Send"></h3>
    </form>
</div>
</body>
</html>