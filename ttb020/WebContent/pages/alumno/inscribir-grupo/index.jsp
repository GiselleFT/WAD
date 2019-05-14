<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:decorator="http://www.opensymphony.com/sitemesh/decorator"
	xmlns:c="http://java.sun.com/jsp/jstl/core" xmlns:s="/struts-tags"
	xmlns:sj="/struts-jquery-tags"
	xmlns:log="http://jakarta.apache.org/taglibs/log-1.0">
	<jsp:directive.page language="java"
		contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" />
	<jsp:text>
		<![CDATA[ <?xml version="1.0" encoding="UTF-8" ?> ]]>
	</jsp:text>
	<jsp:text>
		<![CDATA[ <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> ]]>
	</jsp:text>
	<html xmlns="http://www.w3.org/1999/xhtml" slick-uniqueid="3" dir="ltr"
		class="com_content view-article itemid-482 home j25 mm-hover no-touch uk-notouch wf--n4-active wf-opensans-n4-active wf-opensans-n6-active wf-opensans-n3-active wf-active"
		lang="es-MX">
<head>
<jsp:text>
	<![CDATA[
	<script
		src="${pageContext.request.contextPath}/pages/alumno/inscribir-grupo/js/index.js" type="text/javascript"></script>
	]]>
</jsp:text>

</head>
<body>

	<s:set var="listPerfiles" value="{}" />

	<!-- TITULO -->
	<div class="col-md-12">
		<h1 class="title">
			<s:property value="'Inscribirse a un Grupo'" />
		</h1>
	</div>

	<div class="row form-group">
		<div class="col-md-8 col-md-offset-2">
			<s:actionerror theme="bootstrap" />
			<s:actionmessage theme="bootstrap" />
		</div>
	</div>

	<fieldset class="form form-horizontal form-medium">
		<legend class="form-section">
			<label><s:property value="'Información del profesor'" /></label>
		</legend>
		<s:form id="frmBuscar" method="get" theme="simple"
			action="%{#pageContext.request.contextPath}/alumno/inscribir-grupo!buscarGrupo">
			<div class="row outter-section">
				<div class="form-group ">
					<label class="col-md-4 control-label label-obligatorio "> <s:text
							name="Nombre del profesor" />
					</label>
					<div class="col-xs-12 col-sm-4 col-md-4">
						<sj:autocompleter id="slcProf" name="idProfesorSel"
							list="listProfesores" listValue="toString()" listKey="id"
							selectBox="false" selectBoxIcon="true"
							onChangeTopics="autocompleteChange"
							onFocusTopics="autocompleteFocus"
							onSelectTopics="autocompleteSelect" />
						<s:fielderror fieldName="idProfesorSel" cssClass="error"
							theme="bootstrap" />
					</div>

					<!-- BOTON BUSCAR -->
					<div class="col-md-1 col-xs-12">
						<s:submit cssClass="btn btn-ttb020"
							value="Buscar" />
					</div>
				</div>
			</div>
		</s:form>
	</fieldset>

	<fieldset class="form form-horizontal form-medium">
		<legend class="form-section">
			<label><s:property value="'Grupos'" /></label>
		</legend>
		<table id="tblGrupos" class="">
			<thead>
				<tr>
					<th data-priority="1"><s:text name="Grupo" /></th>
					<th data-priority="2"><s:text name="" /></th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="listGrupos" var="grupo">
					<tr>
						<td><s:property value="#grupo.nombre" /></td>
						<td>
							<a
							onclick="inscribirDlgConfirm('${grupo.nombre}', '${grupo.id}')"
							title="${finalizar}" class="btn btn-ttb020-third"> <i class="material-icons">book</i><s:text name=" Inscribirse"/>
						</a>

						</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</fieldset>

	<!-- DIALAGO INSCRIBIR ALUMNO -->
	<sj:dialog id="inscribirGrupo" modal="true"
		title="Confirmar Inscripción" autoOpen="false"
		openTopics="showDlgInscribir" closeTopics="closeDlgInscribir"
		resizable="false" draggable="false">
		<s:form method="POST" action="inscribir-grupo">
			<s:hidden id="hdnID" name="idGrupoSel" value="" />
			<div class="row">
				<div class="col-md-12">
					<s:property value="'¿Estas seguro de inscribirte al grupo '" />
					<label><p id="txtGroup"></p></label>
					<s:property value="'?'" />
				</div>
			</div>
			<!-- Botones de si y no -->
			<div class="row">
				<div class="text-right col-md-12">
					<s:submit cssClass="btn btn-ttb020" value="Aceptar" />
					<a onclick="cerrarDlgInscribir()"
						class="btn btn-ttb020"><s:text name="Cancelar" /></a>
				</div>
			</div>

		</s:form>
	</sj:dialog>
</body>
	</html>
</jsp:root>