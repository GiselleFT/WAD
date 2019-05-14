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
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<s:url var="urlRutaContextoTema"
	value="%{#pageContext.request.contextPath}/resources/template/themes"
	includeContext="true" />
<sj:head debug="true" jqueryui="true" jquerytheme="jqueryTheme"
	locale="es" customBasepath="%{#urlRutaContextoTema}" />
<title><s:text name="Sistema UML TTB020" /></title>
<link rel="icon" type="image/png"
	href="${pageContext.request.contextPath}/resources/images/favicon.png"
	sizes="32x32" />
<link rel="icon" type="image/png"
	href="${pageContext.request.contextPath}/resources/images/favicon.png"
	sizes="16x16" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/components/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/components/metisMenu/metisMenu.min.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/components/dist/css/sb-admin-2.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/components/dataTables/media/css/jquery.dataTables.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/components/dataTables/media/css/dataTables.jqueryui.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/components/dataTables/media/css/responsive.dataTables.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/componentes.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/scrolling-nav.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/material-icons.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/material-loader.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/components/font-awesome/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/sidenav.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/UDStyle.css" />
<link
	href="https://fonts.googleapis.com/css?family=Rajdhani|Roboto+Condensed"
	rel="stylesheet" />
<link
	href="https://www.w3schools.com/w3css/4/w3.css"
	rel="stylesheet" />
<jsp:text>
	<![CDATA[
	<script src="${pageContext.request.contextPath}/resources/components/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/resources/components/metisMenu/metisMenu.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/resources/components/dist/js/sb-admin-2.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/resources/components/dataTables/media/js/jquery.dataTables.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/resources/components/dataTables/media/js/dataTables.responsive.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/resources/scripts/emeth-dataTables.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/resources/scripts/sidenav.js" type="text/javascript"></script>
	]]>
</jsp:text>
<decorator:head />
</head>
<body>

	<!--<script src="${pageContext.request.contextPath}/resources/components/materialize/js/materialize.min.js" type="text/javascript"></script>-->
	<!--<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/components/materialize/css/materialize.min.css" />-->
	<div id="main">
		<div id="wrapper">
			<s:include value="header.jsp" />
			<div id="intro" class="intro-section">
				<decorator:body />
			</div>
		</div>
	</div>
	<!-- Campos necesarios para la instanciacion del idioma español en los datatables -->
	<input type="text" style="display: none;" id="hdnRutaContexto"
		value="${pageContext.request.contextPath}" />
	<s:textfield cssClass="hidden" id="hdnUrlLanguageDataTable"
		value="%{getText('/resources/components/dataTables/media/js/i18n/Spanish.json')}" />
</body>
	</html>
</jsp:root>
