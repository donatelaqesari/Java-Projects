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
<body style="margin: 10vw;">
<div class="container">
    <h1>Programming Languages </h1>
    <a href="/new">Add language</a>
    <hr>
    <table class="table table-striped table-bordered">
        <thead class="table-dark">
        <tr>
            <th class="text-center">Id</th>
            <th class="text-center">Name</th>
            <th class="text-center">Creator</th>
            <th class="text-center">Version</th>
            <th class="text-center">Actions</th>
            <%--<th class="text-center">Delete</th> --%>

        </tr>
        </thead>
        <tbody>
        <%-- put all the staff inside the head --%>
        <jsp:useBean id="allLanguages" scope="request" type="java.util.List"/>
        <c:forEach items="${allLanguages}" var="language">
            <tr>
                <td class="text-center">${language.id}</td>
                <td class="text-center"><a href="/languages/${language.id}"/>${language.name}</td>
                <td class="text-center">${language.creator}</td>
                <td class="text-center"> ${language.currentVersion}</td>

                <td class="text-center"><a href="/edit/${language.id}">edit</a></td>
                <td class="text-center"><a href="/languages/${language.id}/delete"> delete </a></td>

            </tr>

        </c:forEach>
        </tbody>


    </table>

</div>
</body>
</html>