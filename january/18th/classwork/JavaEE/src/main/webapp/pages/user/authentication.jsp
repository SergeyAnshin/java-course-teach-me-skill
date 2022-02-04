<%--
  Created by IntelliJ IDEA.
  User: zzz
  Date: 26.01.2022
  Time: 17:23
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
    <title>Log in</title>
</head>
<body>

    <div class="container">

        <div class="row mt-4">
            <div class="col">
                <c:if test="${requestScope.failedAuthenticationMessage != null}">
                    <p class="text-danger text-center mb-3 mt-3">${requestScope.failedAuthenticationMessage}</p>
                </c:if>
            </div>
        </div>

        <div class="row justify-content-center">
            <div class="col-4">
                <form action="${pageContext.request.contextPath}/auth" method="post">
                    <div class="form-floating mb-4">
                        <input type="text" class="form-control" id="login" name="login" placeholder="Neo" required>
                        <label for="login">login</label>
                    </div>
                    <div class="form-floating mb-1">
                        <input type="password" class="form-control" id="password" name="password"
                               placeholder="Neo" required>
                        <label for="password">password</label>
                    </div>
                    <div class="mb-4">
                        <p class="text-end">
                            <a href="${pageContext.request.contextPath}/password-reset" class="text-decoration-none text-sm text-dark" >
                                Forgot your password?
                            </a>
                        </p>
                    </div>
                    <div class="d-grid mb-4">
                        <button type="submit" class="btn btn-primary">Log in</button>
                    </div>
                    <div class="mb-4">
                        <p class="text-center">
                            <a href="${pageContext.request.contextPath}/registration" class="text-reset">Sign up</a>
                            if you don't have an account yet.
                        </p>
                    </div>
                </form>
            </div>
        </div>
    </div>

</body>
</html>
