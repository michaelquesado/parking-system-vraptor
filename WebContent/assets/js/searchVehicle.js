/**
 * 
 */

$("#licensePlate").blur(function() {
	if ($(this).val().length == 7) {
		$.ajax({
			type : 'GET',
			data : {
				licensePlate : $(this).val()
			},
			url : "search",
			dataType : 'text',
			success : function(result) {
				preencheCampos(result);
			},
		});
	}
});

function preencheCampos(result) {
	console.log(result);
}