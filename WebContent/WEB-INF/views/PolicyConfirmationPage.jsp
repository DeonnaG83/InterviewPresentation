<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Policy Confirmation</title>
<style>
	body 
	{
	  color: black;
	}
</style>

</head>

	
<body BGCOLOR= AliceBlue> 
<H1 align="center"> Homeowner Insurance </H1>
<H2 align="center"><font color = "maroon">Policy Confirmation</font></H2>

<p style="text-align:center;"><%@ include file="Navigation.html" %></p>
		
		<form action="${pageContext.request.contextPath}/showWelcomePage"  method="post">
		
		<div>
		 	 <p style ="text-align:center;">
			 <span><b><label><font color = "red">Note:</font></label>You will be contacted by a customer service representative within 24 hours for payment authorization. 
			 </b></span> 
		</div>
		
		<div>
		 	 <p style ="text-align:center;">
			 <span><b><label>Quote ID:</label>
			 <c:out value="${currentPolicy.quoteId}"/></b></span></p>
		</div>
		
		<div>
			<p style ="text-align:center;">
			<span><b><label>Policy ID:</label>
        	<c:out value = "${currentPolicy.policyId}" /></b></span></p>
        </div>
        
        <div>
        	<p style ="text-align:center;">
			<span><b><label>Policy Effective Date:</label>
        	<c:out value = "${currentPolicy.effectiveDate}"/></b></span></p>
        </div>
     	 
     	 <div>
     	 	<p style ="text-align:center;">
			<span><b><label>Policy End Date:</label>
        	<c:out value = "${currentPolicy.endDate}" /></b></span>
     		</p>
     	</div>
     	
     	<div>
     		<p style ="text-align:center;">
		 	<span><b><label>Policy Term:</label>
         	<c:out value = "${currentPolicy.term} " />year(s)</b></span></p>
     	</div>
		
		<div>	
			<p style ="text-align:center;">
			<span><b><label>Policy Status:</label>
	        <c:out value = "${currentPolicy.policyStatus}"/></b></span>
	     	</p>
	    </div>
	    
	    <div>
		 	 <p style ="text-align:center;">
			 <span><i>Thank you for choosing Home Insurance! 
			 </i></span> 
		</div>
	     
	    <div>
			<p style ="text-align:center;">
			<input type="submit" value="Back To Home Page"/></p>
		</div>

</form>
</head>
<body>

</body>
</html>