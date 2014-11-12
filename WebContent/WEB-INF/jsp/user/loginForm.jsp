<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="{$linkTo[UserController].loginForm}" method="post">
		<input type="text" name="User.userName"  placeholder="Informe seu Login" />
		<br>
		<input type="password" name="User.password" placeholder="Inform sua Senha" />
		<input type="submit" value="Entrar" />
	</form>
=======
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

>>>>>>> f8dea5f998e0ff3e2f182f6ba317d8ab3e92595c
</body>
</html>