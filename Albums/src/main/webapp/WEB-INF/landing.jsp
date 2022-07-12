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
    <title>Login</title>
</head>
<body>
<div class="container">
    <h1>Welcome to Albums dot com</h1>
    <div class="row">
        <h3>Register</h3>
        <%--@elvariable id="user" type=""--%>
        <form:form method="POST" action="/registerUser" modelAttribute="user">
            <div class="form-group">
                <form:label path="firstName">First Name:</form:label>
                <form:errors path="firstName"/>
                <form:input class="form-control" path="firstName" type="text"/>
            </div>
            <div class="form-group">
                <form:label path="lastName">Last Name:</form:label>
                <form:errors path="lastName"/>
                <form:input class="form-control" path="lastName" type="text"/>
            </div>
            <div class="form-group">
                <form:label path="email">Email:</form:label>
                <form:errors path="email"/>
                <form:input class="form-control" path="email" type="text"/>
            </div>
            <div class="form-group">
                <form:label path="password">Password:</form:label>
                <form:errors path="password"/>
                <form:input class="form-control" path="password" type="password"/>
            </div>
            <div class="form-group">
                <form:label path="confirmPassword">Confirm Password:</form:label>
                <form:errors path="confirmPassword"/>
                <form:input class="form-control" path="confirmPassword" type="password"/>
            </div>
            <input class="btn btn-primary" type="submit" value="Submit"/>

        </form:form>
    </div>

    <div class="column">
        <h3>Login </h3>
        <p>${loginError}</p>
        <form action="/login" method="post">
            <label>Email Address</label>
            <input type="email" name="lemail">
            <label>Password</label>
            <input type="password" name="lpassword">
            <button>Login</button>
        </form>
    </div>
</div>
</body>
</html>