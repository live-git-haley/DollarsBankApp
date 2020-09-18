<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dollars Bank</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
	
<link rel="stylesheet" type="text/css" href="styles.css"/>
<link href='https://fonts.googleapis.com/css?family=Arbutus Slab' rel='stylesheet'>
<style>
body {
    font-family: 'Arbutus Slab';font-size: 22px;
    text-align: center;
}
</style>

</head>
<body >
<h1> $$$ Welcome to Dollar's Bank $$$</h1>
<div class = "home" >
<form action="/DollarsBankWebApp/Login">
  <div class="form-group">
    <label for="email">Email address:</label>
    <input type="email" class="form-control" id="email" name = "email">
  </div>
  <div class="form-group">
    <label for="pwd">Password:</label>
    <input type="password" class="form-control" id="pwd" name = "pwd">
  </div>

  <button type="submit" class="btn btn-success">Submit</button>
</form>
<br>
<form action = "CreateAccount.jsp">
	  <button type="submit" class="btn btn-light">Create New Account</button>
	

</form>
</div>
</body>
</html>