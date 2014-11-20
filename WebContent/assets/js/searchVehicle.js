/**
 * 
 */

$("#licensePlate").keyup(function () {
    if($(this).val().length == 7){
        $.getJSON("search", {
            licensePlate: $(this).val()
        },
            function(result){
                if(result !==null){
                    preencheCampos(result);
                }
            }
        );
    }
});

function preencheCampos(result){
    console.log(result);
}