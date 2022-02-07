<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
    <title>Calculator</title>
</head>
<body>
    <div class="container">

        <div class="row mb-3 mt-3">
            <p class="h3 text-center">Calculator</p>
            <c:if test="${requestScope.wrongParameterMessage != null}">
                <p class="text-danger text-center mb-3 mt-3">${requestScope.wrongParameterMessage}</p>
            </c:if>
        </div>

        <div class="row justify-content-center mb-3 mt-3">
            <div class="col-6">
                <form action="${pageContext.request.contextPath}/calculator" method="post">
                    <div class="mb-3">
                        <label for="result" class="form-label">Result</label>
                        <input type="text" class="form-control" id="result" name="result"
                               value="${requestScope.result.result}" readonly required>
                    </div>
                    <div class="mb-3">
                        <label for="firstValue" class="form-label">First value</label>
                        <input type="text" class="form-control" id="firstValue" name="firstValue"
                               value="${param.firstValue}"  pattern="^[-+]?\d*[.,]?\d+(?:[eE][-+]?\d+)?$" required>
                    </div>
                    <div class="mb-3">
                        <label for="secondValue" class="form-label">Second value</label>
                        <input type="text" class="form-control" id="secondValue" name="secondValue"
                               value="${param.secondValue}" pattern="^[-+]?\d*[.,]?\d+(?:[eE][-+]?\d+)?$" required>
                    </div>
                    <div class="mb-3">
                        <label for="operationType" class="form-label">Operation</label>
                        <select class="form-select" id="operationType" name="operationType">
                            <c:forEach items="${applicationScope.operationTypes}" var="operationType" >
                                <option value="${operationType.name()}">${operationType.name()}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>

    </div>

</body>
</html>
