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
	<link href='https://fonts.googleapis.com/css?family=Arbutus Slab' rel='stylesheet'>
<link rel="stylesheet" type="text/css" href="styles.css" />
<link href='https://fonts.googleapis.com/css?family=Arbutus Slab' rel='stylesheet'>
<style>
body {
    font-family: 'Arbutus Slab';font-size: 22px;
  
}

.buttons{
	width: 100%;
}

h1{
	text-align: center;
}

h4{
	color: blue;
}
</style>
</head>
<body>

	<%
		String name = (String) session.getAttribute("name");
		String currentSavings =(String) session.getAttribute("currentSavings");
		String currentChecking =(String) session.getAttribute("currentChecking");

		
	%>
	<h1>
		Welcome to Dollar's Bank,
		<%
		out.print(name);
	%>
	</h1>
	<br>
	<h2>You currently have $<%out.print(currentChecking); %> in your Checking account</h2>
	<br>
	<h2>You currently have $<%out.print(currentSavings); %> in your Savings account</h2>

	Please select an option:

	<div class = "buttons">

	<form action="/DollarsBankWebApp/TransactionInfo">
		<button type="submit" name="history" class="btn btn-success">View
			History</button>
	</form>
	<form action="DepositPage.jsp">
		<button type="submit" name="deposit" class="btn btn-success">Make
			Deposit</button>
	</form>
	<form action="WithdrawPage.jsp">
		<button type="submit" name="withdraw" class="btn btn-success">Withdraw</button>
	</form>
	<form action="/DollarsBankWebApp/Info">
		<button type="submit" name="info" class="btn btn-success">Account
			Details</button>
	</form>
	<form action="TransferPage.jsp">
		<button type="submit" name="transfer" class="btn btn-success">Transfer
			Funds</button>
	</form>
	
	<br>
	<br>
	<br>
	<form action="index.jsp">
		<button type="submit" name="transfer" class="btn btn-primary">Logout</button>
	</form>




	</form>
	</div>

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