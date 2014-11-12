<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formulario de Login</title>
</head>
<body>
	<form action="{$linkTo[UserController].loginForm}" method="post">
		<input type="text" name="User.userName" placeholder="Informe seu Login" />
		 <br> 
		 <input type="password" name="User.password" placeholder="Inform sua Senha" />
		 <br /> 
		 <input type="submit" value="Entrar" />
	</form>