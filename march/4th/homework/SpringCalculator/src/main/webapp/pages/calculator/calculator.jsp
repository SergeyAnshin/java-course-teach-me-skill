<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>Calculator</title>
</head>
<body>

    <form action="/calculator/calculation" method="post">

        <label for="result">Result</label>
        <input type="text" id="result" value="${result}" readonly>
        <br><br>

        <label for="firstValue">First value</label>
        <input type="text" id="firstValue" name="firstValue"
               pattern="^[-+]?\d*[.,]?\d+(?:[eE][-+]?\d+)?$" required>
        <br><br>

        <label for="secondValue">Second value</label>
        <input type="text" id="secondValue" name="secondValue"
               pattern="^[-+]?\d*[.,]?\d+(?:[eE][-+]?\d+)?$" required>
        <br><br>

        <label for="operation">Operation</label>
        <select id="operation" name="operation">
            <c:forEach items="${operations}" var="operation" >
                <option value="${operation}">${operation}</option>
            </c:forEach>
        </select>
        <br><br>

        <input type="submit">

    </form>

</body>
</html>
