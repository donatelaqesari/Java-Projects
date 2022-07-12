<%@ tag language="java"
        pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>Add an Album</title>
</head>
<body>
<div class="container">
    <h1>Welcome to Albums dot com</h1>
    <nav>
        <a href="/new">Add an album</a> |
        <a href="/songs/new">Add a song</a> |
        <a href="/logout">Logout</a>
    </nav>
    <hr>
    <jsp:doBody/>
</div>
</body>
</html>