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
    <title>Add book</title>
</head>
<body>
<
<div class="container">

        <h2><a href="/books">back to the shelves</a></h2>
    </div>
    <h1>Add a Book to Your Shelf!</h1>
    <hr>
    <form action="/books/newBook" method="POST" modelAttribute="book">
        <table>
            <thead>
            <tr>
                <div class="form-control">
                    <td>
                        <form:label path="title" >Book Title:</form:label>
                        <form:errors path="title"/>
                        <form:input path="title" type="text"/>
                    </td>
                </div>
            </tr>
            <tr>
                <div class="form-control">
                    <td>
                        <form:label path="author">Book Author:</form:label>
                        <form:errors path="author"/>
                        <form:input path="author" type="text"/>
                    </td>
                </div>
            </tr>
            <tr>
                <div class="form-control">
                    <td>
                        <form:label path="thoughts">My Thoughts:</form:label>
                        <form:errors path="thoughts"/>
                        <form:textarea rows="3" path="thoughts"/>
                    </td>
                </div>
            </tr>
            <tr>
                <td><input class="input" class="button" type="submit" value="Submit"/></td>
            </tr>
            </thead>
        </table>
    </form>

</body>
</html>