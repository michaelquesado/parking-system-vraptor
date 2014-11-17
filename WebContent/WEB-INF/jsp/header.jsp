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
	src="${pageContext.request.contextPath}/assets/js/jquerygit2.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/assets/js/dropdown.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/assets/js/transition.js"></script>
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
						<c:choose>
							<c:when test="${user != null}">
								<ul class="nav navbar-nav navbar-right">
									<li class="dropdown"><a class="dropdown-toggle"
										data-toggle="dropdown" href="#" aria-expanded="true">
											Service <b class="caret"></b>
									</a>
										<ul class="dropdown-menu">
											<li><a href="#">Services</a></li>
											<li><a href="#">All Services</a></li>
										</ul></li>
								</ul>
								<li><a href="#">About</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="#">Contact</a></li>
								<li><a href="#">About</a></li>
							</c:otherwise>
						</c:choose>

					</ul>

					<c:if test="${user != null}">
						<ul class="nav navbar-nav navbar-right">
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="#" aria-expanded="true">
									${user.userName} <b class="caret"></b>
							</a>
								<ul class="dropdown-menu">
									<li><a href="${linkTo[UserController].logout}">Logout</a></li>
									<li><a href="${linkTo[UserController].add}">New User</a></li>
								</ul></li>
						</ul>
					</c:if>

				</div>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-md-5 col-md-offset-3">
				<div id="message-system" class="alert alert-dismissable ${alert}">
					<p>${flash}</p>
				</div>
			</div>
		</div>