<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="../header.jsp"></jsp:include>
<div class="row">
	<div class="col-lg-12">
		<jsp:include page="index.jsp"></jsp:include>
	</div>
</div>
<div class="row">
	<div class="col-lg-12 col-md-12">
		<div class="">
			<h2>All services.</h2>
		</div>
		<table
			class="table table-striped table-bordered  table-condensed table-hover">
			<thead>
				<tr>
					<th>LicensePlate</th>
					<th>Entry</th>
					<th>Out</th>
					<th>Stay</th>
					<th>Amount</th>
					<th>Actions</th>
				</tr>
			</thead>

			<tbody>
			
				<c:forEach items="${services}" var="s">
					<c:set var="checkout" value=""></c:set>
					<c:set var="name_button" value="checkout"></c:set>
					<c:set var="checkout_class" value="success"></c:set>
					<c:if test="${s.stay != null }">
						<c:set var="checkout" value="DISABLED"></c:set>
						<c:set var="checkout_class" value="danger"></c:set>
						<c:set var="name_button" value="finished"></c:set>
					</c:if>
					<tr>
						<td>${s.vehicle.licensePlate}</td>
						<td><fmt:formatDate type="both"
								value="${s.dateTimeEntry.time}" /></td>
						<td><fmt:formatDate type="both" value="${s.dateTimeOut.time}" /></td>
						<td>${s.stay}</td>
						<td><c:choose>
								<c:when test="${s.amount eq 0 }">
									free
								</c:when>
								<c:otherwise>
									<fmt:formatNumber type="number" maxIntegerDigits="2"
										value="${s.amount}" />
								</c:otherwise>
							</c:choose></td>
						<td><a href="${linkTo[ServiceController].checkout(s.id)}"
							class="btn btn-${checkout_class}" ${checkout}>${name_button}</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>