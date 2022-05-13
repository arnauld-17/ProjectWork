<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>prodotto</title>
</head>
<body>
<div id="global">
<form:form modelAttribute="codice" action="obtainProduct" method="get">
<fieldset>
 <legend> find product</legend>
    <p>
           	<label for="codice">Codice prodotto:</label>
					<input type="text" name="codice" th:field="*{codice}"><br/>
        </p>
        <p id="buttons">
            <input id="reset" type="reset" tabindex="1">
            <input id="submit" type="submit" tabindex="2" 
                value="Add Product">
        </p>
       </fieldset>
    </form:form>
    </div>
</body>
</html>