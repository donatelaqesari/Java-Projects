<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>Dorms</title>
</head>
<body>
<div class="container">
    <h1>Welcome to Dorms </h1>
    <a href="/dorms/new">Add a new Dorm</a> <a href="/student/newStudent">Add a new Student</a>
    <hr>
    <table class="table table-striped table-bordered">
        <thead class="table-dark">
        <tr>
            <th class="text-center">Id</th>
            <th class="text-center">Dorm Name</th>
            <th class="text-center">Actions</th>
        </tr>

        <%-- put all the staff inside the head --%>
        <c:forEach items="${allDorms}" var="dorm">
            <tr>
                <td class="text-center">${dorm.id}</td>
                <td class="text-center">${dorm.name}</td>
                <td class="text-center"><a href="/dorms/${dorm.id}">See Students</a></td>
            </tr>
        </c:forEach>

        </thead>

    </table>

</div>
</body>
</html>