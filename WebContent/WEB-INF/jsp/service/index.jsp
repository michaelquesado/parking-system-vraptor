<jsp:include page="../header.jsp"></jsp:include>

<div class="page-header">
	<h3>Deixe, que nós cuidados do seu carro.</h3>
</div>
<div class="row">
	<div class="col-md-8 col-lg-8">
		<form action="${linkTo[ServiceController].search }" method="post">
			<input type="text" name="vehicle.licensePlate" placeholder="busque pelo carro." required/> 
		</form>
	</div>
</div>

<jsp:include page="../footer.jsp"></jsp:include>