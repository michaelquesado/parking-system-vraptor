<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>${title}</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Michael Quesado">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assets/css/bootstrap.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/assets/js/jquery.mim.2.1.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/assets/js/dropdown.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/assets/js/transition.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/assets/js/modal.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/assets/js/collapse.js"></script>
</head>
<body>
	<!-- NAV -->

	<nav class="navbar navbar-default navbar-inverse navbar-fixed-top"
		role="navigation">
		<div class="navbar-inner">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".nav-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>

					<a class="navbar-brand" href="${linkTo[IndexController].index}">Parking
						System</a>
				</div>
				<div class="nav-collapse navbar-collapse">
					<ul class="nav navbar-nav ">
						<li class="active"><a href="#">Home</a></li>
						<li><a href="#">Contact</a></li>
						<li><a href="#">About</a></li>
					</ul>
					
					<c:if test="${user.name ne null }">
						<ul class="nav navbar-nav navbar-right">
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="#" aria-expanded="true">
									${user.name }<b class="caret"></b>
							</a>
								<ul class="dropdown-menu">
									<li><a href="${linkTo[LoginController].logout}">Logout</a></li>
									<c:if test="${user.level == 'MANAGER' }">
										<li><a href="${linkTo[UserController].userForm}">New
												User</a></li>
										<li><a href="${linkTo[UserController].listUsers}">All
												Users</a></li>
									</c:if>
								</ul></li>
						</ul>
					</c:if>

				</div>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="row " id="message-system">
			<div class="col-md-6 col-md-offset-3">
			
				<c:set var="alert_type" value=""></c:set>
				<c:set var="message" value=""></c:set>
				
				<c:forEach var="error" items="${errors}">
					<c:set var="message" value="${error.message}"></c:set>
					<c:set var="alert_type" value="${error.category}"></c:set>
					
				</c:forEach>
				
				<c:if test="${message ne null}">
						<div class="alert alert-${alert_type}" role="alert">
							${message}
						</div>
				</c:if>
			</div>
		</div>