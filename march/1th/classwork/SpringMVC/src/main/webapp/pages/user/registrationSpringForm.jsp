<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>RegSpring</title>
</head>
<body>
    <s:form action="/user/reg" method="post" modelAttribute="newUser">
        <label for="name">Name</label>
        <s:input type="text" id="name" path="name"/>
        <s:errors path="name"/>

        <label for="password">Password</label>
        <s:input type="password" id="password" path="password"/>
        <s:errors path="password"/>

        <input type="submit">
    </s:form>
</body>
</html>
