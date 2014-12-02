<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="row">
	<div class="col-md-6">
		<form method="get" action="${linkTo[ServiceController].busca}">
			<input type="date" class="form-control" name="day" id="data_passada" />
			<input type="submit" value="Buscar" class="btn btn">
		</form>
	</div>
</div>
<jsp:include page="tab_list_services.jsp"></jsp:include>




