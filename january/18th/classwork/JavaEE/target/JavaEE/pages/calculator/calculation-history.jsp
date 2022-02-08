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
        <div class="row mt-4 mb-4">
            <form action="${pageContext.request.contextPath}/history/delete" method="post">
                <input type="hidden" name="deleteAll" value="deleteAll">
                <button type="submit"
                        onclick="return confirm('Are you sure you want to delete all results?')"
                        class="btn btn-primary">Delete all</button>
            </form>
        </div>
        <div class="row">
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
                                <td>
                                    <form action="${pageContext.request.contextPath}/history/delete" method="post">
                                        <input type="hidden" name="resultId" value="${item.id}">
                                        <button type="submit"
                                                onclick="return confirm('Are you sure you want to delete the result?')"
                                                class="btn btn-primary">Delete</button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

<%--        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">--%>
<%--            <div class="modal-dialog">--%>
<%--                <div class="modal-content">--%>
<%--                    <div class="modal-header">--%>
<%--                        <h5 class="modal-title" id="exampleModalLabel">Delete result</h5>--%>
<%--                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>--%>
<%--                    </div>--%>
<%--                    <div class="modal-body">--%>
<%--                        ...--%>
<%--                    </div>--%>
<%--                    <div class="modal-footer">--%>
<%--                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>--%>
<%--                        <button type="button" class="btn btn-primary">Delete</button>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
    </div>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
</body>
</html>
