<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Coverage Details</title>
<style>
	body 
	{
	  color: black;
	}
</style>

</head>

	
<body BGCOLOR= AliceBlue> 
<H1 align="center"> Homeowner Insurance </H1>
<H2 align="center"><font color = "maroon">Buy Policy</font></H2>

<p style="text-align:center;"><%@ include file="Navigation.html" %></p>
		
		<form action="${pageContext.request.contextPath}/registerPolicy"  method="post">
		
		
		<div>
		 	 <p style ="text-align:center;">
			 <span><b><label>Quote ID:</label>
			 <c:out value="${currentQuote.quoteId}"/></b></span> 
		</div>
			
		<div>
		 	 <p style ="text-align:center;">
			 <span><b><label><font color = "red">Note:</font></label>Policy start date can not be more than 60 Days from today's date
			 </b></span> 
		</div>
		
		<div>
		<p style ="text-align:center;">
			<label>Enter Policy Start Date:</label>
			<input type="text" name="startDate" id="startDate" placeholder ="YYYY-MM-DD"/></p>
		</div>
		
		<p style ="text-align:center;"><a href="${pageContext.request.contextPath}/showTermsAndConditionsPage">Please click and read terms
		and conditions before buying policy</a></p>

		<div>
		<p style ="text-align:center;">
			<input type="checkbox" required name="terms"/>This is to acknowledge that I have read the terms and the conditions of the policy</p>
		</div>
		
		<div>
			<p style ="text-align:center;">
			<input type="submit" value="Submit"/></p>
		</div>
</form>

<p style ="text-align:center;"><span class = "asterix"><font color = "red">*</font></span><label>All Fields Required</label></p>	
<%@ include file="footer.html" %>
<%@ page import="java.util.ArrayList"%>
 <c:forEach items="${errorList}" var="error"> 
	    <p style="color: red;">${error}</p>
	</c:forEach>
</body>
</html>