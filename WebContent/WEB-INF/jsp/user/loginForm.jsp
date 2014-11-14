<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.modal-content {
	width: 500px;
	height: 350px; margin-left : 35%;
	margin-top: 15%;
	margin-left: 35%;
}

.modal-body {
	margin-left: 10px;
	margin-top: 5px;
}

.well {
	width: 480px;
	height: 310px;
}
#bt{
width: 100px;
}
</style>
<title>Formulario de Login</title>
</head>
<body>
	<div class="modal-content">
		<div class="modal-body">
			<div class="row">
				<div class="well">
					<form class="form-horizontal"
						action="${linkTo[UserController].loginUser}" method="post">
						<fieldset>
							<legend>Login no Sistema</legend>

							<div class="form-group">
								<label class="col-md-6 control-label" for="userName">Usuário:</label>
								<div class="col-md-6">
									<input id="userName" name="user.userName" type="text"
										placeholder="Digite seu usuário..."
										class="form-control input-md" required="">

								</div>
							</div>

							<div class="form-group">
								<label class="col-md-6 control-label" for="password">Senha:</label>
								<div class="col-md-6">
									<input id="password" name="user.password" type="password"
										placeholder="Digite sua senha..."
										class="form-control input-md" required="">

								</div>
							</div>

							<div class="form-group">
								<label class="col-md-6 control-label" for=""></label>
								<div class="col-md-6" align="center">
									<button id="bt" name="" class="btn btn-primary">Entrar</button>
								</div>
							</div>
							<legend></legend>
							<p>Todos os direitos reservados.</p>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
