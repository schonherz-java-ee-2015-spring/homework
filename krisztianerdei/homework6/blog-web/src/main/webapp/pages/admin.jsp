<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<template:template>
	<jsp:attribute name="customHead">
     <script src="${pageContext.request.contextPath}/resources/js/blog.js"></script>
    </jsp:attribute>
	<jsp:attribute name="header">
        <h1 class="page-header"> Admin <small> page</small>
		</h1>
    </jsp:attribute>
	<jsp:body>
	 
 <div id="blogs" class="text_padding"></div>
 
 <sec:authorize access="hasRole('ADMIN')">
 
 <h1>valami</h1>
 
</sec:authorize>

	</jsp:body>
</template:template>


