<!-- Button trigger modal -->
<button type="button" class="btn btn-warning btn-lg " data-toggle="modal"
	data-target="#myModal">Checking</button>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Register here,
					vehicles</h4>
			</div>
			<form action="${linkTo[ServiceController].newService}" method="post"
				role="form" class="form-horizontal">
				<div class="modal-body">
					<!-- form vehicle -->
					<div class="form-group" id="vehicle_first">
						<div class="col-lg-6 col-md-6 ">
							<label for="inputuserName" class="col-sm-0 control-label">Search
								for a car by LicensePlate</label> <input type="text"
								name="vehicle.licensePlate" placeholder="licencePlate." required
								class="form-control" id="licensePlate" maxlength="7" autofocus="autofocus"/>
						</div>
					</div>
					<div class="form-group" id="vehicle_last">
						<div class="col-md-4">
							<label for="inputuserName" class="col-sm-2 control-label">Model</label>
							<input type="text" name="vehicle.model" placeholder="model"
								id="model" required class="form-control" />
						</div>
						<div class="col-md-4">
							<label for="inputuserName" class="col-sm-2 control-label">Mark</label>
							<input type="text" name="vehicle.mark" id="mark"
								placeholder="mark" required class="form-control" />
						</div>
						<div class="col-md-4">
							<label for="inputuserName" class="col-sm-2 control-label">Color</label>
							<input type="text" name="vehicle.color" id="color"
								placeholder="color" required class="form-control" />
						</div>
						<input type="hidden" id="vehicle_id" value="NULL">
					</div>
					<!-- end vehicle -->

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<input type="submit" value="push" class="btn btn-success pull-right">
				</div>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/assets/js/searchVehicle.js"></script>