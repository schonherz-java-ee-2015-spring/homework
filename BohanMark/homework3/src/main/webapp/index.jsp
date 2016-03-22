<%@page import="javax.swing.text.StyledEditorKit.ForegroundAction"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<jsp:useBean id="blogsBean"
	class="hu.schonhertz.training.blog.beans.BlogsBean" scope="application" />

<!DOCTYPE html>
<html>
<head>
<title>Blog</title>
</head>
<body>
	<!-- Listing the blogs. -->
	<c:forEach items="${blogsBean.getBlogs()}" var="b">
		<div>
			<a href="details.jsp?id=${b.getId() }" ><c:out value="${b.getName() }"></c:out></a>
		</div>
	</c:forEach>
<div>
<a href="newblog.jsp">new blog</a>
</div>

</body>
</html>
