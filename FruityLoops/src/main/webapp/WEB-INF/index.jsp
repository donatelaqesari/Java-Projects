<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Fruits</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="container">
    <h1>Fruit Store</h1>
    <table class="table">
        <tbody>

        <tr>
            <th>Name</th>
            <th>Price</th>
        </tr>
        <c:forEach var="item" items="${allFruits}">
            <tr>

                <td><c:out value="${item.name}"></c:out></td>
                <td><c:out value="${item.price}"></c:out></td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>