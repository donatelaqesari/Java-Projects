<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body style="margin: 10vw;">
<div class="container">
    <h1>Save Travels </h1>
    <a href="/new">Add an expense</a>
    <hr>
    <table class="table table-striped table-dark">
        <thead>
        <tr>
            <th class="text-center">Id</th>
            <th class="text-center">Expense</th>
            <th class="text-center">Vendor</th>
            <th class="text-center">Amount</th>
            <th class="text-center">Actions</th>
            <th class="text-center">Delete</th>

        </tr>

        <%-- put all the staff inside the head --%>
        <c:forEach items="${allExpenses}" var="expense">
            <tr>
                <td class="text-center">${expense.id}</td>
                <td class="text-center"><a href="/expenses/${expense.id}"/>${expense.expenseName}</td>
                <td class="text-center">${expense.vendorName}</td>
                <td class="text-center"> ${expense.amount}</td>

                <td class="text-center"><a href="/edit/${expense.id}">edit</a></td>
                <form action="/expenses/${expense.id}" method="POST">
                    <input type="hidden" name="_method" value="delete">
                    <td class="text-center"><input class="btn btn-danger" class="shadow-lg p-3 mb-5 bg-white rounded"
                                                   type="submit" value="Delete"></td>
                </form>

            </tr>

        </c:forEach>

        </thead>

    </table>

</div>
</body>
</html>