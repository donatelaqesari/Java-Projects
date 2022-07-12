<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
    integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1ovZ6jIW3" crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>Add new Student</title>
</head>
<body>
<div class="container">
    <h1>Add a new student </h1>
    <a href="/dorms/new">Add a Dorm</a>
    <hr>

    <%--@elvariable id="student" type=""--%>
    <form:form method="POST" action="/student/newStudent" modelAttribute="student">
        <div class="form-control">
            <form:label path="studentName">Student Name:</form:label>
            <form:errors path="studentName"/>
            <form:input path="studentName" type="text"/>
        </div>
        <form:select path="dorm">
            <c:forEach items="${dorms}" var="dorm">
                <option value="${dorm.id}"> ${dorm.name}</option>
            </c:forEach>
        </form:select>

        <button>Add Student</button>
    </form:form>
</div>
</body>
</html>