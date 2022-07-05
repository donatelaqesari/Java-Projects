<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>Language</title>
</head>
<body>
<h2>  <c:out value="${ dojo.name }" /> </h2>

<c:forEach items="${ ninjas }" var="ninja">
    <div>
        <span> <c:out value="${ ninja.firstName } " /> </span>
        <span> <c:out value="${ ninja.lastName } " /> </span>
        <span> <c:out value="${ ninja.age } " /> </span>
    </div>

</c:forEach>
</body>
</html>