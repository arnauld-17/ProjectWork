<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Save Product</title>
<style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
</head>
<body>
<div id="global">
    <h4>The product has been saved.</h4>
    <p>
        <h5>Details:</h5>
        Codice: ${prodotto.codice}<br/>
        Descrizione: ${prodotto.descrizione}<br/>
        Prezzo: $${prodotto.prezzo}<br/>
        Iva: ${prodotto.iva}<br/>
        SpeseTrasporto: ${prodotto.speseTrasporto}<br/>
        
    </p>
    <p>  <a href="administratorMenu">Menu</a>
</div>
</body>
</html>