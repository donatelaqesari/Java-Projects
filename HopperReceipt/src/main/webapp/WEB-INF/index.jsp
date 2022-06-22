<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Simple Receipt</title>
</head>
<body>
<p><h1>Customer Name: <c:out value="${name}"></c:out></h1></p>
<p> <h3>Item name: <c:out value="${itemName}"></c:out></h3></p>
<p><h3>Price: <c:out value="${price}"></c:out></h3></p>
<p><h3>Description: <c:out value="${description}"></c:out></h3></p>
<p><h3>Vendor: <c:out value="${vendor}"></c:out></h3> </p>
</body>
</html>