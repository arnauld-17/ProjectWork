<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Product List</title>
<style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
</head>
<body>
<div id="global">

<h1>Product List</h1>
<table>
<tr>
    <th>Codice</th>
    <th>Descrizione</th>
    <th>Prezzo</th>
    <th>Iva</th>
   <th>SpeseTrasporto</th>
   

</tr>
<c:forEach  var="prodotto" items="${prodotto}">
    <tr>
        <td>${prodotto.codice}</td>
        <td>${prodotto.descrizione}</td>
        <td>${prodotto.prezzo}</td>
        <td>${prodotto.iva}</td>
        <td>${prodotto.speseTrasporto}</td>
        <td><a href="carrello?codice=${prodotto.codice}">addcarrello</a></td>
        
      
    </tr>
</c:forEach>
</table>
 <p>  <a href="findProduct">cerca prodotto</a>
<p>  <a href="clientMenu"> Menu</a>

</div>
</body>
</html>
