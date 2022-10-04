<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="./css/general.css">
		<link rel="stylesheet" type="text/css" href="./css/index.css">
		<!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>-->
		<script src="./javascript/jquery-3.6.0.js"></script>
		<title>StudyBud</title>
	</head>
	<body>
		<div id="content">
			<div id="banner">
				<div id="banner_c1"><span>Lorem ipsum dolor sit amet consectetur. <a href="${pageContext.request.contextPath}/signup" style="text-decoration: underline;">Start</a></span></div>
				<div id="banner_c2">
					<span id="logo">StudyBud</span>
					<span>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Voluptatum, suscipit!</span>
					<a href="${pageContext.request.contextPath}/signup">Start Now</a>
				</div>
				<form action="${pageContext.request.contextPath}/login" method="post">
					<div>
						<%
							if(session.getAttribute("attemptedLogin?") == Boolean.valueOf(true)) {
						%>
								<div id="error"><span>Bad credentials</span><span style="cursor: pointer;">X</span></div>
								<script>
									$("#error span:nth-of-type(2)").on("click", function() {
										$("#error").hide();
									});
								</script>
						<%
								session.removeAttribute("attemptedLogin?");
							}
						%>
						<input type="text" name="username" placeholder="Username">
						<input type="password" name="password" placeholder="Password">
						<input type="submit" value="Login">
					</div>
					<span><a href="#">Forgotten password?</a></span>
				</form>
			</div>
		</div>
	</body>
</html>