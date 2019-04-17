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
<H2 align="center"><font color = "maroon">Coverage Details</font></H2>

<p style="text-align:center;"><%@ include file="Navigation.html" %></p>
		
		<form action="${pageContext.request.contextPath}/showQuoteSummaryPage"  method="post">
		
		
		<div>
		 	 <p style ="text-align:center;">
			 <span><b><label>Quote ID:</label>
			 <c:out value="${currentQuote.quoteId}"/></b></span> 
		</div>
		
		<p style ="text-align:center;"><span><b>Monthly Premium:
         <fmt:setLocale value = "en_US"/>
         <fmt:formatNumber value = "${currentQuote.monthlyPremium}" type = "currency"/></b></span>
     	 </p>
		
		<p style ="text-align:center;"><span><b>Dwelling Coverage:
         <fmt:setLocale value = "en_US"/>
         <fmt:formatNumber value = "${currentQuote.dwellingCoverage}" type = "currency"/></b></span>
     	 </p>
		
		<p style ="text-align:center;"><span><b>Detached Structures:
         <fmt:setLocale value = "en_US"/>
         <fmt:formatNumber value = "${currentQuote.detachedStructures}" type = "currency"/></b></span>
     	 </p>
		
		 <p style ="text-align:center;"><span><b>Personal Property:
         <fmt:setLocale value = "en_US"/>
         <fmt:formatNumber value = "${currentQuote.personalProperty}" type = "currency"/></b></span>
     	 </p>
		
		 <p style ="text-align:center;"><span><b>Additional Living Expenses:
         <fmt:setLocale value = "en_US"/>
         <fmt:formatNumber value = "${currentQuote.addLivingExp}" type = "currency"/></b></span>
     	 </p>
     	 
     	 <p style ="text-align:center;"><span><b>Medical Expenses:
         <fmt:setLocale value = "en_US"/>
         <fmt:formatNumber value = "${currentQuote.medicalExpenses} " type = "currency"/></b></span>
     	 </p>
     	 
     	 <p style ="text-align:center;"><span><b>Deductible:
         <fmt:setLocale value = "en_US"/>
         <fmt:formatNumber value = "${currentQuote.deductable}  " type = "currency"/></b></span>
     	 </p>
		
		
		<p style ="text-align:center;"><a href="${pageContext.request.contextPath}/showAdditionalInfoPage">Additional Info</a></p>
		<div>
			<p style ="text-align:center;">
			<input type="submit" value="Proceed To Buy"/></p>
		</div>

</form>
</head>
<body>

</body>
</html>