/**
 * 
 */
$(function() {
	dataTableEMETH.createDataTableWhitOutInfo("tblGrupos");
});

function inscribirDlgConfirm(grupo, idGrupo) {
	$("#inscribirGrupo").removeClass("hidden");
	$("#txtGroup").text(grupo + "?");
	$("#hdnID").attr("value", idGrupo);
	$.publish("showDlgInscribir");
}

function cerrarDlgInscribir() {
	$.publish("closeDlgInscribir");
}