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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>New Dojo</title>
</head>
<body>
    <div class="container">

            <h1>New Dojo</h1>
            <%--@elvariable id="dojoObject" type=""--%>
            <%--@elvariable id="dojo" type=""--%>
            <form:form class="form" action="/dojos" method="POST" modelAttribute="dojo">
                <div class="form-group row">
                    <form:label  path="location">Location:</form:label>
                    <form:errors path="location"> </form:errors>
                    <form:input path="location"/>
                </div>
                <input type="submit" class="btn btn-primary" value="Create"/>
            </form:form>

        <table class="table">
            <tr class="table-info">
                <th>Location</th>
                <th>Action</th>
            </tr>
          

            <c:forEach items="${dojos}" var="dojo">
                <tr>
                <td><c:out value="${dojo.location}"/></td>
                <td><a href="/dojos/<c:out value="${dojo.id}"/> "> See students</a></td>
                </tr>
            </c:forEach>

        </table>
        </div>
</body>
</html>