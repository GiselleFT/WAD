/**
 * 
 */
$(function() {
	dataTableEMETH.createDataTableWhitOutInfo("tblCasos");
	dataTableEMETH.createDataTableWhitOutInfo("tblClases");
});

function agregarDlgConfirm(idProyecto) {
	$("#agregarColab").removeClass("hidden");
	$("#hdnID").attr("value", idProyecto);
	$.publish("showDlgAgregar");
}

function cerrarDlgAgregar() {
	$.publish("closeDlgAgregar");
}