<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<template:template>
	<jsp:attribute name="customHead">
   
		 <script
			src="${pageContext.request.contextPath}/resources/js/users.js"></script>
<script src="//cdn.ckeditor.com/4.5.7/standard/ckeditor.js"></script>
    </jsp:attribute>
	<jsp:attribute name="header">
        <h1 class="page-header"> Admin <small>Manage Users</small>
		</h1>
    </jsp:attribute>
	<jsp:body>
		
<form action="${pageContext.request.contextPath}/manageUser"
			method="post">
		
		 <div class="form-group">
				<label for="title">User</label>
				
				<select id="userSelect" name="userSelect" onchange="userRoleSetter();">
				<option value="-1">SELECT USER</option>
				<c:forEach items="${userNames}" var="user">
				<option value="${user.userName}">${user.userName}</option>
   					</c:forEach>
				</select><br />
				<div id="roles">
					<input type="checkbox" id="c2" name="roleAdmin" /> ADMIN
					<input type="checkbox" id="c1" name="roleUser" /> USER
					<input type="checkbox" id="c3" name="roleBlogger" /> BLOGGER
				</div>
		</div>		
						
  <input name="submit" type="submit" class="btn btn-primary"
				value="Set Role" />


</form>
	</jsp:body>
</template:template>


