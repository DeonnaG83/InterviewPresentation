<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html lang = "en">
  <head>
    <title>Retrieve Quote</title>
    <meta charset = "UTF-8" />
    <style type = "text/css">
    table
    {
      border: 4px solid black;border-color: "black";
      border-collapse: collapse;
      margin: 10px;
    } 
    th 
    {
    	border: 4px solid black;border-color: "black";
  		padding: 5px;
  		border-collapse: collapse;
	}
	td 
    {
    	border: 2px solid black;border-color: "black";
  		border-collapse: collapse;
	}
    
    </style>
  </head>
  <body>
    <p>	<%@ include file="header1.html" %></p>
    <H2 align="center"><font color = "maroon">Quotes Retrieved</font></H2>
    
   	<p style="text-align:center;"><%@ include file="Navigation.html" %>
   	
   	
   	 
     <%@ page import="java.util.ArrayList"%>
     <c:forEach items="${currentLocations}" var="currentLocation">
      <table style="width:40%">
        	
      <tr>
        <th><font color = "red" size = "5">Location Detail</font></th>
        <th><font color = "red" size = "5">Value</font></th>
      </tr>
      
      <tr>
      <td>Quote ID</td>
      <td><mark><i>${currentQuote.quoteId}</i></mark></td>
      </tr>
      
      <tr>
        <td>Residence Type</td>
        <td><mark><i>${currentLocation.residenceType}</i></mark></td>
      </tr>
      
      <tr>
        <td>Address Line 1</td>
        <td><mark><i>${currentLocation.addressLine1}</i></mark></td>
      </tr>
      
      <tr>
        <td>Address Line 2</td>
        <td><mark><i>${currentLocation.addressLine2}</i></mark></td>
      </tr>
      
      <tr>
        <td>City</td>
        <td><mark><i>${currentLocation.city}</i></mark></td>
      </tr>
      
      <tr>
        <td>State</td>
        <td><mark><i>${currentLocation.locationState}</i></mark></td>
      </tr>
      
      <tr>
        <td>Zip</td>
        <td><mark><i>${currentLocation.zipCode}</i></mark></td>
      </tr>
      
      <tr>
        <td>Residence Use</td>
        <td><mark><i>${currentLocation.residenceUse}</i></mark></td>
      </tr>
      
      <tr>
      <td>
      <form action="${pageContext.request.contextPath}/getQuoteDetails"  method="post">
      	<p style ="text-align:center;">
		<input type="submit" value="Additional Info"/></p>
	</form>
      </td>
      <td><b>Get Additional details for this Quote</b></td>
      </tr>
      
      </table>
      
      </c:forEach>
      
    
   
  </body>
</html>