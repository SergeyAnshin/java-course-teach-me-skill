<%--
  Created by IntelliJ IDEA.
  User: zzz
  Date: 28.01.2022
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
    <title>Successful registration</title>
</head>
<body>

    <div class="container">

        <div class="row mt-3 mb-3">
            <div class="col">
                <h4>${requestScope.registrationResult}</h4>
            </div>
        </div>

        <div class="row mt-3 mb-3">
            <div class="col">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/login" role="button">Login</a>
            </div>
            <div class="col">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/registration"
                   role="button">Registration</a>
            </div>
        </div>

    </div>

</body>
</html>
