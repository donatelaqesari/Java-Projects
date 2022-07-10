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
<<div class="container">
    <h1> Create a new dorm</h1>
    <hr>
    <form action="/dorms/new" method="post">
        <p>Dorm Name:</p>
        <input name="name" type="text">
        <button>Add Dorm</button>
    </form>
</div>
</body>
</html>