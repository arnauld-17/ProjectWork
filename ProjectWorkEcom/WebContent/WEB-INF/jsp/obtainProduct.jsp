<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
    <th>Codice</th>
    <th>Descrizione</th>
    <th>Prezzo</th>
    <th>Iva</th>
   <th>SpeseTrasporto</th>

</tr>
<c:forEach  var="prodotto" items="${codice}">
    <tr>
    <tr>
        <td>${prod.codice}</td>
        <td>${prod.descrizione}</td>
        <td>${prod.prezzo}</td>
        <td>${prod.iva}</td>
        <td>${prod.speseTrasporto}</td>
        
    </tr>
</c:forEach>
</table>
</body>
</html>