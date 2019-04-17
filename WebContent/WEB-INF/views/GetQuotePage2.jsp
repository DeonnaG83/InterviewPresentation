<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Homeowner Information</title>
<style>
	body 
	{
	  color: black;
	}
</style>

</head>

	
<body BGCOLOR= AliceBlue> 
<H1 align="center"> Homeowner Insurance </H1>
<H2 align="center"><font color = "maroon"> Homeowner Information </font></H2>

<p style="text-align:center;"><%@ include file="Navigation.html" %></p>
		
		<form action="${pageContext.request.contextPath}/registerHomeowner"  method="post">
		
		<div>
			 <p style ="text-align:center;">
			<label>First Name:</label><span class = "asterix"><font color = "red">*</font></span>
			<input type="text" name="firstName" /></p>
		</div>
		
		<div>
			<p style ="text-align:center;">
			<label>Last Name</label><span class = "asterix"><font color = "red">*</font></span>
			<input type="text" name="lastName" /></p>
		</div>
		
		<div>
			<p style ="text-align:center;">
			<label>Date of Birth:</label><span class = "asterix"><font color = "red">*</font></span>
			<input type="text" name="dob" id= "dob" placeholder="YYYY-MM-DD"/></p>
		</div>
		
		<div>
			<p style ="text-align:center;">
			<label>Are you Retired?</label><span class = "asterix"><font color = "red">*</font></span>
			Yes<input type="radio" name="retiredStatus" value="true"/>
			No<input type="radio" name="retiredStatus" value="false"checked /></p>
		</div>
		
		<div>
			<p style ="text-align:center;">
			<label>Social Security Number:</label><span class = "asterix"><font color = "red">*</font></span>
			<input type="text" name="ssn" placeholder= "enter 9 digits for SSN"/></p>
		</div>
		
		<div>
			<p style ="text-align:center;">
			<label>Email address:</label><span class = "asterix"><font color = "red">*</font></span>
			<input type="text" name="email" /></p>
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