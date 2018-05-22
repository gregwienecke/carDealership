<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Details</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="styles/styles.css">
</head>
<body>
	 <nav class="navbar navbar-dark bg-dark">
		<a href="home.jsp">Home</a>
		<a href="newCars.jsp">New Cars</a>
		<a href="usedCars.jsp">Used Cars</a>
		<c:if test="${admin eq true}">
			<a href="admin.jsp">Admin</a>
		</c:if>
		<form class="form-inline" action="SearchServlet" method="post">
			<input class="form-control mr-sm-2 col-sm-0" name="modelSearch" type="search" placeholder="Search" aria-label="Search">
    		<button class="btn btn-outline-info my-2 my-sm-0" type="submit">Search</button>
    	</form>
	</nav>
	
	<div class="jumbotron text-center">
		<h1>Details</h1>
	</div>
	
	<div class="row">
		<div class="col-md-4" style="padding:80px 0 0 30px">
		 	<h1>
		 		<span style="color:#666;font-size:80px"><c:out value="${carDetails.year}"/></span><br>
		 		<span style="font-weight:bold"><c:out value="${carDetails.make}"/></span>
		 		<span style="font-weight:lighter"><c:out value="${carDetails.model}"/></span>
		 	</h1>	
		 	<h4 style="color:aquamarine;background-color:#333;display:inline;padding:5px 15px 5px 15px">
		 	 	$<c:out value="${carDetails.price}"/>
		 	</h4>
		 	<br>
		 	<div id="carInfo">
			 	<table>
			 		<tr>
			 			<td>
			 				<p class="infoHeader">Mileage</p>
			 			</td>
			 			<td>
			 				<p><c:out value="${carDetails.mileage}"/></p>
			 			</td>
			 		</tr>
			 		<tr>
			 			<td>
			 				<p class="infoHeader">MPG</p>
			 			</td>
			 			<td>
			 				<p><c:out value="${carDetails.mpg}"/></p>
			 			</td>
			 		</tr>
			 		<tr>
			 			<td>
			 				<p class="infoHeader">Engine</p>
			 			</td>
			 			<td>
			 				<p><c:out value="${carDetails.engine}"/></p>
			 			</td>
			 		</tr>
			 		<tr>
			 			<td>
			 				<p class="infoHeader">Transmission</p>
			 			</td>
			 			<td>
			 				<p><c:out value="${carDetails.transmission}"/></p>
			 			</td>
			 		</tr>
			 	</table>
		 	</div> 
		 	
		 	<br>
		 	<a href="CheckoutServlet?carId=${carDetails.carId}">
		 		<button class="btn btn-dark aquaHover" id="checkoutButton">Checkout</button>
		 	</a>		
		</div>
		<div class="col-md-8">
			<img src="${carDetails.photo}" style="width:675px;height:550px"><br>
		</div>
	</div>

 	
	<hr>
	<footer>
		<p>&copy Company, Inc. 2018</p>
	</footer>
</body>
</html>