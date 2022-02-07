<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
    <title>History</title>
</head>
<body>

    <div class="container">
        <div class="row mt-4">
            <div class="col">
                <table class="table">
                    <thead class="table-dark">
                        <tr>
                            <th scope="col">First value</th>
                            <th scope="col">Second value</th>
                            <th scope="col">Operation</th>
                            <th scope="col">Result</th>
                            <th scope="col">Time</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.calculationHistory}" var="item">
                            <tr>
                                <td>${item.firstValue}</td>
                                <td>${item.secondValue}</td>
                                <td>${item.operation}</td>
                                <td>${item.result}</td>
                                <td>${item.calculationTime}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</body>
</html>
