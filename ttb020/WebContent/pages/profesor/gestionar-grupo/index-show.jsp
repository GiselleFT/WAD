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
		src="${pageContext.request.contextPath}/pages/profesor/gestionar-grupo/js/index-show.js" type="text/javascript"></script>
	]]>
</jsp:text>

</head>
<body>

	<div class="col-md-12">
		<h1 class="title">
			<s:property value="'Alumnos Inscritos en el Grupo '" />
			<s:property value="model.nombre" />
		</h1>
	</div>

	<div class="row form-group">
		<div class="col-md-8 col-md-offset-2">
			<s:actionerror theme="bootstrap" />
			<s:actionmessage theme="bootstrap" />
		</div>
	</div>

	<fieldset class="form form-medium">
		<table id="tblAlumnos" class="">
			<thead>
				<tr>
					<th data-priority="1"><s:text name="Alumno" /></th>
					<th data-priority="2"><s:text name="" /></th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="listAlumnos" var="alumno">
					<tr>
						<td><s:property value="#alumno" /></td>
						<td>
							<!-- Eliminar Ciclo --> <a
							onclick="myClickDlgEliminar('${ciclo.id}','${ciclo.nombre}')"
							title="${eliminar}" class="btn btn-ttb020-third"> <i
								class="material-icons">delete_forever</i>
							<s:text name="Baja" />
						</a>

						</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</fieldset>

	<!-- BOTON ACEPTAR -->
	<div class="row">
		<div class="outter-section form-medium text-right">
			<a class="btn btn-ttb020"
				href="${pageContext.request.contextPath}/profesor/gestionar-grupo">
				<s:text name="Regresar" />
			</a>
		</div>
	</div>

</body>
	</html>
</jsp:root>