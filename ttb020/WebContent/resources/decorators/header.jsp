<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:decorator="http://www.opensymphony.com/sitemesh/decorator"
	xmlns:c="http://java.sun.com/jsp/jstl/core" xmlns:s="/struts-tags"
	xmlns:sj="/struts-jquery-tags"
	xmlns:log="http://jakarta.apache.org/taglibs/log-1.0">
	<jsp:directive.page language="java"
		contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" />
	<!-- Usuario en sesion -->
	<s:set var="usuario" value="%{#session['session_user']}" />
	<!-- Perfiles que se encuentran en el sistema -->
	<s:set var="varProf"
		value="%{@escom.ttb020.controlacceso.mapeo.Perfil$PerfilUsuarioEnum@PROFESOR.getValor()}" />
	<s:set var="varAl"
		value="%{@escom.ttb020.controlacceso.mapeo.Perfil$PerfilUsuarioEnum@ALUMNO.getValor()}" />
	<!-- Navigation -->
	<nav class="navbar navbar-fixed-top navbar-ttb020" role="navigation"
		style="margin-bottom: 0">
		<s:if test="%{#usuario neq null}">
			<div class="navbar-header">
				<div class="nav navbar-top-links navbar-left">
					<div style="float: left; width: 35px; margin-left: 20px;">
						<span
							style="font-size: 30px; cursor: pointer; color: white; float: left; width: 35px; margin-left: 20px; margin-top: 10px;"
							onclick="openNav()">&#9776; </span>
					</div>
				</div>

			</div>
		</s:if>
		<div class="nav navbar-top-link text-center">
			<span style="font-size: 30px; color: white; margin-top: 10px;">
				Trabajo Terminal 2017-B020 </span>
		</div>

		<s:if test="#usuario.perfil.id == #varProf">
			<div id="mySidenav" class="sidenav">
				<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&#9932;</a>
				<a href="#">Menu Profesor</a>
			</div>
		</s:if>
		<s:elseif test="#usuario.perfil.id == #varAl">
			<div id="mySidenav" class="sidenav">
				<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&#9932;</a>
				<a href="#">Menu Alumno</a> <a
					href="${pageContext.request.contextPath}/alumno/inscribir-grupo">Inscribirse
					a un Grupo</a>
			</div>
		</s:elseif>
	</nav>

</jsp:root>
