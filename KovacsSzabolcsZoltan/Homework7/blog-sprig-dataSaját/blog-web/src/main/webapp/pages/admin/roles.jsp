<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<template:template>

	<jsp:body>
<%-- 	<jsp:attribute name="customHead"> --%>
		
		<form action="${pageContext.request.contextPath}/roles" method="GET"
				enctype="form-data">
		<table >
		
		<c:forEach items="${users }" var="name">
			<tr>
			<td width="200px">${name }</td>
			<td>
				Admin <input type="checkbox" value="Admin" name="Admin" id="admin">
				User <input type="checkbox" value="User" name="User" id="user">
				Blogger <input type="checkbox" value="Blogger" name="Blogger" id="blogger">
			</td>
			</tr>
		</c:forEach>
		
		</table>
		
  <input name="submit" type="submit" class="btn btn-primary" value="Roles" />
</form>
	</jsp:body>
</template:template>


