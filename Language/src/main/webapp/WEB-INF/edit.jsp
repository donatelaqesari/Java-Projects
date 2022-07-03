<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>Java</title>
</head>
<body style="margin: 10vw" ;>
<div class="container">
    <h1> Edit Language:</h1> <a href="/languages/">Dashboard</a>  <a href="/languages/${language.id}/delete" > Delete </a>
    <hr>

    <%--@elvariable id="newExpense" type=""--%>
    <%--@elvariable id="language" type=""--%>
    <form:form method="POST" action="/edit/${language.id}" modelAttribute="language">
        <div class="row ">

            <form:label path="name" class="col-md-3 mb-1">Language Name</form:label> <br/>
            <form:errors path="name" class="text-danger"/>
            <form:input style="width:250px;" class="col-md-3 mb-1" path="name" type="text"/>
        </div>
        <div class="row">
            <form:label path="creator" class="col-md-3 mb-1">Creator</form:label> <br/>
            <form:errors path="creator" class="text-danger"/>
            <form:input style="width:250px;" class="col-md-3 mb-1" path="creator" type="text"/>
        </div>
        <div class="row">
            <form:label path="currentVersion" class="col-md-3 mb-1">Version</form:label> <br/>
            <form:errors path="currentVersion" class="text-danger"/>
            <form:input style="width:250px;" class="col-md-3 mb-1" path="currentVersion" type="text"/>
        </div>
        <p>
            <button>Submit</button>
        </p>
    </form:form>

</div>
</body>
</html>