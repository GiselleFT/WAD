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
		src="${pageContext.request.contextPath}/pages/profesor/gestionar-grupo/js/index.js" type="text/javascript"></script>
	]]>
</jsp:text>

</head>
<body>

	<div class="col-md-12">
		<h1 class="title">
			<s:property value="'Crear Diagrama de Clases'" />
		</h1>
	</div>

	<s:form id="frmLogin" method="post" theme="simple"
		action="%{#pageContext.request.contextPath}/diagrama/visualizar-detalle-proyecto!crearClases">
		<s:hidden name="idProyecto" value="%{idProyecto}" />
		<fieldset class="form form-horizontal form-medium">

			<!-- NOMBRE -->
			<div class="form-group outter-section">
				<label
					class="col-xs-2 col-sm-4 col-md-4">
					<s:text name="" />
				</label>
				<div class="col-xs-12 col-sm-8 col-md-4">
					<s:textfield cssClass="form-control campo"
						cssClassError="input-error" name="model.nombre" id="nGrupo"
						placeholder="Nombre del diagrama" />
					<s:fielderror fieldName="model.nombre" cssClass="error"
						theme="bootstrap" />
				</div>
			</div>
			<br />
		</fieldset>
		<!-- BOTON ACEPTAR -->
		<div class="row">
			<div class="outter-section form-medium text-right">
				<s:submit cssClass="btn btn-ttb020" value="Aceptar" />

				<a class="btn btn-ttb020"
					href="${pageContext.request.contextPath}/profesor/gestionar-grupo">
					<s:text name="Cancelar" />
				</a>
			</div>
		</div>
	</s:form>

</body>
	</html>
</jsp:root>