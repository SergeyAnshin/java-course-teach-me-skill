<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
  <form action="/user/registration" method="post">
      <label for="name">Name</label>
      <input type="text" id="name" name="name">
      <p>${name}</p>
      <label for="password">Password</label>
      <input type="password" id="password" name="password">
      <p>${password}</p>
      <input type="submit">
  </form>
</body>
</html>
