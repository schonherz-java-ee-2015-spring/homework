<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<template:template>

	<jsp:attribute name="customHead">
<script src="${pageContext.request.contextPath}/resources/js/admin.js"></script>
</jsp:attribute>

	<jsp:attribute name="header">
        <h1 class="page-header"> Blog
        <small>Admin</small>
		</h1>
    </jsp:attribute>

	<jsp:body>
		<div id="theDiv">
			<form action="<c:url value="/admin" />" method="POST">
				<c:forEach items="${users}" var="user">
					<div>
						<p>${user.userName} 
					User<input id="${user.id}u" type="checkbox" value="" />
					Blogger<input id="${user.id}b" type="checkbox" value="" />
					Admin<input id="${user.id}a" type="checkbox" value="" />
						</p>
					</div>
				</c:forEach>
				<input type="Submit" value="Save" />
			</form>
		</div>
	</jsp:body>

</template:template>