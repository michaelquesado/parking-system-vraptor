<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../header.jsp"></jsp:include>
<div class="row">
	<div class="col-lg-12 col-md-12">
		<table
			class="table table-striped table-bordered  table-condensed table-hover">
			<thead>
				<tr>
					<th>LicensePlate</th>
					<th>Entry</th>
					<th>Out</th>
					<th>Stay</th>
					<th>Amount</th>
					<th>UserName</th>
					<th>Level</th>
					<th>Actions</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${services }" var="s">
					<tr>
						<td>${s.vehicle.licensePlate}</td>
						<td>${s.dateTimeEntry}</td>
						<td>${s.dateTimeOut}</td>
						<td>${s.stay}</td>
						<td>${s.amount}</td>
						<td>${s.user.userName}</td>
						<td>${s.user.level}</td>
						<td><a href="${linkTo[ServiceController].checkout(s.id)}"
							class="btn btn-primary">CheckOut</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>