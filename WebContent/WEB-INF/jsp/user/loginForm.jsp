<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="<c:url value="/login"/>" method="post">
		<fieldset>
			<legend>Efetue o login</legend>

			<label for="login">Login:</label> <input id="login" type="text"
				name="usuario.login" /> <label for="senha">Senha:</label> <input
				id="senha" type="password" name="usuario.senha" />

			<button type="submit">Login</button>
		</fieldset>
	</form>

</body>
</html>