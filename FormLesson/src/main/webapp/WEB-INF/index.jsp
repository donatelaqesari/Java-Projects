<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h3>Login</h3>

<form action='/login' method='post'>
    <label>Email:</label>
    <input type="text" name='email'>
    <label>Password:</label>
    <input type='text' name='password'>
    <input type='submit' value='login'>
</form>

</body>
</html>