<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
     <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <meta charset="UTF-8">
    <title>Books</title>
</head>
<body>
<div class="container">
    <h1>Change your Entry</h1>
    <a href="/books">Back to the shelves</a>
    <br>
    <a href="/books/delete/${book.id}">Delete</a>
    <br>
    <%--@elvariable id="book" type=""--%>
    <form:form action="/books/edit/${book.id}" method="post" modelAttribute="book">
        <input type="hidden" name="_method" value="put">
        <form:input type="hidden" name="user" path="user"/>

        <table>
            <thead>
            <tr>
                <td class="float-left">Title:</td>
                <td class="float-left">
                    <form:errors path="title" class="text-danger"/>
                    <form:input class="input" path="title"/>
                </td>
            </tr>
            <tr>
                <td class="float-left">Author:</td>
                <td class="float-left">
                    <form:errors path="author" class="text-danger"/>
                    <form:input class="input" path="author"/>
                </td>
            </tr>
            <tr>
                <td class="float-left">My Thoughts:</td>
                <td class="float-left">
                    <form:errors path="thoughts" class="text-danger"/>
                    <form:textarea rows="3" class="input" path="thoughts"/>
                </td>
            </tr>
            <tr>
                <td colspan=2><input class="input" class="button" type="submit" value="Submit"/></td>
            </tr>
            </thead>
        </table>



    </form:form>

</div>
</body>
</html>