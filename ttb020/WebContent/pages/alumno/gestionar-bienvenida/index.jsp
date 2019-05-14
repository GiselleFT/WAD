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
		src="${pageContext.request.contextPath}/pages/alumno/gestionar-bienvenida/js/index.js" type="text/javascript"></script>
	]]>
</jsp:text>

</head>
<body>

	<div class="col-md-12">
		<h1 class="title">
			<s:property value="'Bienvenido Alumno '" />
			<s:property value="alumno" />
		</h1>
	</div>

	<div class="row form-group">
		<div class="col-md-8 col-md-offset-2">
			<s:actionerror theme="bootstrap" />
			<s:actionmessage theme="bootstrap" />
		</div>
	</div>

	<fieldset class="form form-horizontal form-medium">
		<!-- BOTONES DEL PROCESO DE CONFIGURAR OFERTA -->
		<div class="form-group">
			<div class="row">
				<!-- BOTON CREAR GRUPO -->
				<div class="col-md-6">
					<a
						href="${pageContext.request.contextPath}/alumno/gestionar-proyecto-alumno/new?idAlumno=${alumno.id}"
						class="btn btn-default btn-grid"> <i class="material-icons"
						style="font-size: 48px; color: white;">add_box</i> <br /> <label><s:text
								name="Crear Proyecto" /></label> <br />

					</a>
				</div>
				<!-- BOTON EDITAR PERFIL -->
				<div class="col-md-6">
					<a
						href="${pageContext.request.contextPath}/control-escolar/gestionar-actividad?idOfertaSel=${idSel}&amp;idTipoSel=${idTipoSel}"
						class="btn btn-grid-second"> <i class="material-icons"
						style="font-size: 48px; color: white;">edit</i><br /> <label><s:text
								name="Editar perfil" /></label>

					</a>
				</div>
			</div>
		</div>
	</fieldset>

	<!-- Tabla grupo -->
	<fieldset class="form form-horizontal form-medium">
		<legend class="form-section">
			<label><s:text name="Proyectos recientes" /></label>
		</legend>
		<table id="tblProyectos" class="">
			<thead>
				<tr>
					<th data-priority="1"><s:text name="Proyecto" /></th>
					<th data-priority="1"><s:text name="Grupo" /></th>
					<th data-priority="2"><s:text name="" /></th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="listProyectos" var="proyecto">
					<tr>
						<td><s:property value="#proyecto.nombre" /></td>
						<td><s:property value="#proyecto.grupo.nombre" /></td>
						<td>
							<!-- Finalizar Ciclo --> <a
							href="${pageContext.request.contextPath}/diagrama/visualizar-detalle-proyecto?idProyecto=${proyecto.id}"
							title="${finalizar}" class="btn btn-ttb020"> <i
								class="material-icons" style="color: white;">assignment</i> <s:text name=" Proyectos"/>
						</a>
						</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</fieldset>
</body>
	</html>
</jsp:root>