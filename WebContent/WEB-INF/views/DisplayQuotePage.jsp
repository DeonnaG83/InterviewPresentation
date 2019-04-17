<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html lang = "en">
  <head>
    <title>Retrieve Quote</title>
    <meta charset = "UTF-8" />
    <style type = "text/css">
    table, td, th {
      border: 1px solid black;
    } 
    </style>
  </head>
  <body>
    <h1>Home Insurance</h1>
    <h2>Quote Id: ${currentQuote.quoteId}</h2>
    <table>
      
      <tr>
        <th>Coverage Details</th>
        <th>Amount</th>
      </tr>
      
      <tr>
        <td>Monthly Premium</td>
        <td>${currentQuote.monthlyPremium}</td>
      </tr>
      
      <tr>
        <td>Dwelling Coverage</td>
        <td>${currentQuote.dwellingCoverage}</td>
      </tr>
      
      <tr>
        <td>Detached Structures</td>
        <td>${currentQuote.detachedStructures}</td>
      </tr>
      
      <tr>
        <td>Personal Property</td>
        <td>${currentQuote.personalProperty}</td>
      </tr>
      
      <tr>
        <td>Additional Living Expenses</td>
        <td>${currentQuote.addLivingExp}</td>
      </tr>
      
      <tr>
        <td>Medical Expenses</td>
        <td>${currentQuote.medicalExpenses}</td>
      </tr>
      
      <tr>
        <td>Detuctible</td>
        <td>${currentQuote.deductable}</td>
      </tr>
      
    </table>
  </body>
</html>