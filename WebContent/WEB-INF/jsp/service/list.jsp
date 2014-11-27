<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="../header.jsp"></jsp:include>
<div class="row">
	<div class="col-lg-12">
		<div class="page-header ">
			<h3>All services.</h3>
		</div>
	</div>
</div>
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
				<c:forEach items="${services}" var="s">
					<tr>
						<td>${s.vehicle.licensePlate}</td>
						<td><fmt:formatDate type="both"
								value="${s.dateTimeEntry.time}" /></td>
						<td><fmt:formatDate type="both" value="${s.dateTimeOut.time}" /></td>
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