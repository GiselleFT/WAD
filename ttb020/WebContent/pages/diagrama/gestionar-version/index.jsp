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
	<!-- TITULO -->
	<div class="col-md-12">
		<h1 class="title">
			<s:property value="'Versiones del Diagrama '" /><s:property value="diagramaSel.nombre" />
		</h1>
	</div>

	<div class="row">
		<div class="outter-section form-medium text-left">
			<div class="col-md-12 text-md-left ">
				<label class="control-label text-left">Nombre del proyecto</label>
				<s:property value="diagramaSel.proyecto.nombre" />
			</div>
		</div>
	</div>

	<fieldset class="form form-horizontal form-medium">
		<table id="tblCasos" class="">
			<thead>
				<tr>
					<th data-priority="1"><s:property
							value="'Fecha de la versión'" /></th>
					<th data-priority="1"><s:text name="Nombre del colaborador" /></th>
					<th data-priority="2"><s:text name="" /></th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="listVersiones" var="version">
					<tr>
						<td><s:property value="#version.nombre" /></td>
						<td><s:property value="#version.alumno" /></td>
						<td><s:if test="%{diagramaSel.idTipo == 1}">
								<!-- Editar versión -->
								<a
									href="${pageContext.request.contextPath}/diagrama/caso-uso!editVersion?idVersionSel=${version.id}&amp;idSel=${diagramaSel.id}"
									title="Editar versión" class="btn btn-ttb020-second"> <i
									class="material-icons">edit</i> <s:text name=" Editar" />
								</a>
							</s:if> <s:else>
								<a
									href="${pageContext.request.contextPath}/diagrama/clases!editVersion?idVersionSel=${version.id}&amp;idSel=${diagramaSel.id}"
									title="Editar versión" class="btn btn-ttb020-second"> <i
									class="material-icons">edit</i> <s:text name=" Editar" />
								</a>
							</s:else></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</fieldset>

	<div class="row">
		<div class="outter-section form-medium text-right">
			<a class="btn btn-ttb020"
				href="${pageContext.request.contextPath}/diagrama/visualizar-detalle-proyecto?idProyecto=${diagramaSel.proyecto.id}">
				<s:text name="Regresar" />
			</a>
		</div>
	</div>

</body>
	</html>
</jsp:root>