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
	<script src="${pageContext.request.contextPath}/pages/diagrama/js/classDiagram-edit.js" type="text/javascript"></script>

	]]>
</jsp:text>
</head>
<body>
	<s:set var="varAl"
		value="%{@escom.ttb020.controlacceso.mapeo.Perfil$PerfilUsuarioEnum@ALUMNO.getValor()}" />
	<!-- Usuario en sesion -->
	<s:set var="usuario"
		value="%{#session['session_user']}" />
	<s:hidden id="hdnXML" name="data" value="%{version.data}"></s:hidden>
	<div class="btn-group outter-section" role="group"
		aria-label="Basic example">
		<s:if test="#usuario.perfil.id == #varAl">
			<button type="button" class="btn btn-secondary"
				onClick="descubreClase()" style="background-color: black;">
				<label style="color: white;"><s:property value="'Clase'" /></label>
			</button>
			<button type="button" onClick="descubreAtributo()"
				class="btn btn-secondary" style="background-color: black;">
				<label style="color: white;"><s:property value="'Atributo'" /></label>
			</button>
			<button type="button" onClick="descubreMetodo()"
				class="btn btn-secondary" style="background-color: black;">
				<label style="color: white;"><s:property value="'Método'" /></label>
			</button>
			<button type="button" id="botonGen" class="btn btn-secondary"
				style="background-color: black;">
				<label style="color: white;"><s:property value="'Herencia'" /></label>
			</button>
			<button type="button" id="botonGen" class="btn btn-secondary"
				style="background-color: black;">
				<label style="color: white;"><s:property
						value="'Generalización'" /></label>
			</button>
			<button type="button" id="botonAs" class="btn btn-secondary"
				style="background-color: black;">
				<label style="color: white;"><s:property
						value="'Asociación'" /></label>
			</button>
			<button type="button" id="botonAg" class="btn btn-secondary"
				style="background-color: black;">
				<label style="color: white;"><s:property
						value="'Agregación'" /></label>
			</button>
			<button type="button" id="botonComposicion" class="btn btn-secondary"
				style="background-color: black;">
				<label style="color: white;"><s:property
						value="'Composición'" /></label>
			</button>
			<button type="button" id="botonDep" class="btn btn-secondary"
				style="background-color: black;">
				<label style="color: white;"><s:property
						value="'Dependencia'" /></label>
			</button>
			<button type="button" onClick="descubreComponente()"
				class="btn btn-secondary" style="background-color: black;">
				<label style="color: white;"><s:property
						value="'Componente'" /></label>
			</button>
			<button type="button" class="btn btn-secondary"
				onClick="descubrePaquete()" style="background-color: black;">
				<label style="color: white;"><s:property value="'Paquete'" /></label>
			</button>
			<button type="button" id="botonGuardar" class="btn btn-secondary"
				style="background-color: black;">
				<label style="color: white;"><s:property value="'Guardar'" /></label>
			</button>
			<button type="button" onClick="descubreComentario()"
				class="btn btn-secondary" style="background-color: black;">
				<label style="color: white;"><s:property
						value="'Comentario'" /></label>
			</button>
			<button type="button" id="botonBorrar" class="btn btn-secondary"
				style="background-color: black;">
				<label style="color: white;"><s:property value="'Borrar'" /></label>
			</button>
		</s:if>
		<s:else>
			<button type="button" class="hidden btn btn-secondary"
				onClick="descubreClase()" style="background-color: black;">
				<label style="color: white;"><s:property value="'Clase'" /></label>
			</button>
			<button type="button" onClick="descubreAtributo()"
				class="hidden btn btn-secondary" style="background-color: black;">
				<label style="color: white;"><s:property value="'Atributo'" /></label>
			</button>
			<button type="button" onClick="descubreMetodo()"
				class="hidden btn btn-secondary" style="background-color: black;">
				<label style="color: white;"><s:property value="'Método'" /></label>
			</button>
			<button type="button" id="botonGen" class="hidden btn btn-secondary"
				style="background-color: black;">
				<label style="color: white;"><s:property value="'Herencia'" /></label>
			</button>
			<button type="button" id="botonGen" class="hidden btn btn-secondary"
				style="background-color: black;">
				<label style="color: white;"><s:property
						value="'Generalización'" /></label>
			</button>
			<button type="button" id="botonAs" class="hidden btn btn-secondary"
				style="background-color: black;">
				<label style="color: white;"><s:property
						value="'Asociación'" /></label>
			</button>
			<button type="button" id="botonAg" class="hidden btn btn-secondary"
				style="background-color: black;">
				<label style="color: white;"><s:property
						value="'Agregación'" /></label>
			</button>
			<button type="button" id="botonComposicion"
				class="hidden btn btn-secondary" style="background-color: black;">
				<label style="color: white;"><s:property
						value="'Composición'" /></label>
			</button>
			<button type="button" id="botonDep" class="hidden btn btn-secondary"
				style="background-color: black;">
				<label style="color: white;"><s:property
						value="'Dependencia'" /></label>
			</button>
			<button type="button" onClick="descubreComponente()"
				class="hidden btn btn-secondary" style="background-color: black;">
				<label style="color: white;"><s:property
						value="'Componente'" /></label>
			</button>
			<button type="button" class="hidden btn btn-secondary"
				onClick="descubrePaquete()" style="background-color: black;">
				<label style="color: white;"><s:property value="'Paquete'" /></label>
			</button>
			<button type="button" id="botonGuardar"
				class="hidden btn btn-secondary" style="background-color: black;">
				<label style="color: white;"><s:property value="'Guardar'" /></label>
			</button>
			<button type="button" onClick="descubreComentario()"
				class="hidden btn btn-secondary" style="background-color: black;">
				<label style="color: white;"><s:property
						value="'Comentario'" /></label>
			</button>
			<button type="button" id="botonBorrar"
				class="hidden btn btn-secondary" style="background-color: black;">
				<label style="color: white;"><s:property value="'Borrar'" /></label>
			</button>
		</s:else>
	</div>
	<div class="row">
		<fieldset class="firstcolumn" style="background-color: #ffffff;">
			<legend class="form-section">
				<label><s:property value="'Información del elemento'" /></label>
			</legend>
			<div id="inputPaquete" class="hidden">
				<div id="inputClaseInside" class="form-group outter-section">
					<label class="control-label label-obligatorio"> <s:text
							name="Paquete" />
					</label><input id="npaq" class="form-control campo" /> <br /> <a
						class="btn btn-ttb020" role="button"
						id="botonPaq">Paquete</a>
				</div>
			</div>
			<div id="inputClase" class="hidden">
				<div id="inputClaseInside" class="form-group outter-section">
					<label class="control-label label-obligatorio"> <s:text
							name="Nombre de la Clase" />
					</label> <input id="nclase" class="form-control campo" /><br /> <a
						class="btn btn-ttb020" role="button"
						id="botonClase">Clase</a>
				</div>
			</div>
			<div id="inputComponente" class="hidden">
				<div id="inputClaseInside" class="form-group outter-section">
					<label class="control-label label-obligatorio"> <s:text
							name="Componente" />
					</label> <input id="ncomp" class="form-control campo" /><br /> <a
						class="btn btn-ttb020" role="button"
						id="botonComp">Componente</a>
				</div>
			</div>
			<div id="inputAtributo" class="hidden">
				<div id="inputClaseInside" class="form-group outter-section">
					<label class="control-label label-obligatorio"> <s:text
							name="Acceso" />
					</label> <select id="access" class="form-control">
						<option value="+" selected="selected">+ (public)</option>
						<option value="#"># (protected)</option>
						<option value="-">- (private)</option>
					</select> <label class="control-label label-obligatorio"> <s:text
							name="Nombre" />
					</label> <input id="nat" class="form-control campo" value="atributo" /> <label
						class="control-label label-obligatorio"> <s:text
							name="Tipo de dato" />
					</label> <input id="tipoDato" class="form-control campo" /> <br /> <a
						class="btn btn-ttb020" role="button" id="botonAt">Atributo</a>
				</div>
			</div>
			<div id="inputMetodo" class="hidden">
				<div id="inputClaseInside" class="form-group outter-section">
					<label class="control-label label-obligatorio"> <s:text
							name="Acceso" />
					</label> <select id="accessMet" class="form-control">
						<option value="+" selected="selected">+ (public)</option>
						<option value="#"># (protected)</option>
						<option value="-">- (private)</option>
					</select> <label class="control-label label-obligatorio"> <s:text
							name="Nombre" />
					</label> <input id="met" class="form-control campo" /> <label
						class="control-label"> <s:text name="Parametros" />
					</label> <input id="param" class="form-control campo" /> <label
						class="control-label"> <s:text name="Return" />
					</label> <input id="ret" class="form-control campo" /> <br /> <a
						class="btn btn-ttb020" role="button"
						id="botonMet">Método</a>
				</div>
			</div>
			<div id="inputComentario" class="hidden">
				<a class="btn btn-primary btn-lg" href="#" role="button"
					id="botonNota">Comentario</a>
			</div>
			<s:if test="#usuario.perfil.id != #varAl">
				<div id="inputComent">
					<div class="form-group outter-section">
						<label class="control-label label-obligatorio"> <s:text
								name="Comentario" />
						</label> <input id="comentarioIn" class="form-control campo" /><br /> <a
							class="btn btn-ttb020" role="button"
							id="botonComentario">Comentario</a>
					</div>
				</div>
			</s:if>
			<s:else>
				<div id="inputComent" class="hidden">
					<div class="form-group outter-section">
						<label class="control-label label-obligatorio"> <s:text
								name="Comentario" />
						</label> <input id="comentarioIn" class="form-control campo" /><br /> <a
							class="btn btn-ttb020" role="button"
							id="botonComentario">Comentario</a>
					</div>
				</div>
			</s:else>
		</fieldset>
		<div class="secondcolumn" id="classDiagram"></div>
		<div class="thirdcolumn" id="comentarios">segunda columna</div>
		<div class="fourthcolumn" id="console">
			<p>Console >_</p>
		</div>
	</div>

	<!-- Formulario oculto para búsqueda AJAX de los atributos y metodos de la clase -->
	<s:form id="hdnNombreClase" method="post"
		action="%{pageContext.request.contextPath}/diagrama/clases!obtenerAtMet">
		<s:hidden id="hdnClase" name="claseUno" value="" />
	</s:form>

	<!-- Formulario oculto para búsqueda AJAX de las clases con que se puede relacionar -->
	<s:form id="hdnClaseRel" method="post"
		action="%{pageContext.request.contextPath}/diagrama/clases!obtenerClases">
		<s:hidden id="hdnNomClase" name="claseUno" value="" />
		<s:hidden id="hdntipoRel" name="tipoRelacion" value="" />
	</s:form>

	<!-- Formulario oculto para enviar atributos -->
	<s:form id="hdnAtributos" method="post"
		action="%{pageContext.request.contextPath}/diagrama/clases!enviarAt">
		<s:hidden id="clase" name="clase" value="" />
		<s:hidden id="hdnAt" name="atributo" value="" />
	</s:form>

	<!-- Formulario oculto para enviar metodos -->
	<s:form id="hdnOperaciones" method="post"
		action="%{pageContext.request.contextPath}/diagrama/clases!enviarOp">
		<s:hidden id="classehdn" name="clase" value="" />
		<s:hidden id="hdnMet" name="metodo" value="" />
	</s:form>

	<!-- 	Formulario oculto para búsqueda AJAX de los datos del diagrama y guardarlo en BD -->
	<s:form id="hdnSave" method="post"
		action="%{pageContext.request.contextPath}/diagrama/clases!guardarVersion">
		<s:hidden id="idDiagrama" name="data" value="" />
		<s:hidden name="idSel" value="%{idSel}" />
	</s:form>

	<!-- Formulario para registrar datos en el XML -->
	<s:form id="hdnRegistrar" method="post"
		action="%{pageContext.request.contextPath}/diagrama/clases!registrarDatos">
		<s:hidden id="hdnClaseUno" name="claseUno" value="" />
		<s:hidden id="hdnClaseDos" name="claseDos" value="" />
		<s:hidden id="hdnRel" name="tipoRelacion" value="" />
	</s:form>

	<!-- 	Formulario oculto para búsqueda AJAX del tipo de relacion -->
	<s:form id="guardarComentario" method="post"
		action="%{pageContext.request.contextPath}/diagrama/clases!guardarComentario">
		<s:hidden id="textoComentario" name="texto" value="" />
		<s:hidden name="idSel" value="%{idSel}" />
	</s:form>


	<!-- Dialogo de confirmacion para cambiar a estado de historico -->
	<sj:dialog id="cancelarOperacion" modal="true"
		title="Diagrama guardado" autoOpen="false"
		openTopics="showDlgCancelarOperacion"
		closeTopics="closeDlgCancelarOPeracion" resizable="false"
		draggable="false">
		<div class="row">
			<div class="col-md-12">
				<s:text name="El Diagrama de clases se ha actualizado con exito!" />
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