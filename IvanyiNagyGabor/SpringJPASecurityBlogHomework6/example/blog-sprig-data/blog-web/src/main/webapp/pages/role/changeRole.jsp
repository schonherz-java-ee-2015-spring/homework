<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- page wont ignore EL expression ${ expression } -->
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<%
	out.println("ID: ");
	String select[] = request.getParameterValues("id");
	if (select != null && select.length != 0) {
		out.println("You have selected: ");
		for (int i = 0; i < select.length; i++) {
			out.println(select[i]);
		}
	}

	out.println("Name: ");
	select = request.getParameterValues("name");
	if (select != null && select.length != 0) {
		out.println("You have selected: ");
		for (int i = 0; i < select.length; i++) {
			out.println(select[i]);
		}
	}
%>




<template:template>
	<jsp:attribute name="customHead">
   
		
<script src="//cdn.ckeditor.com/4.5.7/standard/ckeditor.js"></script>
    </jsp:attribute>
	<jsp:attribute name="header">
        <h1 class="page-header"> Blog <small>Create new blog</small>
		</h1>
    </jsp:attribute>
	<jsp:body>
	 
<%-- 	 <c:if test="${not empty msg}"> --%>
	 
<!-- 	 <div class="alert alert-success"> -->
<%--  		 <strong>${msg}</strong> ${msg} --%>
<!-- 	</div> -->

<!-- 			<script> -->
<!-- // 				setTimeout(function() { -->
<%-- // 					window.location.href = '<c:url value="/index.jsp" />'; --%>
<!-- // 				}, 5000); -->
<!-- 			</script> -->
			
			
			

<%-- 		</c:if> --%>
		
		
		





<%-- <c:set var="myVar" value=""/> --%>
<%-- <c:forEach items="${myParams.items}" var="currentItem" varStatus="stat"> --%>
<%--   <c:set var="myVar" value="${myVar}${currentItem}" /> --%>
<%-- </c:forEach> --%>



   <h2>Names:</h2>
   <c:forEach items="${userList}" var="user">
   <c:set var="roleIds" value="" />
      <form ACTION="${pageContext.request.contextPath}/changeRole"
				method="POST">
	<h3>
					<c:out value="${user.userName}" />:</h3>
	<c:forEach items="${user.roles}" var="role">
	<c:set var="roleIds" value="${roleIds}${role.id}" />
	  </c:forEach>
<%-- 	  ${roleIds} --%>
	  
	  <c:choose>
	  <c:when test="${fn:contains(roleIds, 1)}">
	  	<input type="checkbox" name="isUserRole" value="1" checked="checked"> ROLE_USER<br>
	 	<input type="hidden" name="userName" value="${user.userName}">
	  </c:when>
	  <c:otherwise>
	  <input type="checkbox" name="isUserRole" value="1"> ROLE_USER<br>
	 	<input type="hidden" name="userName" value="${user.userName}">
	  </c:otherwise>
	  </c:choose>
	  
	   <c:choose>
	  <c:when test="${fn:contains(roleIds, 2)}">
	  	<input type="checkbox" name="isBloggerRole" value="2" checked="checked"> ROLE_BLOGGER<br>
	 	<input type="hidden" name="userName" value="${user.userName}">
	  </c:when>
	  <c:otherwise>
	  <input type="checkbox" name="isBloggerRole" value="2"> ROLE_BLOGGER<br>
	 	<input type="hidden" name="userName" value="${user.userName}">
	  </c:otherwise>
	  </c:choose>
	  
	  
	   <c:choose>
	  <c:when test="${fn:contains(roleIds, 3)}">
	  	<input type="checkbox" name="isAdminRole" value="3" checked="checked"> ROLE_ADMIN<br>
	 	<input type="hidden" name="userName" value="${user.userName}">
	  </c:when>
	  <c:otherwise>
	  <input type="checkbox" name="isAdminRole" value="3"> ROLE_ADMIN<br>
	 	<input type="hidden" name="userName" value="${user.userName}">
	  </c:otherwise>
	  </c:choose>
	  	   		 <input type="submit" value="Save"> 

   </form>
   </c:forEach>
 		
	</jsp:body>
</template:template>


