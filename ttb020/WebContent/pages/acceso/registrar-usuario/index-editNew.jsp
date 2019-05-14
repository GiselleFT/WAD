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
	]]>
</jsp:text>

</head>
<body>
	<!--Comienza el archivo-->

	<div class="col-md-12">
		<h1 class="title">
			<s:text name="Registrar Usuario"></s:text>
		</h1>
	</div>

	<div class="row form-group">
		<div class="col-md-8 col-md-offset-2">
			<s:actionerror theme="bootstrap" />
			<s:actionmessage theme="bootstrap" />
		</div>
	</div>

	<!-- Formulario Registro -->

	<s:form id="frmLogin" method="post" theme="simple"
		action="%{#pageContext.request.contextPath}/acceso/registrar-usuario">
		<fieldset class="form form-horizontal form-medium">
			<legend class="form-section">
				<label> <s:property value="'Información del usuario'" />
				</label>
			</legend>
			<!-- NOMBRE -->
			<div class="form-group">
				<label
					class="col-xs-2 col-sm-4 col-md-4">
					<s:text name="" />
				</label>
				<div class="col-xs-12 col-sm-8 col-md-4">
					<s:textfield cssClass="form-control"
						cssClassError="input-error" name="nombre" id="nbUsuario"
						placeholder="Nombre" />
					<s:fielderror fieldName="nombre" cssClass="error"
						theme="bootstrap" />
				</div>
			</div>
			<!-- PRIMER APELLIDO -->
			<div class="form-group">
				<label
					class="col-xs-2 col-sm-4 col-md-4"><s:property
						value="''" /></label>
				<div class="col-xs-12 col-sm-8 col-md-4 ">
					<s:textfield cssClass="form-control" name="primerApellido"
						cssClassError="input-error" id="pApellido"
						placeholder="Primer Apellido" />
					<s:fielderror fieldName="primerApellido" cssClass="error"
						theme="bootstrap" />
				</div>
			</div>

			<!-- SEGUNDO APELLIDO -->
			<div class="form-group">
				<label
					class="col-xs-2 col-sm-4 col-md-4"><s:property
						value="''" /></label>
				<div class="col-xs-12 col-sm-8 col-md-4 ">
					<s:textfield cssClass="form-control campo" name="segundoApellido"
						cssClassError="input-error" id="sApellido"
						placeholder="Segundo Apellido" />
					<s:fielderror fieldName="segundoApellido" cssClass="error"
						theme="bootstrap" />
				</div>
			</div>
		</fieldset>
		<!-- CUENTA -->
		<fieldset class="form form-horizontal form-medium">
			<legend class="form-section">
				<label> <s:text name="Datos de la cuenta" />
				</label>
			</legend>
			<!-- USUARIO -->
			<div class="form-group">
				<label
					class="col-xs-2 col-sm-4 col-md-4">
					<s:text name="" />
				</label>
				<div class="col-xs-12 col-sm-8 col-md-4">
					<s:textfield cssClass="form-control"
						cssClassError="input-error" name="model.login" id="txUsuario"
						placeholder="Correo Electrónico" />
					<s:fielderror fieldName="model.login" cssClass="error"
						theme="bootstrap" />
				</div>
			</div>
			<!-- CONTRASEÑA -->
			<div class="form-group">
				<label
					class="col-xs-2 col-sm-4 col-md-4 "><s:property
						value="''" /></label>
				<div class="col-xs-12 col-sm-8 col-md-4 ">
					<s:password cssClass="form-control" name="model.password"
						cssClassError="input-error" id="txContrasena"
						placeholder="Contraseña" />
					<s:fielderror fieldName="model.password" cssClass="error"
						theme="bootstrap" />
				</div>
			</div>

			<!-- CONFIRMAR CONTRASEÑA -->
			<div class="form-group">
				<label
					class="col-xs-2 col-sm-4 col-md-4"><s:property
						value="''" /></label>
				<div class="col-xs-12 col-sm-8 col-md-4 ">
					<s:password cssClass="form-control campo" name="confirmacion"
						cssClassError="input-error" id="txConfirmacion"
						placeholder="Confirmación de contraseña" />
					<s:fielderror fieldName="confirmacion" cssClass="error"
						theme="bootstrap" />
				</div>
			</div>
			<!-- Tipo de Usuario -->
			<div class="form-group text-left">
				<label class="col-md-4 "> <s:text
						name="" />
				</label>
				<div class="col-md-4">
					<s:select id="slcTipo" name="model.idPerfil" list="listPerfiles"
						listKey="id" listValue="nombre" headerKey="-1"
						headerValue="Tipo de Usuario" cssClass="form-control"
						cssErrorClass="field-error" />
					<s:fielderror fieldName="idPerfil" cssClass="error"
						theme="bootstrap" />
				</div>
			</div>
		</fieldset>
		<!-- BOTON ACEPTAR -->
		<div class="row">
			<div class="outter-section form-medium text-right">
				<s:submit cssClass="btn btn-ttb020" value="Aceptar" />

				<a class="btn btn-ttb020"
					href="${pageContext.request.contextPath}/acceso/login"> <s:text
						name="Cancelar" />
				</a>
			</div>
		</div>
	</s:form>


</body>
	</html>
</jsp:root>
