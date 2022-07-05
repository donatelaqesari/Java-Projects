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
<%--@elvariable id="newNinja" type=""--%>
<form:form method="POST" action="/ninjas/new" modelAttribute="newNinja">
<form:hidden path="id"/>

<%--  <form:select name="dojo">Dojo:
    <form:options items="${ dojos }" itemLabel="name" itemValue="id" />
</form:select>  --%>
<select name="dojo">
    <c:forEach items="${ dojos }" var="dojo">
        <option value=<c:out value="${ dojo.id }"/> > <c:out value="${ dojo.name }"/> </option>

    </c:forEach>

</select>
<form:label path="firstName">First Name
    <form:input path="firstName"/>
</form:label><br>

<form:label path="lastName">Last Name
    <form:input path="lastName"/>
</form:label><br>

<form:label path="age">Age
    <form:input path="age" type="number"/>
</form:label><br>

<input type="submit" name="" value="Create Person">
</form:form>
</body>
</html>