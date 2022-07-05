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
    <title>Language</title>
</head>
<body style="margin: 10vw;">
<%--@elvariable id="newDojo" type=""--%>
<form:form method="POST" action="/dojos/new" modelAttribute="newDojo">
    <form:hidden path="id"/>
    <form:label path="name">Name
        <form:input path="name"/>
    </form:label><br>

    <input type="submit" name="" value="Create">
</form:form>
</body>
</html>