/**
 * @author fillipquesado
 * 
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
				if (result !== null)
					preencheCampos(result);
			},
			error : function() {
				nadaEncontrado();
				
			},
		});
	}
});

function preencheCampos(vehicle) {

	v = $.parseJSON(vehicle);
	for ( var i in v) {

		$("#" + i).attr("value", v[i]);
		if (i !== 'licensePlate') {
			$("#" + i).prop("disabled", true);
		}
	}

	$("#vehicle_first").addClass("has-success");
	$("#vehicle_last").addClass("has-success");

}

function nadaEncontrado() {

	$("#vehicle_first").removeClass("has-success");
	$("#vehicle_last").removeClass("has-success");

	$("#vehicle_first").addClass("has-error");
	$("#vehicle_last").addClass("has-error");

	var campos = [ "model", "vehicle_id", "licensePlate", "mark", "color" ];
	for (var i = 0; i <= campos.length; i++) {
		
		$("#" + campos[i]).prop("disabled", false);

	}
}
