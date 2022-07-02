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
    <title>Edit my task</title>
</head>
<body style="margin: 10vw" ;>
<div class="container">
    <h1> Edit an expense:</h1> <a href="/expenses/">Go back</a>
    <hr>

    <%--@elvariable id="newExpense" type=""--%>
    <form:form method="POST" action="/edit/${newExpense.id}" modelAttribute="newExpense">
        <div class="row ">

            <form:label path="expenseName" class="col-md-3 mb-1">Expense Name</form:label> <br/>
            <form:errors path="expenseName" class="text-danger"/>
            <form:input style="width:250px;" class="col-md-3 mb-1" path="expenseName" type="text"/>
        </div>
        <div class="row">
            <form:label path="vendorName" class="col-md-3 mb-1">Vendor</form:label> <br/>
            <form:errors path="vendorName" class="text-danger"/>
            <form:input style="width:250px;" class="col-md-3 mb-1" path="vendorName" type="text"/>
        </div>
        <div class="row">
            <form:label path="amount" class="col-md-3 mb-1">Amount</form:label> <br/>
            <form:errors path="amount" class="text-danger"/>
            <form:input style="width:250px;" class="col-md-3 mb-1" path="amount" type="text"/>
        </div>
        <div class="row">
            <form:label path="description" class="col-md-3 mb-1">Description: </form:label><br/>
            <form:errors path="description" class="text-danger"/>
            <form:textarea style="width:250px;" class="col-md-3 mb-1" rows="3" path="description"/>
        </div>
        <p>
            <button>Edit Expense</button>
        </p>
    </form:form>

</div>
</body>
</html>