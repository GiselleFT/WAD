<?xml version="1.0" encoding="UTF-8"?>
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
	<script src="${pageContext.request.contextPath}/pages/diagrama/js/gestionar-errores.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/pages/diagrama/js/AgenteAjax.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/pages/diagrama/js/style.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/pages/diagrama/js/UDCore.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/pages/diagrama/js/UDModules.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/pages/diagrama/js/useCaseDiagram.js" type="text/javascript"></script>

	]]>
</jsp:text>
</head>
<body>
	<div class="btn-group outter-section" role="group"
		aria-label="Basic example">
		<button type="button" class="btn btn-secondary"
			onClick="descubreActor()" style="background-color: black;">
			<label style="color: white;"><s:property value="'Actor'" /></label>
		</button>
		<button type="button" class="btn btn-secondary"
			onClick="descubreUseCase()" style="background-color: black;">
			<label style="color: white;"><s:property
					value="'Caso de Uso'" /></label>
		</button>
		<button type="button" onClick="descubreSistema()"
			class="btn btn-secondary" style="background-color: black;">
			<label style="color: white;"><s:property value="'Sistema'" /></label>
		</button>
		<button type="button" onClick="descubreSubsistema()"
			class="btn btn-secondary" style="background-color: black;">
			<label style="color: white;"><s:property value="'Subsistema'" /></label>
		</button>
		<button type="button" id="botonRel" class="btn btn-secondary"
			style="background-color: black;">
			<label style="color: white;"><s:property value="'Asociación'" /></label>
		</button>
		<button type="button" id="botonExt" class="btn btn-secondary"
			style="background-color: black;">
			<label style="color: white;"><s:property value="'Extensión'" /></label>
		</button>
		<button type="button" id="botonInc" class="btn btn-secondary"
			style="background-color: black;">
			<label style="color: white;"><s:property value="'Inclusión'" /></label>
		</button>
		<button type="button" id="botonGen" class="btn btn-secondary"
			style="background-color: black;">
			<label style="color: white;"><s:property
					value="'Generalización'" /></label>
		</button>
		<button type="button" id="botonGuardar" class="btn btn-secondary"
			style="background-color: black;">
			<label style="color: white;"><s:property value="'Guardar'" /></label>
		</button>
		<button type="button" id="botonBorrar" class="btn btn-secondary"
			style="background-color: black;">
			<label style="color: white;"><s:property value="'Borrar'" /></label>
		</button>
		<button type="button" onClick="descubreComentario()"
			class="btn btn-secondary" style="background-color: black;">
			<label style="color: white;"><s:property value="'Comentario'" /></label>
		</button>
	</div>
	<div class="row">
		<fieldset class="firstcolumn" style="background-color: #ffffff;">
			<legend class="form-section">
				<label><s:property value="'Información del elemento'" /></label>
			</legend>
			<div id="inputActor" class="">
				<div class="form-group outter-section">
					<label class="control-label label-obligatorio"> <s:text
							name="Nombre del Actor" />
					</label> <input id="nactor" class="form-control campo" /> <br /> <a
						class="btn btn-ttb020" href="#" role="button"
						id="botonActor">Actor</a>
				</div>
			</div>
			<div id="inputSubsistema" class="hidden">
				<div class="form-group outter-section">
					<label class="control-label label-obligatorio"> <s:text
							name="Subsistema" />
					</label> <input id="nsubsis" class="form-control campo" /><br /> <a
						class="btn btn-ttb020" href="#" role="button"
						id="botonSubSis">Subsistema</a>
				</div>
			</div>
			<div id="inputSistema" class="hidden">
				<div class="form-group outter-section">
					<label class="control-label label-obligatorio"> <s:text
							name="Sistema" />
					</label> <input id="nsis" class="form-control campo"/><br /> <a
						class="btn btn-ttb020" href="#" role="button"
						id="botonSis">Sistema</a>
				</div>
			</div>
			<div id="inputCaso" class="hidden">
				<div class="form-group outter-section">
					<label class="control-label label-obligatorio"> <s:text
							name="Caso de uso" />
					</label>
					<sj:autocompleter id="nombrecaso" list="listStrongVerbs"
						forceValidOption="false" valueWidget=""
						cssClass="form-control campo" />
					<br /> <a class="btn btn-ttb020" href="#"
						role="button" id="botonCu">Caso de Uso</a>
				</div>
			</div>
			<div id="inputComen" class="hidden">
				<div class="form-group outter-section">
					<label class="control-label label-obligatorio"> <s:text
							name="Comentario" />
					</label> <input id="nota" class="form-control campo" /><br /> <a
						class="btn btn-ttb020" href="#" role="button"
						id="botonNota">Nota</a>
				</div>
			</div>
		</fieldset>
		<div class="secondcolumn" id="useCaseDiagram"></div>
		<div class="thirdcolumn" id="comentarios">segunda columna</div>
		<div class="fourthcolumn" id="console">
			<p>Console >_</p>
		</div>
	</div>

	<!-- 	Formulario oculto para búsqueda AJAX del nombre del primer caso de uso -->
	<s:form id="hdnPruebaAjax" method="post"
		action="%{pageContext.request.contextPath}/diagrama/caso-uso!pruebaAjax">
		<s:hidden id="tipoRel" name="idRelacionSel" value="" />
		<s:hidden id="idNcu" name="ncu" value="" />
	</s:form>

	<!-- 	Formulario oculto para búsqueda AJAX de los nombres de caso de uso con su relacion -->
	<s:form id="hdnRegistrar" method="post"
		action="%{pageContext.request.contextPath}/diagrama/caso-uso!registrarDatos">
		<s:hidden id="Rel" name="idRelacionSel" value="" />
		<s:hidden id="Nomcu" name="ncu" value="" />
		<s:hidden id="Nomcu2" name="ncu2" value="" />
	</s:form>

	<!-- 	Formulario oculto para búsqueda AJAX de los datos del diagrama y guardarlo en BD -->
	<s:form id="hdnSave" method="post"
		action="%{pageContext.request.contextPath}/diagrama/caso-uso!actualizarData">
		<s:hidden id="idDiagrama" name="data" value="" />
		<s:hidden name="idSel" value="%{idSel}" />
	</s:form>

	<!-- 	Formulario oculto para búsqueda AJAX del tipo de relacion -->
	<s:form id="guardarComentario" method="post"
		action="%{pageContext.request.contextPath}/diagrama/caso-uso!guardarComentario">
		<s:hidden id="textoComentario" name="texto" value="" />
		<s:hidden id="idProyecto" name="idProyecto" value="" />
	</s:form>

	<!-- Dialogo de confirmacion para cambiar a estado de historico -->
	<sj:dialog id="cancelarOperacion" modal="true"
		title="Diagrama guardado" autoOpen="false"
		openTopics="showDlgCancelarOperacion"
		closeTopics="closeDlgCancelarOPeracion" resizable="false"
		draggable="false">
		<div class="row">
			<div class="col-md-12">
				<s:text
					name="El Diagrama de caso de uso se ha actualizado con exito!" />
			</div>
		</div>
		<!-- Botones de aceptar y cancelar -->
		<div class="row">
			<div class="text-right col-md-12">
				<a onclick="cerrarDlgCancelar()"
					class="btn btn-default btn-default-eld"><s:text
						name="Entendido" /></a>
			</div>
		</div>
	</sj:dialog>

</body>
	</html>
</jsp:root>
