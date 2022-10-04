<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="./css/general.css">
		<link rel="stylesheet" type="text/css" href="./css/signup.css">
		<!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>-->
		<script src="./javascript/jquery-3.6.0.js"></script>
		<script src="./javascript/signup.js"></script>
        <title>Sign Up | StudyBud</title>
	</head>
	<body>
		<div id="content">
			<form action="${pageContext.request.contextPath}/signup" method="post">
				<div id="signup"><span>Sign Up</span><span>Lorem ipsum dolor sit amet consectetur adipisicing elit.</span></div>
				<script>
					$(document).ready(function() {
						function setContentTopPadding() {
							if($(window).width() <= 640) {
								$("#content").css("padding-top", "" + ($("#signup span:nth-of-type(2)").height() + 32) + "px");
							}
						}
						$(window).resize(setContentTopPadding);
						setContentTopPadding();
					})
				</script>
				<div id="name">
					<div id="first_name" class="container-input">
						<input type="text" name="first_name" placeholder="First name">
						<span class="error hidden">What's your first name?<span class="triangle"></span></span>
					</div>
					<div id="last_name" class="container-input">
						<input type="text" name="last_name" placeholder="Last name">
						<span class="error hidden">What's your last name?<span class="triangle"></span></span>
					</div>
				</div>
				<div id="email" class="container-input">
					<input type="email" name="email" placeholder="Email address">
					<span class="error hidden">Lorem ipsum dolor, sit amet consectetur adipisicing elit. Quis, voluptatem!</span>
				</div>
				<div id="password" class="container-input">
					<input type="password" name="password" placeholder="Password">
					<span class="error hidden">Lorem ipsum dolor sit amet consectetur, adipisicing elit.</span>
				</div>
				<div id="agreement">Lorem ipsum dolor sit amet consectetur adipisicing elit. Fuga nam dignissimos ut. Eum excepturi dolor velit voluptatum. Aspernatur, eos ex!</div>
				<input type="submit" value="Sign Up">				
			</form>
		</div>
	</body>
</html>