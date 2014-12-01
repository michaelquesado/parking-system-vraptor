<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="row">
	<div class="col-md-6">
		<input type="date" class="form-control" id="data_passada" />
	</div>
</div>
<script>
	$("#data_passada").blur(function(){
				$.ajax({
					type : 'GET',
					data : {
						day : $(this).val()
					},
					url : "service/byDay",
					dataType : 'text',
					success : function(result) {
						if (result !== null)
							console.log(result);
					},
					error : function() {
						console.log("nada_retornado");
						
					},
				});
	});
</script>