<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>Registration</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.1/css/bootstrap.min.css"
	integrity="sha384-VCmXjywReHh4PwowAiWNagnWcLhlEJLA5buUprzK8rxFgeH0kww/aWY76TfkUoSX"
	crossorigin="anonymous" />
<link
	href="https://fonts.googleapis.com/css2?family=Mulish:ital,wght@0,300;0,600;0,618;0,680;0,793;1,577&display=swap"
	rel="stylesheet" />
<link href="<c:url value="/resources/css/registration.css"/>"
	rel="stylesheet">
</head>

<body>
     
	<div class="container">
		<form:form action="registrationForm" method="post" modelAttribute="user">
			<div class="form-group">
				<h4 id="signUp">Sign Up</h4>
			</div>

			<div class="form-group">
				<input name="name" placeholder="Name"
					class="form-control" />
				<form:errors path="name" cssClass="error"/>
			</div>

	 		<div class="form-group">
				<input name="email" type="text" placeholder="Email"
					class="form-control" />
				<form:errors path="email" cssClass="error"/>	
			</div>


			<div class="form-group">
				<input name="password" type="password" placeholder="Password"
					class="form-control" />
				<form:errors path="password" cssClass="error" />
			</div>

			<div class="form-group">
				<input name="confirmPassword" type="Password"
					placeholder="Confirm Password" class="form-control" />
				<form:errors path="confirmPassword" cssClass="error"/>
			</div>

			<div id="checkbox" class="form-group">
				<label><input name="agree" type="checkbox" value="true" /><span></span>
					I agree to all </label><span id="terms">Terms</span>
				<form:errors path="agree" cssClass="error"/>
			</div>

			<div class="form-group">
				<button class="btn btn-primary btn-block btn-lg">SIGN UP</button>
			</div>
			<div class="form-group">
				<h6 id="account">
					Already have an account?<a href="login"><span id="signIn">
							Sign In</span></a>
				</h6>
			</div> 
		</form:form>
	</div>
</body>
</html>
