<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dollars Bank</title>
</head>
<body>
<h1> $$$ Welcome to Dollar's Bank $$$</h1>

<form action="/DollarsBankWebApp/Login">
  <div class="form-group">
    <label for="email">Email address:</label>
    <input type="email" class="form-control" id="email" name = "email">
  </div>
  <div class="form-group">
    <label for="pwd">Password:</label>
    <input type="password" class="form-control" id="pwd" name = "pwd">
  </div>

  <button type="submit" class="btn btn-default">Submit</button>
</form>

</body>
</html>