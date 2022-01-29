<%--
  Created by IntelliJ IDEA.
  User: zzz
  Date: 26.01.2022
  Time: 12:09
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
    <title>Registration</title>
</head>
<body>

    <div class="container">

        <div class="row mb-3 mt-3">
            <p class="h3 text-center">Registration</p>
            <c:if test="${requestScope.wrongValueMessage != null}">
                <p class="text-danger text-center mb-3 mt-3">${requestScope.wrongValueMessage}</p>
            </c:if>

            <c:if test="${requestScope.registrationResult != null}">
                <p class="text-danger text-center mb-3 mt-3">${requestScope.registrationResult}</p>
            </c:if>
        </div>

        <div class="row justify-content-center">
            <div class="col-6">
                <form action="${pageContext.request.contextPath}/registration" method="post">
                    <div class="mb-3">
                        <label for="email" class="form-label">Email</label>
                        <input type="email" class="form-control" id="email" name="email" value="${param.email}" required/>
                    </div>
                    <div class="mb-3">
                        <label for="login" class="form-label">Login</label>
                        <input type="text" class="form-control" id="login" name="login" value="${param.login}" required>
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Password</label>
                        <input type="password" class="form-control" id="password" name="password" required>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>

    </div>

</body>
</html>
