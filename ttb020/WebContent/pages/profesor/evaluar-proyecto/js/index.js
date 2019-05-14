/**
 * 
 */
$(function() {
	dataTableEMETH.createDataTableWhitOutInfo("tblProyectos");
});

/**
 * Implementación de llamada a AJAX que va a traer la versión
 * @param version
 * @returns
 */
function buscarPrueba() {
	//$("#hdnProgramaSel").attr("value", plan);
	var form = $("#hdnPruebaAjax");
	
	$.ajax({
		type : form.attr("method"),
		url : form.attr("action"),
		data : form.serialize(),
		cache : false,
		dataType : 'html',
		async : false,
		success : function(data) {
			var respuesta = JSON.parse(data).ajaxResult;
			if(respuesta.response.estatus == "ENCONTRADO") {
				$("#textPrueba").text(respuesta.response.string);
			}
			else {
				console.log("No se encontró un plan vigente");
			}
		},
		error : function(data) {
			console.log("error");
		}
	});
}