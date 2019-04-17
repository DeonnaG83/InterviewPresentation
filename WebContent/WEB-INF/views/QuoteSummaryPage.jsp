<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
 
<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Quote Summary Page</title>
<H1 align="center"> Homeowner Insurance </H1>
<H2 align="center"><font color = "maroon">Quote Summary</font></H2>

<p style="text-align:center;"><%@ include file="Navigation.html" %></p>
		
		<form action="${pageContext.request.contextPath}/showBuyPolicyPage"  method="post">
		
		
		<p style ="text-align:center;"><span><b>Monthly Premium:
         <fmt:setLocale value = "en_US"/>
         <fmt:formatNumber value = "${currentQuote.monthlyPremium}" type = "currency"/></b></span>
     	 </p>
<style>
* {
  box-sizing: border-box;
}

/* Create four equal columns that floats next to each other */
.column {
  float: left;
  width: 25%;
  padding: 10px;
  height: 500px; /* Should be removed. Only for demonstration */
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}
</style>

</head>

	
<body BGCOLOR= AliceBlue> 


<h3 style ="text-align:center;"><font color = "red">Please Verify All Details Before Purchasing</font></h3>

<div class="row">
  <div class="column" style="background-color:#aaa;">
    <h2>Location Details</h2>
   	
   		 <div>
		 	 <p style ="text-align:center;">
			 <span><b><label>Location ID:</label>
			 <c:out value="${currentQuote.locationId}"/></b></span> 
		</div>
		
		<div>
		 	 <p style ="text-align:center;">
			 <span><b><label>Residence Type:</label>
			 <c:out value="${currentLocation.residenceType}"/></b></span> 
		</div>
		
		<div>
		 	 <p style ="text-align:center;">
			 <span><b><label>Address Line 1:</label>
			 <c:out value="${currentLocation.addressLine1}"/></b></span> 
		</div>
		
		 <div>
		 	 <p style ="text-align:center;">
			 <span><b><label>Address Line 2:</label>
			 <c:out value="${currentLocation.addressLine2}"/></b></span> 
		</div>
     	 
     	 <div>
		 	 <p style ="text-align:center;">
			 <span><b><label>City:</label>
			 <c:out value="${currentLocation.city}"/></b></span> 
		</div>
     	 
     	 <div>
		 	 <p style ="text-align:center;">
			 <span><b><label>State:</label>
			 <c:out value="${currentLocation.locationState}"/></b></span> 
		</div>
		
		<div>
		 	 <p style ="text-align:center;">
			 <span><b><label>Zip Code:</label>
			 <c:out value="${currentLocation.zipCode}"/></b></span> 
		</div>
		
		<div>
		 	 <p style ="text-align:center;">
			 <span><b><label>Residence Use:</label>
			 <c:out value="${currentLocation.residenceUse}"/></b></span> 
		</div>
		
</div>
  <div class="column" style="background-color:#bbb;">
    <h2>Homeowner Details</h2>
    
	<div>
		 	 <p style ="text-align:center;">
			 <span><b><label>First Name:</label>
			 <c:out value="${currentHomeowner.firstName}"/></b></span> 
		</div>
		
		<div>
		 	 <p style ="text-align:center;">
			 <span><b><label>Last Name:</label>
			 <c:out value="${currentHomeowner.lastName}"/></b></span> 
		</div>
		
		 <p style ="text-align:center;">
		<span><b><label>Date Of Birth:</label>
		<jsp:useBean id="dob" class="java.util.Date"/>
		<fmt:formatDate value="${dob}" type="date" pattern="yyyy-MM-dd"/></b></span> 
		
		<div>
		 	 <p style ="text-align:center;">
			 <span><b><label>SSN:</label>
			 <c:out value="${email}"/></b></span> 
		</div>
		
		
		
		
		
		
     	 
     	 
     	 
     	 
		
		
		
		
  </div>
  <div class="column" style="background-color:#ccc;">
    <h2>Property Details</h2>
    <div>
		 	 <p style ="text-align:center;"><span><b>Market Value:
         <fmt:setLocale value = "en_US"/>
         <fmt:formatNumber value = "${currentProperty.marketValue}" type = "currency"/></b></span>
     	 </p> 
		</div>
		
		<div>
		 	 <p style ="text-align:center;">
			 <span><b><label>Year Built:</label>
			 <c:out value="${currentProperty.yearBuilt}"/></b></span> 
		</div>
		
		<div>
		 	 <p style ="text-align:center;">
			 <span><b><label>Square Footage:</label>
			 <c:out value="${currentProperty.squareFootage}"/></b></span> 
		</div>
		
		 <div>
		 	 <p style ="text-align:center;">
			 <span><b><label>Dwelling Type:</label>
			 <c:out value="${currentProperty.dwellingType}"/></b></span> 
		</div>
     	 
     	 <div>
		 	 <p style ="text-align:center;">
			 <span><b><label>Roof Material:</label>
			 <c:out value="${currentProperty.roofMaterial}"/></b></span> 
		</div>
     	 
     	 <div>
		 	 <p style ="text-align:center;">
			 <span><b><label>Garage Type:</label>
			 <c:out value="${currentProperty.garageType}"/></b></span> 
		</div>
		
		<div>
		 	 <p style ="text-align:center;">
			 <span><b><label>Number Of Full Baths:</label>
			 <c:out value="${currentProperty.fullBaths}"/></b></span> 
		</div>
		
		<div>
		 	 <p style ="text-align:center;">
			 <span><b><label>Number Of Half Baths:</label>
			 <c:out value="${currentProperty.halfBaths}"/></b></span> 
		</div>
		
		<div>
		 	 <p style ="text-align:center;">
			 <span><b><label>Pool:</label>
			 </b></span> 
		</div>
  </div>
  
  
  <div class="column" style="background-color:#ddd;">
    <h2>Coverage Details</h2>
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
		
  </div>
</div>
		<div>
			<p style ="text-align:center;">
			<input type="submit" value="Buy Quote"/></p>
		</div>
<p style ="text-align:center;">	
<%@ include file="footer.html" %></p>
</body>
</html>

		
		