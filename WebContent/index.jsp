<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Car Dealership Home</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="./styles/styles.css">
</head>
<body>
	<div id="signInDiv">
		<h1>Sign In</h1>
		<form action="LoginServlet" method="post">
			<label for="userName">Username<span class="required" style="color:red;font-size:18px;margin-left:4px">*</span></label>
			<input type="text" name="userName" id="userName">
			<br>
			<label for="password">Password<span class="required" style="color:red;font-size:18px;margin-left:4px">*</span></label>
			<input type="password" name="password" id="password">
			<br>
			<button type="submit" class="btn btn-outline-secondary aquaHover">Submit</button>
		</form>
	</div>
</body>
</html>