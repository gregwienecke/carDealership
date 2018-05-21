<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="./styles/styles.css">
</head>
<body>
 	<nav class="navbar navbar-dark bg-dark">
		<a href="home.jsp">Home</a>
	</nav>
	<div class="jumbotron text-center">
		<h1>St. Louis Auto Sales</h1>
		<h5 style="color:#888">Administration</h5>	
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-5">
				<h3 style="margin-top:30px">Add New Vehicle</h3>
				<form id="adminAddForm" action="AddCarServlet" method="post">
					<label for="year">Year</label>
					<input type="text" name="year" id="year">
					<br>
					
					<label for="make">Make</label>
					<input type="text" name="make" id="make">
					<br>
					
					<label for="model">Model</label>
					<input type="text" name="model" id="model">
					<br>
					
					<label for="price">Price</label>				
					<input type="text" name="price" id="price">
					<br>
					
					<label for="mileage">Mileage</label>
					<input type="text" name="mileage" id="mileage">
					<br>
					
					<label for="mpg">MPG</label>
					<input type="text" name="mpg" id="mpg">
					<br>
					
					<label for="engine">Engine</label>
					<input type="text" name="engine" id="engine">
					<br>
	
					<label for="transmission">Transmission</label>				
					<input type="text" name="transmission" id="transmission">
					<br>
	
					<label for="isNew">New Car (true/false)</label>				
					<input type="text" name="isNew" id="isNew">
					<br>
					
					<label for="photo">Image path</label>				
					<input type="text" name="photo" id="photo">
					<br>				
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
			
			<div class="col-md-7">
				<h3 style="margin-top:30px">Sales History Report</h3>
				<table class="table table-bordered table-striped table-hover table-dark">
					<thead>
						<th>Name</th>
						<th>Make</th>
						<th>Model</th>
						<th>Sale Date</th>
					</thead>
					<c:forEach var="transaction" items="${report}">
					
						<tr>
							<td>
								<c:out value="${transaction.firstName} "/>
								<c:out value="${transaction.lastName}"/>
							</td>
							<td>	
	 							<c:out value="${transaction.carSold.make}"/>
							</td>
							<td>	
								<c:out value="${transaction.carSold.model}"/>
							</td>
							<td>	
								<c:out value="${transaction.saleDate}"/>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			
		</div> <!-- End row --> 
	</div> <!-- End container -->
	<hr>
	<footer>
		<p>&copy Company, Inc. 2018</p>
	</footer>
</body>
</html>