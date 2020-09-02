<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page  isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<link
	href="https://fonts.googleapis.com/css2?family=Mulish:ital,wght@0,300;0,600;0,618;0,680;0,793;1,577&display=swap"
	rel="stylesheet" />
<link href="<c:url value="/resources/css/login.css"/>" rel="stylesheet">

</head>

<body style="background-color: orange;">

	<div class="container">

		<form action="loginForm" method="post">
			<div class="form-group">
				<h4 id="signIn">Sign In</h4>
			</div>

			<div class="form-group">
				<input name="name" type="text" placeholder="Username"
					class="form-control" />
			</div>

			<div class="form-group">
				<input name="password" type="text" placeholder="Password"
					class="form-control" />
			</div>

			<div id="checkbox" class="form-group">
				<label><input name="userRemember" type="checkbox" /><span></span>
					Remember Me</label>
				<h6 id="forgotPassword">Forgot pwd?</h6>
			</div>

			<div class="form-group">
				<button class="btn btn-primary btn-block btn-lg">LOG IN</button>
			</div>
			<br />
			<div id="showButtons" class="form-group">
				<button class="btn btn-primary active"></button>
				<button class="btn btn-danger active"></button>
			</div>
			<br />
			<div class="form-group">
				<h6 id="account">
					Don't have an account?<a href="registration"><span id="signUp">Sign
							Up</span></a>
				</h6>
			</div>
		</form>
	</div>
</body>
</html>
