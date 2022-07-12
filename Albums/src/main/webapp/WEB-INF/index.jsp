<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <meta charset="ISO-8859-1">
    <title>Title</title>
</head>
<body>
<t:wrapper>

    <hr>
    <table class="table table-striped table-dark">
        <thead>
        <tr>

            <th>Album Name</th>
            <th>Band Name</th>
            <th>Number of Likes</th>
            <th>Year</th>
            <th>Action</th>
        </tr>

            <%-- put all the staff inside the head --%>
        <c:forEach items="${allAlbums}" var="album">
            <tr>
                <td><a href="/details/${album.id}">${album.albumName}</a></td>
                <td>${album.bandName}</td>
                <td>${album.likers.size()}</td>
                <td>${album.year}</td>
                <td>
                    <c:choose>
                        <c:when test="${album.likers.contains(user)}">
                            You liked this!
                            <a href="/unlike/${album.id}">Unlike</a>
                        </c:when>
                        <c:otherwise><a href="/like/${album.id}">Like</a></c:otherwise>
                    </c:choose>

                </td>
            </tr>

        </c:forEach>

        </thead>

    </table>

</t:wrapper>
</body>
</html>