<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Add Product Form</title>
<style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
</head>
<body>

<div id="global">
<form:form modelAttribute="prodotto" action="prodotto_save" method="post">
    <fieldset>
     
        <p>
           	<label for="codice">Codice prodotto:</label>
					<input type="text" name="codice" th:field="*{codice}"><br/>
        </p>
        <p>
        <label for="descrizione">Descrizione:</label>
		    <input type="text" name="descrizione" th:field="*{descrizione}"><br/>
        </p>
        
        <p>
            <label for="prezzo">Prezzo:</label>
					<input type="text" name="prezzo" th:field="*{prezzo}"><br/>
        </p>
        
        <p>
           <label for="iva">Iva:</label>
					<input type="text" name="iva" th:field="*{iva}"><br/>
        </p>
        <p>
        <label for="speseTrasporto">Spese Trasporto:</label>
				<input type="text" name="speseTrasporto" th:field="*{speseTrasporto}"><br/>
          
        </p>
        <p id="buttons">
            <input id="reset" type="reset" tabindex="6">
            <input id="submit" type="submit" tabindex="7" 
                value="Add Product">
        </p>
         <p class="errorLine">
            <form:errors cssClass="error"/>
        </p>
    </fieldset>
</form:form>
<p>  <a href="administratorMenu">Menu</a>

</body>
</html>
