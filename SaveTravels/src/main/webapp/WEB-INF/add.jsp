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
    <title>Add an Expense</title>
</head>
<body>
<div class="container">
    <h1> Add an expense:</h1>
    <hr>
    <h3>Description must not be blank </h3>
    <%--@elvariable id="newExpense" type=""--%>
    <form:form method="POST" action="/new" modelAttribute="newExpense">
        <form:label path="expenseName">Expense Name</form:label>
        <form:errors path="expenseName"/>
        <form:input path="expenseName" type="text"/>
        <form:label path="vendorName">vendor</form:label>
        <form:errors path="vendorName"/>
        <form:input path="vendorName" type="text"/>
        <form:label path="amount">Amount</form:label>
        <form:errors path="amount"/>
        <form:input path="amount" type="text"/>
        <p>
            <button>Create an Expense</button>
        </p>
    </form:form>

    <%-- the format that used before modelattribute --%>
    <form action="/htmladd" method="post">
        <p>Expense Name:</p>
        <input name="expenseName" type="text">
        <p>Vendor:</p>
        <input name="vendorName" type="text">
        <p>Amount:</p>
        <input name="amount" type="text">
        <button>Submit</button>
    </form>
</div>
</body>
</html>