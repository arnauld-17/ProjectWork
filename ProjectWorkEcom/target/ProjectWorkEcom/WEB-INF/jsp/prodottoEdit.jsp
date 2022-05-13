<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Edit Product Form</title>
<style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
</head>
<body>

<div id="global">
<form:form modelAttribute="prodotto" action="prodotto_update" method="post">
    <fieldset>
        <legend>Edit product</legend>
        <p class="errorLine">
            <form:errors path="codice" cssClass="error"/>
        </p>
        <p>
            <label for="codice">codice: </label>
            <form:input id="codice" path="codice" tabindex="1"/>
        </p>
        <p>
            <label for="descrizione">Descrizione: </label>
            <form:input id="descrizione" path="descrizione" tabindex="2"/>
        </p>
        <p class="errorLine">
            <form:errors path="prezzo" cssClass="error"/>
        </p>
        <p>
            <label for="prezzo">prezzo: </label>
            <form:input id="prezzo" path="prezzo" tabindex="3"/>
           
        </p>
            <p class="errorLine">
            <form:errors path="iva" cssClass="error"/>
        </p>
        <p>
            <label for="iva">iva: </label>
            <form:input id="iva" path="iva" tabindex="4"/>
        </p>
        <p>
            <label for="speseTrasporto">Spese Trasporto: </label>
            <form:input id="speseTrasporto" path="speseTrasporto" tabindex="5"/>
        </p>
        <p id="buttons">
            <input id="reset" type="reset" tabindex="6">
            <input id="submit" type="submit" tabindex="7" 
                value="Update Product">
        </p>
         <p class="errorLine">
            <form:errors cssClass="error"/>
        </p>
    </fieldset>
</form:form>
<p>  <a href="administratorMenu.action"> Menu</a>
</div>
</body>
</html>
