<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collections" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/main.css">
</head>
<body>

<h2> Your Gold <span> <%= session.getAttribute("gold") %></span></h2>

<div class="boxes">

    <div class="container">
        <form action="/" method="post">
            <h3>Farm</h3>
            <p> (earns 10 - 20 gold) </p>
            <input type="hidden" name="place" value="FARM">
            <input type="submit" value="Find Gold!">
        </form>
    </div>

    <div class="container">
        <form action="/" method="post">
            <h3>Cave</h3>
            <p> (earns 10 - 20 gold) </p>
            <input type="hidden" name="place" value="CAVE">
            <input type="submit" value="Find Gold!">
        </form>
    </div>

    <div class="container">
        <form action="/" method="post">
            <h3>House</h3>
            <p> (earns 10 - 20 gold) </p>
            <input type="hidden" name="place" value="HOUSE">
            <input type="submit" value="Find Gold!">
        </form>
    </div>

    <div class="container">
        <form action="/" method="post">
            <h3>SPA</h3>
            <p> (lose 10 - 20 gold) </p>
            <input type="hidden" name="place" value="SPA">
            <input type="submit" value="Find Gold!">
        </form>
    </div>

    <div class="container">
        <form action="/" method="post">
            <h3>Quest</h3>
            <p> (earns / takes 0 - 50 gold) </p>
            <input type="hidden" name="place" value="QUEST">
            <input type="submit" value="Find Gold!">
        </form>
    </div>
</div>
<div id="activities">
    <h3 class="act">Activities:</h3>
    <ul>
        <% ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
            Collections.reverse(activities);
            for (String activity : activities) {
                if (activity.toLowerCase().contains("lost".toLowerCase())) {%>
        <li class="red"><%= activity %>
        </li>
        <% } else { %>
        <li class="green"><%= activity %>
        </li>
        <% }
        } %>
    </ul>
</div>
<div class="footer">
    <a href="/reset" class="reset" role="button">Start New Game</a>
</div>
</body>
</html>