<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Location</title>
<style>
	body 
	{
	  color: black;
	}
</style>

</head>

	
<body BGCOLOR= AliceBlue> 
<H1 align="center"> Homeowner Insurance </H1>
<H2 align="center"><font color = "maroon"> Location Information </font></H2>

<p style="text-align:center;"><%@ include file="Navigation.html" %></p>
		
		<form action="${pageContext.request.contextPath}/registerLocation"  method="post">
		<div><p style ="text-align:center;">
			<label>Residence Type</label><span class = "asterix"><font color = "red">*</font></span>
			 <select name = "residenceType">
			 
			<option value = "Single-Family Home" >Single-Family Home</option>
			<option value = "Condo">Condo</option>
			<option value = "Townhouse">Townhouse</option>
			<option value = "Rowhouse">Rowhouse</option>
			<option value = "Duplex">Duplex</option>
			</select> 
			</p>
		</div>
		
		<div>
			 <p style ="text-align:center;">
			<label>Address Line 1</label><span class = "asterix"><font color = "red">*</font></span>
			<input type="text" name="addressLine1" /></p>
		</div>
		
		<div>
			<p style ="text-align:center;">
			<label>Address Line 2</label>
			<input type="text" name="addressLine2" /></p>
		</div>
		
		<div>
			<p style ="text-align:center;">
			<label>City</label><span class = "asterix"><font color = "red">*</font></span>
			<input type="text" name="city" /></p>
		</div>
		
		<div>
			<p style ="text-align:center;">
			<label>State</label><span class = "asterix"><font color = "red">*</font></span>
			<input type="text" name="locationState" /></p>
		</div>
		
		<div>
			<p style ="text-align:center;">
			<label>Zipcode</label>
			<span class = "asterix"><font color = "red">*</font></span><input type="text" name="zipCode" /></p>
		</div>
		
		<div>
			<p style ="text-align:center;">
			<label>Residence Use</label><span class = "asterix"><font color = "red">*</font></span>
			 <select name = "residenceUse">
			<option value = "Primary">Primary</option>
			<option value = "Secondary">Secondary</option>
			<option value = "Rental Property">Rental Property</option>
			</select></p>
		</div>
		<div>
			<p style ="text-align:center;">
			<input type="submit" value="Continue"/></p>
		</div>

</form>
<%@ page import="java.util.ArrayList"%>
<c:forEach items="${errorList}" var="error"> 
	    <p style="color: red;">${error}</p>
	</c:forEach>
<p style ="text-align:center;"><span class = "asterix"><font color = "red">*</font></span><label>All Fields Required</label></p>	
<%@ include file="footer.html" %>
</body>	
</html>