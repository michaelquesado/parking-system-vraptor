<%@include file="../header.jsp"%>
<div id="form">
	<div class="row">
		<div class="col-md-5 col-md-offset-3">
			<h2 class="">Please sign in.</h2>
		</div>
	</div>
	<div class="row">
		<div class="col-md-5 col-md-offset-3 well">
			<form class="form-signin" role="form"
				action="${linkTo[UserController].loginUser}" method="post">
				<div class="form-group">
					<label for="inputuserName" class="col-sm-2 control-label">UserName</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputuserName"
							name="user.userName" placeholder="User Name">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="inputPassword3"
							name="user.password" placeholder="Password">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default btn-lg btn-block">Sign
							in</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<%@include file="../footer.jsp"%>

