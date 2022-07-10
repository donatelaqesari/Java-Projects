<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>Language</title>
</head>
<body>
<div class="container">
        <a href="dojos"> Dashboard</a>
        <h1>New Ninja</h1>
        <%--@elvariable id="ninjas" type=""--%>
        <%--@elvariable id="ninja" type=""--%>
        <form:form class="form"  action="/ninjas" method="POST" modelAttribute="ninja">
            <div class="form-group row">
                <form:label path="dojo"> Select Dojo:</form:label>
                <form:select path="dojo">
                    
                   

                    <c:forEach items="${dojo}" var="dojo">
                        <form:option value="${dojo}"><c:out value="${dojo.location}"/></form:option>
                    </c:forEach>
                </form:select>
            </div>
            <div class="form-group row">
                <form:label path="firstName">First Name:</form:label>
                <form:input path="firstName"/>
            </div>
            <div class="form-group row">
                <form:label path="lastName">Last Name:</form:label>
                <form:input path="lastName"/>
            </div>
            <div class="form-group row">
                <form:label cssClass="label left" path="age">Age:</form:label>
                <form:input cssClass="box" path="age"/>
            </div>
            <input class="btn btn-primary" type="submit" value="Create"/>
        </form:form>
    </div>

</body>
</html>