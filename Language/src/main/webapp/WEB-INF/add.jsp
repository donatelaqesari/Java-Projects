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
    <title>Add Language</title>
</head>
<body style="margin: 10vw;">
<div class="container">
    <h1> Add Language:</h1>
    <hr>
    <%--@elvariable id="newExpense" type=""--%>
  
    <%--@elvariable id="language" type=""--%>
    <form:form method="POST" action="/new" modelAttribute="language">
        <div>
            <form:label path="name">Language Name:</form:label> <br/>
            <form:errors path="name" class="text-danger"/>
            <form:input style="width:250px;" path="name" type="text"/>
        </div>
        <div>
            <form:label path="creator">Creator:</form:label> <br/>
            <form:errors path="creator" class="text-danger"/>
            <form:input style="width:250px;" path="creator" type="text"/>
        </div>
        <div>
            <form:label path="currentVersion">Version:</form:label> <br/>
            <form:errors path="currentVersion" class="text-danger"/>
            <form:input style="width:250px;" path="currentVersion" type="text"/>
        </div>
        <div>
            <button>Create Language</button>
        </div>
    </form:form>
    
</div>
</body>
</html>