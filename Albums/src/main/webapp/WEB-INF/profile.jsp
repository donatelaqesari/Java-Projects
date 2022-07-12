<%--
  Created by IntelliJ IDEA.
  User: donatelaqesari
  Date: 11.7.22
  Time: 4:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>Album Details</title>
</head>
<body>
<t:wrapper>
    <h2>Details for ${user.firstName} ${user.lastName}</h2>
    <hr>
    <h3>Albums Added</h3>
    <ul>
        <c:forEach items="${user.myalbums}" var="album">
            <li><a href="/${album.id}">${album.bandName} - ${album.albumName}</a></li>
        </c:forEach>
    </ul>
</t:wrapper>
</body>
</html>
