<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>

    <s:form action="/user/registration" method="post" modelAttribute="newUser">

        <label for="name">Name</label>
        <s:input type="text" id="name" path="name"/>
        <s:errors path="name"/>
        <br><br>

        <label for="birthday">Birthday</label>
        <s:input type="date" id="birthday" path="birthday"/>
        <s:errors path="birthday"/>
        <br><br>

        <label for="email">Email</label>
        <s:input type="email" id="email" path="email"/>
        <s:errors path="email"/>
        <br><br>

        <label for="password">Password</label>
        <s:input type="password" id="password" path="password"/>
        <s:errors path="password"/>
        <br><br>

        <input type="submit">

    </s:form>

</body>
</html>
