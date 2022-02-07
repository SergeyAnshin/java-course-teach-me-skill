<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
    <title>Settings</title>
</head>
<body>

    <div class="container">

        <div class="row ms-3 me-3 mt-3 mb-3">
            <div class="col">

                <div class="d-flex align-items-start">
                    <div class="nav flex-column nav-pills me-3" id="v-pills-tab" role="tablist" aria-orientation="vertical">

                        <button class="nav-link" id="v-pills-password-settings-tab" data-bs-toggle="pill"
                                data-bs-target="#v-pills-password-settings" type="button" role="tab"
                                aria-controls="v-pills-password-settings" aria-selected="false">Password settings</button>
                    </div>
                    <div class="tab-content" id="v-pills-tabContent">
                        <div class="tab-pane fade" id="v-pills-password-settings" role="tabpanel"
                             aria-labelledby="v-pills-password-settings-tab">

                            <div class="row">
                                <div class="col">
                                    <p class="text-start">
                                        Change password:
                                    </p>
                                </div>
                            </div>

                            <div class="row mb-3">
                                <div class="col">
                                    <form action="${pageContext.request.contextPath}/user-settings/new-password" method="post">
                                        <div class="form-floating mb-3">
                                            <input type="password" class="form-control" id="yourPassword" placeholder="Your password">
                                            <label for="yourPassword">Your password</label>
                                        </div>
                                        <div class="form-floating">
                                            <input type="password" class="form-control" id="newPassword" placeholder="New password">
                                            <label for="newPassword">New password</label>
                                        </div>
                                        <button type="submit" class="btn btn-primary">Submit</button>
                                    </form>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col">
                                    <p class="text-start">
                                        Create keyword:
                                    </p>
                                </div>
                            </div>

                            <div class="row mb-3 mt-3">
                                <c:if test="${requestScope.wrongValueMessage != null}">
                                    <p class="text-danger text-center mb-3 mt-3">${requestScope.wrongValueMessage}</p>
                                </c:if>
                            </div>

                            <div class="row">
                                <div class="col">
                                    <form action="${pageContext.request.contextPath}/user-settings/new-keyword" method="post">
                                        <div class="form-floating">
                                            <input type="text" class="form-control" id="keyword" name="keyword"
                                                   placeholder="keyword" pattern="^[a-zA-Z0-9]*$" required>
                                            <label for="keyword">New keyword</label>
                                        </div>
                                        <button type="submit" class="btn btn-primary">Submit</button>
                                    </form>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>

            </div>
        </div>

    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
</body>
</html>
