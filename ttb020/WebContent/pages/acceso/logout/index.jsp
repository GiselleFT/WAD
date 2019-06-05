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
	<script src="https://unpkg.com/react@16/umd/react.development.js" crossorigin=""></script> 
    <script src="https://unpkg.com/react-dom@16/umd/react-dom.development.js" crossorigin=""></script> 
    <script src="https://unpkg.com/babel-standalone@6/babel.min.js" crossorigin=""></script> 
    
    <script  type="text/babel" src="Test.jsx"></script>
	]]>
</jsp:text>

</head>
<body>
	<!--Comienza el archivo-->
	<div class="col-md-12">
		<h1 class="title">Hasta pronto
		</h1>	
	</div>

	<div class="row form-group">
		<div class="col-md-8 col-md-offset-2">
			<s:actionerror theme="bootstrap" />
			<s:actionmessage theme="bootstrap" />
		</div>
	</div>

	<!-- Formulario Login -->
	<div class="col-sm-12">
		<s:form id="frmLogin" method="post" theme="simple"
			cssClass="form form-horizontal form-medium"
			action="%{#pageContext.request.contextPath}/acceso/login">
			<a class="btn btn-ttb020"
				href="${pageContext.request.contextPath}/pages/acceso/login/index.jsp"> <s:text
					name="Ir al Login" />
			</a>
		</s:form>
	</div>

</body>
	</html>
</jsp:root>