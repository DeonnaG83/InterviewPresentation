<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Property Information</title>
<style>
	body 
	{
	  color: black;
	}
</style>

</head>

	
<body BGCOLOR= AliceBlue> 
<H1 align="center"> Homeowner Insurance </H1>
<H2 align="center"><font color = "maroon">Property Information </font></H2>

<p style="text-align:center;"><%@ include file="Navigation.html" %></p>
		
		<form action="${pageContext.request.contextPath}/registerProperty"  method="post">
		
		<div>
			 <p style ="text-align:center;">
			<label>Market value of Property</label>       
			<span class = "asterix"><font color = "red">*</font></span>$<input type="number" min ="0" step = "any" name="marketValue" placeholder = "99999.99"/></p>
		</div>
		

		<div>
			<p style ="text-align:center;">
			<label>Year Property was built</label>
			<span class = "asterix"><font color = "red">*</font></span><input type="number" max= "2019" step= "1" name="yearBuilt" placeholder = "2019"/></p>
		</div>
		
		<div>
			<p style ="text-align:center;">
			<label>Square Footage</label><span class = "asterix"><font color = "red">*</font></span>
			<input type="number" min= "0" step = "1" name="squareFootage" placeholder = "3500"/>square feet</p>
			
		</div>
		
		<div>
			<p style ="text-align:center;">
			<label>Dwelling Type</label><span class = "asterix"><font color = "red">*</font></span>
			 <select name = "dwellingType">
			 <option  value = "1 Story">1 Story</option>
			<option  value = "1.5 Story">1.5 Story</option>
			<option  value = "2 Story">2 Story</option>
			<option  value = "2.5 Story">2.5 Story</option>
			<option value = "3 Story">3 Story</option>
			</select></p>
		</div>
		
		<div>
			<p style ="text-align:center;">
			<label>Roofing Material</label><span class = "asterix"><font color = "red">*</font></span>
			 <select name = "roofingMaterial">
			 <option value = "Concrete">Concrete</option>
			<option value = "Clay">Clay</option>
			<option value = "Rubber">Rubber</option>
			<option value = "Steel">Steel</option>
			<option value = "Tin">Tin</option>
			<option value = "Wood">Wood</option>
			</select></p>
		</div>
		
		<div>
			<p style ="text-align:center;">
			<label>Type of Garage</label><span class = "asterix"><font color = "red">*</font></span>
			 <select name = "garageType">
			 <option value = "Attached">Attached</option>
			<option value = "Detached">Detached</option>
			<option value = "Basement">Basement</option>
			<option value = "Built-In">Built-In</option>
			<option value = "None">None</option>
			</select></p>
		</div>
		
		<div>
			<p style ="text-align:center;">
			<label>Number of Full-Baths</label><span class = "asterix"><font color = "red">*</font></span>
			 <select name = "fullBaths">
			 <option value = "1">1</option>
			<option value = "2">2</option>
			<option value = "3">3</option>
			<option value = "4">4 or more</option>
			</select></p>
		</div>
		
		<div>
			<p style ="text-align:center;">
			<label>Number of Half-Baths</label><span class = "asterix"><font color = "red">*</font></span>
			 <select name = "halfBaths">
			 <option value = "1">1</option>
			<option value = "2">2</option>
			<option value = "3">3</option>
			<option value = "4">4 or more</option>
			</select></p>
		</div>
		
		<div>
			<p style ="text-align:center;">
			<label>Swimming Pool</label><span class = "asterix"><font color = "red">*</font></span>
			Yes<input type="radio" name="pool" value="true"/>
			No<input type="radio" name="pool" value="false"checked /></p>
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
</head>
<body>

</body>
</html>