<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.Date" import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="/css/timeStyle.css">

    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<%
    String pattern = "KK:mm aa";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
%>
<h1 class=date><%= simpleDateFormat.format(new Date()) %>
</h1>
<script src="/css/timeTemplate.js"></script>
</body>
</html>