<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>Show Language</title>
</head>
<body style="margin: 10vw" ;>
<div class="container">
    <h1>Language Details </h1>
    <a href="/languages/">Dashboard</a>
    <p>Expense: ${language.name}</p>
    <p>Vendor: ${language.creator}</p>
    <p> Amount: ${language.currentVersion}</p>

</div>
</body>
</html>