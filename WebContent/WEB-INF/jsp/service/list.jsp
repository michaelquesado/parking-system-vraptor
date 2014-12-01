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
		<ul class="nav nav-tabs" role="tablist" id="myTab">
			<li role="presentation" class="active"><a href="#home"
				aria-controls="home" role="tab" data-toggle="tab">All services</a></li>
			<li role="presentation"><a href="#other"
				aria-controls="profile" role="tab" data-toggle="tab">Other services</a></li>
		</ul>

		<div class="tab-content">
			<div role="tabpanel" class="tab-pane active" id="home">
				<jsp:include page="tab_list_services.jsp"></jsp:include>
			</div>
			<div role="tabpanel" class="tab-pane" id="other">
				<jsp:include page="tab_list_old_services.jsp"></jsp:include>
			</div>
		</div>

		
	</div>
</div>

<jsp:include page="../footer.jsp"></jsp:include>