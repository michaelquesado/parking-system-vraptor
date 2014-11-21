/**
 * 
 */

$("#licensePlate").keyup(function() {
	if ($(this).val().length == 7) {
		$.ajax({
			type : 'GET',
			data : {
				licensePlate : $(this).val()
			},
			url : "search",
			dataType : 'text',
			success : function(result) {
				if(result !== null)
					preencheCampos(result);
			},
			error : function(){
				nadaEncontrado();
				console.log("error");
			},
		});
	}
});

function preencheCampos(vehicle) {

	v = $.parseJSON(vehicle);
	$("#model").attr("value", v.model);
	$("#vehicle_id").attr("value", v.id);
	$("#licensePlate").attr("value", v.licensePlate);
	$("#mark").attr("value", v.mark);
	$("#color").attr("value", v.color);

	$("#vehicle_first").addClass("has-success");
	$("#vehicle_last").addClass("has-success");
}

function nadaEncontrado(){
	
	$("#vehicle_first").removeClass("has-success");
	$("#vehicle_last").removeClass("has-success");
	
	$("#vehicle_first").addClass("has-error");
	$("#vehicle_last").addClass("has-error");
}