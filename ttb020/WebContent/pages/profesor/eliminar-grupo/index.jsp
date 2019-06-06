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
			<s:property value="'Bienvenido Profesor '" />
			<s:property value="profesor" />
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
				<div class="col-md-12">
					<a
						href="${pageContext.request.contextPath}/profesor/gestionar-grupo/new?idProfesorSel=${profesor.id}"
						class="btn btn-grid"> <i class="material-icons"
						style="font-size: 48px; color: white;">add_box</i><br /> <label><s:text
								name="Crear grupo" /></label>
					</a>
				</div>
			</div>
		</div>
	</fieldset>

	<!-- Tabla grupo -->
	<fieldset class="form form-horizontal form-medium">
		<table id="tblGrupo" class="">
			<thead>
				<tr>
					<th data-priority="1"><s:text name="Nombre del grupo" /></th>
					<th data-priority="2"><s:text name="" /></th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="listGrupos" var="grupo">
					<tr>
						<td><s:property value="#grupo.nombre" /></td>
						<td>
							<!-- Finalizar Ciclo --> <a
							href="${pageContext.request.contextPath}/profesor/evaluar-proyecto?idProfesorSel=${profesor.id}&amp;idGrupoSel=${grupo.id}"
							title="${Proyectos}" class="btn btn-ttb020"> <i
								class="material-icons">assignment_turned_in</i> <s:text name=" Proyectos" />
						</a> <!-- Visualizar  --> <a
							href="${pageContext.request.contextPath}/profesor/gestionar-grupo/${grupo.id}?idProfesorSel=${profesor.id}"
							title="${visualizar}" class="btn btn-ttb020-second"> <i
								class="material-icons">&#xE8F4;</i> <s:text name=" Alumnos" />
						</a> 
						<!-- Eliminar Ciclo 
						<s:form id="frmEliminarGrupo" method="delete"
							action="%{pageContext.request.contextPath}/profesor/gestionar-grupo/%{#grupo.id}">
							<s:submit cssClass="btn btn-ttb020-third material-icons" value="Eliminar" />
						</s:form>
						 -->
						 <a
							href="${pageContext.request.contextPath}/profesor/eliminar-grupo/${grupo.id}"
							title="${visualizar}" class="btn btn-ttb020-second"> <i
								class="material-icons">&#xE8F4;</i> <s:text name=" Eliminar" />
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