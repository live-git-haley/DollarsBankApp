<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logged in</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="styles.css" />
<link href='https://fonts.googleapis.com/css?family=Arbutus Slab' rel='stylesheet'>
<style>
body {
    font-family: 'Arbutus Slab';font-size: 22px;
    text-align: center;
}
</style>
</head>
<body>

	<%
		String name = (String) session.getAttribute("name");
	%>
	<h1>
		Welcome to Dollar's Bank,
		<%
		out.print(name);
	%>
	</h1>

	<h2>Deposit</h2>

	<form action="/DollarsBankWebApp/Transaction">
		<div class="form-group">
			<label for="email">Please enter amount to deposit:</label> <input
				type="text" class="form-control" name="amount"> <input
				type="hidden" class="form-control" name="action" value="deposit">
		</div>
		<input type="radio" id="checkings" name="accountType" value="checking">
		<label for="checkings">Checkings</label><br>
		<input type="radio" id="savings" name="accountType" value="saving">
		<label for="savings">Savings</label><br>

		<button type="submit" class="btn btn-success">Submit</button>
	</form>




	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>

</body>
</html>