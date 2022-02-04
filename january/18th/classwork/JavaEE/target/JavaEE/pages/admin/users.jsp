<%--
  Created by IntelliJ IDEA.
  User: zzz
  Date: 29.01.2022
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
    <title>Users</title>
</head>
<body>

    <div class="container">
        <div class="row mt-4">
            <div class="col">
                <table class="table">
                    <thead class="table-dark">
                        <tr>
                            <th scope="col">Email</th>
                            <th scope="col">Login</th>
                            <th scope="col">Role</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.users}" var="item">
                            <tr>
                                <td>${item.email}</td>
                                <td>${item.login}</td>
                                <td>${item.role}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</body>
</html>
