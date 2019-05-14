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
		src="${pageContext.request.contextPath}/pages/diagrama/visualizar-detalle-proyecto/js/index.js" type="text/javascript"></script>
	]]>
</jsp:text>

</head>
<body>

	<s:set var="varAl"
		value="%{@escom.ttb020.controlacceso.mapeo.Perfil$PerfilUsuarioEnum@ALUMNO.getValor()}" />
	<!-- Usuario en sesion -->
	<s:set var="usuario" value="%{#session['session_user']}" />

	<!-- TITULO -->
	<div class="col-md-12">
		<h1 class="title">
			<s:property value="'Detalles del Proyecto '" />
			<s:property value="proyectoSel.nombre" />
		</h1>
	</div>

	<div class="row form-group">
		<div class="col-md-8 col-md-offset-2">
			<s:actionerror theme="bootstrap" />
			<s:actionmessage theme="bootstrap" />
		</div>
	</div>

	<div class="row">
		<div class="outter-section form-medium text-left">
			<div class="col-md-12 text-md-left ">
				<label class="control-label text-left">Grupo</label>
				<s:property value="proyectoSel.grupo.nombre" />
			</div>
		</div>
	</div>

	<fieldset class="form form-horizontal form-medium">
		<legend class="form-section">
			<label><s:property value="'Información de los colaboradores'" /></label>
		</legend>
		<div class="outter-section col-md-6">
			<s:iterator value="alumnosColaboradores" var="alumno">
				<label class="control-label text-left">Nombre del alumno</label>
				<s:property value="alumno" />
				<br />
			</s:iterator>
		</div>
		<s:if test="#usuario.perfil.id == #varAl">
			<div class="col-md-6">
				<a onClick="agregarDlgConfirm('${idProyecto}')"
					class="btn btn-grid-third"> <i class="material-icons"
					style="font-size: 48px; color: white;">add_box</i><br /> <label><s:text
							name="Nuevo colaborador" /></label>

				</a>
			</div>
		</s:if>

	</fieldset>

	<s:if test="#usuario.perfil.id == #varAl">
		<!-- BOTONES PARA CREAR DIAGRAMAS -->
		<div class="form-group">
			<div class="row">
				<!-- BOTON CREAR NUEVO DIAGRAMA -->
				<div class="outter-section form-medium text-center">
					<div class="col-md-6">
						<a
							href="${pageContext.request.contextPath}/diagrama/visualizar-detalle-proyecto/new?idProyecto=${idProyecto}"
							class="btn btn-grid"> <i class="material-icons"
							style="font-size: 48px; color: white;">add_box</i> <br /> <label><s:text
									name="Nuevo diagrama de casos de uso" /></label>
						</a>
					</div>
				</div>
				<!-- BOTON BOTON CREAR DIAGRAMA CLASES -->
				<div class="outter-section form-medium text-center">
					<div class="col-md-6">
						<a
							href="${pageContext.request.contextPath}/diagrama/visualizar-detalle-proyecto!editNewClases?idProyecto=${idProyecto}"
							class="btn btn-grid-second"> <!-- Icono check_circle --> <i
							class="material-icons" style="font-size: 48px; color: white;">add_box</i>
							<br /> <label><s:text name="Nuevo diagrama de clases" /></label>

						</a>
					</div>
				</div>
			</div>
		</div>
	</s:if>

	<fieldset class="form form-horizontal form-medium">
		<legend class="form-section">
			<label><s:property value="'Diagramas de casos de uso'" /></label>
		</legend>
		<table id="tblCasos" class="">
			<thead>
				<tr>
					<th data-priority="1"><s:text name="Nombre del diagrama" /></th>
					<th data-priority="2"><s:text name="" /></th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="listCasos" var="caso">
					<tr>
						<td><s:property value="#caso.nombre" /></td>
						<s:if test="#usuario.perfil.id == #varAl">
							<td>
								<!-- Editar Diagrama --> <a
								href="${pageContext.request.contextPath}/diagrama/caso-uso/${caso.id}/edit"
								title="Editar última versión" class="btn btn-ttb020"> <i
									class="material-icons">edit</i> <s:text name=" Editar" />
							</a> <a
								href="${pageContext.request.contextPath}/diagrama/gestionar-version?idDiagramaSel=${caso.id}"
								title="Historial" class="btn btn-ttb020-second"> <i
									class="material-icons">history</i> <s:text name=" Historial" />
							</a> <a
								href="${pageContext.request.contextPath}/diagrama/visualizar-comentario?idDiagrama=${caso.id}&amp;idProyecto=${idProyecto}"
								title="Historial" class="btn btn-ttb020-third"> <i
									class="material-icons">chat</i> <s:text name=" Comentarios" />
							</a>
							</td>
						</s:if>
						<s:else>
							<td>
								<!-- Editar Diagrama --> <a
								href="${pageContext.request.contextPath}/diagrama/caso-uso/${caso.id}/edit"
								title="Ver última versión" class="btn btn-ttb020"> <i
									class="material-icons">remove_red_eye</i> <s:text name=" Ver" />
							</a> <a
								href="${pageContext.request.contextPath}/diagrama/visualizar-comentario?idDiagrama=${caso.id}&amp;idProyecto=${idProyecto}"
								title="Comentarios" class="btn btn-ttb020-second"> <i
									class="material-icons">chat</i> <s:text name=" Comentarios" />
							</a>
							</td>
						</s:else>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</fieldset>

	<fieldset class="form form-horizontal form-medium">
		<legend class="form-section">
			<label><s:property value="'Diagramas de clases'" /></label>
		</legend>
		<table id="tblClases" class="">
			<thead>
				<tr>
					<th data-priority="1"><s:text name="Nombre del diagrama" /></th>
					<th data-priority="2"><s:text name="" /></th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="listClases" var="diaC">
					<tr>
						<td><s:property value="#diaC.nombre" /></td>
						<s:if test="#usuario.perfil.id == #varAl">
							<td><a
								href="${pageContext.request.contextPath}/diagrama/clases/${diaC.id}/edit"
								title="Editar última versión" class="btn btn-ttb020"> <i
									class="material-icons">edit</i> <s:text name=" Editar" />
							</a><a
								href="${pageContext.request.contextPath}/diagrama/gestionar-version?idDiagramaSel=${diaC.id}"
								title="Historial" class="btn btn-ttb020-second"> <i
									class="material-icons">history</i> <s:text name=" Historial" />
							</a> <a
								href="${pageContext.request.contextPath}/diagrama/visualizar-comentario?idDiagrama=${diaC.id}&amp;idProyecto=${idProyecto}"
								title="Historial" class="btn btn-ttb020-third"> <i
									class="material-icons">chat</i> <s:text name=" Comentarios" />
							</a></td>
						</s:if>
						<s:else>
							<td>
								<!-- Editar Diagrama --> <a
								href="${pageContext.request.contextPath}/diagrama/clases/${diaC.id}/edit"
								title="Editar última versión" class="btn btn-ttb020"> <i
									class="material-icons">remove_red_eye</i> <s:text name=" Ver" />
							</a> <a
								href="${pageContext.request.contextPath}/diagrama/visualizar-comentario?idDiagrama=${diaC.id}&amp;idProyecto=${idProyecto}"
								title="Historial" class="btn btn-ttb020-second"> <i class="material-icons">chat</i> <s:text name=" Comentarios" />
							</a>
							</td>
						</s:else>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</fieldset>

	<s:if test="#usuario.perfil.id == #varAl">
		<!-- BOTON REGRESAR -->
		<div class="row">
			<div class="outter-section form-medium text-right">
				<a class="btn btn-ttb020"
					href="${pageContext.request.contextPath}/alumno/gestionar-bienvenida">
					<s:text name="Regresar" />
				</a>
			</div>
		</div>
	</s:if>
	<s:else>
		<div class="row">
			<div class="outter-section form-medium text-right">
				<a class="btn btn-ttb020"
					href="${pageContext.request.contextPath}/profesor/gestionar-grupo">
					<s:text name="Regresar" />
				</a>
			</div>
		</div>
	</s:else>

	<!-- DIALAGO AGREGAR COLABORADOR -->
	<sj:dialog id="agregarColab" modal="true" title="Agregar Colaborador"
		autoOpen="false" openTopics="showDlgAgregar"
		closeTopics="closeDlgAgregar" resizable="false" draggable="false">
		<s:form method="POST"
			action="visualizar-detalle-proyecto!agregarColaborador">
			<s:hidden id="hdnID" name="idProyecto" value="%{idProyecto}" />
			<div class="row">
				<!-- Tipo de Usuario -->
				<div class="form-group text-center">
					<label class="col-md-6 control-label label-obligatorio "> <s:text
							name="Selecciona un colaborador" />
					</label>
					<div class="col-md-4">
						<s:select id="slcTipo" name="idColaboradorSel"
							list="listPosiblesColaboradores" listKey="id"
							listValue="toString()" headerKey="-1" headerValue="Seleccione"
							cssClass="form-control" cssErrorClass="field-error" />
						<s:fielderror fieldName="idColaboradorSel" cssClass="error"
							theme="bootstrap" />
					</div>
				</div>
			</div>
			<!-- Botones de si y no -->
			<div class="row outter-section">
				<div class="text-right col-md-12">
					<s:submit cssClass="btn btn-ttb020" value="Aceptar" />
					<a onclick="cerrarDlgAgregar()" class="btn btn-ttb020"><s:text
							name="Cancelar" /></a>
				</div>
			</div>

		</s:form>
	</sj:dialog>

</body>
	</html>
</jsp:root>