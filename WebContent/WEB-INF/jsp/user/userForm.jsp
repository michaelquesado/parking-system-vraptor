<%@include file="../header.jsp"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-md-7 col-md-offset-2 well">
		<form class="form-horizontal" role="form"
			action="${linkTo[UserController].add }" method="post">
			<div class="form-group">
				<div class="col-md-6">
					<label for="inputuserName" class="col-sm-2 control-label">UserName</label>
					<input type="text" class="form-control" id="inputuserName"
						name="user.userName" placeholder="User Name">
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-6">
					<label for="inputName" class="col-sm-2 control-label">Name</label>
					<input type="text" class="form-control" id="inputName"
						name="user.name" placeholder="Name">
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-6">
					<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
					<input type="password" class="form-control" id="inputPassword1"
						name="user.password" placeholder="Password">
				</div>
				<div class="col-md-6">
					<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
					<input type="password" class="form-control" id="inputPassword2"
						placeholder="Password">
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-md-6">
					<c:if test="${user.level == 'MANAGER'}">
						<select class="form-control" name="user.level">
							<option>Select type</option>
							<c:forEach items="${levels}" var="l">
								<option value="${l}">${l.level}</option>
							</c:forEach>
						</select>
					</c:if>
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-2 col-sm-offset-10">
					<button type="submit" class="btn btn-default btn-lg btn-block">Save</button>
				</div>
			</div>
		</form>
	</div>
</div>



<%@include file="../footer.jsp"%>