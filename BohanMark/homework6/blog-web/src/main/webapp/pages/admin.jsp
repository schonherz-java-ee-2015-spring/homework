<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<template:template>
	<jsp:attribute name="customHead">
	<script src="${pageContext.request.contextPath}/resources/js/admin.js"></script>
	</jsp:attribute>
	<jsp:attribute name="header">
        <h1 class="page-header"> Blog <small> Administration</small>
		</h1>
    </jsp:attribute>
	<jsp:body>

</head>
<body>
	<div id="userList" class="container-fluid">
		<div class="row">
		<div class="col-md-6">username</div>
		<div class="col-md-1">
			user
		</div>
		<div class="col-md-1">
			blogger
		</div>
		<div class="col-md-1">
			admin
		</div>
		</div>
	</div>

	
	</jsp:body>
</template:template>