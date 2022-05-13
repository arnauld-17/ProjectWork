<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Login</title>
<style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
</head>
<body>

<div id="global">
<form:form modelAttribute="user" action="user_check" method="post">
    <fieldset>
       <legend>Benvenuto</legend>
         <p class="errorLine">
            <form:errors cssClass="error"/>
        </p>
        		<p>
					<label for="username">Inserisci username:</label>
					<input type="text" name="username" th:field="*{username}"><br/>
					
				</p>
				<p>
					<label for="password">Inserisci password:</label>
					<input type="password" name="password" th:field="*{password}"><br/>
					
				</p>
				<p id="buttons">
					<input id="reset" type="reset" value="reset">
					<input id="submit" type="submit" value="Login">
				</p>
        
    </fieldset>
</form:form>
</div>
</body>
</html>