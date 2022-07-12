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
    <title>Thought Border</title>
</head>
<body>
<h2>HI ${user.firstName} ${user.lastName}</h2> <%-- user same as the addatribute--%>
<hr>
<%-- to add any thought we need form GetMaping/dashboard--%>
<%--@elvariable id="thought" type=""--%>
<form:form method="POST" action="/thoughts/addThought" modelAttribute="thought">
    <form:errors path="description"/>
    <form:textarea class="form-control" path="description" placeholder="Post a Great Thought Here!"/>
    <button>Add Thought</button>
</form:form>
<hr>

<%-- display the blocks with the thoughts, we need a foreach because thoughts are in a list--%>
<c:forEach items="${allThoughts}" var="thought">
    <%-- for the like unlike button on and off--%>
    <p>
        <c:choose>
            <%-- test="if the user has liked "--%>
            <c:when test="${thought.likers.contains(user)}">
                <a href="/thoughts/${thought.id}/unlike">UNLIKE</a>
            </c:when>
            <c:otherwise>
                <a href="/thoughts/${thought.id}/like">LIKE</a>
            </c:otherwise>
        </c:choose>
    </p>

    <%-- all thoughts have a descriptoon and a user--%>
    <p> ${thought.user.firstName} says: ${thought.description}</p>

    <%-- for the tag details--%>
    <p> <a href="${thought.id}"> Details: </a> |  ${thought.likers.size()} likes </p>

    <%-- DELETE BUTTON--%>
    <p>
        <c:if test="${thought.user.id == user.id}">
            <a href="/thoughts/${thought.id}/delete"> DELETE</a>
        </c:if>
    </p>

</c:forEach>

</body>
</html>