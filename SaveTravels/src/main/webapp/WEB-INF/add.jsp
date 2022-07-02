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
<body style="margin: 10vw;">
<div class="container">
    <h1> Add an expense:</h1>
    <hr>
    <h3>Description must not be blank </h3>
    <%--@elvariable id="newExpense" type=""--%>
    <form:form method="POST" action="/new" modelAttribute="newExpense">
        <div>
            <form:label path="expenseName">Expense Name</form:label> <br/>
            <form:errors path="expenseName" class="text-danger"/>
            <form:input style="width:250px;" path="expenseName" type="text"/>
        </div>
        <div>
            <form:label path="vendorName">Vendor</form:label> <br/>
            <form:errors path="vendorName" class="text-danger"/>
            <form:input style="width:250px;" path="vendorName" type="text"/>
        </div>
        <div>
            <form:label path="amount">Amount</form:label> <br/>
            <form:errors path="amount" class="text-danger"/>
            <form:input style="width:250px;" path="amount" type="text"/>
        </div>
        <div>
            <form:label path="description">Description: </form:label><br/>
            <form:errors path="description" class="text-danger"/>
            <form:textarea style="width:250px;" rows="3" path="description"/>
        </div>
        <div>
            <button>Create an Expense</button>
        </div>
    </form:form>

    <%-- the format that used before modelattribute --%>
    <%--<form action="/htmladd" method="post">
        <p>Expense Name:</p>
        <input name="expenseName" type="text">
        <p>Vendor:</p>
        <input name="vendorName" type="text">
        <p>Amount:</p>
        <input name="amount" type="text">
        <button>Submit</button>
    </form> --%>
</div>
</body>
</html>