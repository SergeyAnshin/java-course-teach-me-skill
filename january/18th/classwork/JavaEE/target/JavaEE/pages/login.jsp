<%@ page import="org.anshin.servlet.ServletConstant" %><%--
  Created by IntelliJ IDEA.
  User: zzz
  Date: 26.01.2022
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
    <title>Log in</title>
</head>
<body>

    <div class="container">

        <div class="row mt-3 mb-3">
            <div class="col">
                <h4>${sessionScope.successfulRegistrationMessage}</h4>
                <h4>${requestScope.failedLogInMessage}</h4>
            </div>
        </div>

        <div class="row">
            <div class="col">
                <form action="${pageContext.request.contextPath}/login" method="post">
                    <div class="mb-3">
                        <label for="login" class="form-label">Login</label>
                        <input type="text" class="form-control" id="login" name="login" required>
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
