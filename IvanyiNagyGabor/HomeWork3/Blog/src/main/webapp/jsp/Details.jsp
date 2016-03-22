<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="hu.schonherz.homework.blog.service.BlogServiceImpl"%>
<%@ page import="hu.schonherz.homework.blog.model.Blog"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	pageContext.setAttribute("blog", request.getAttribute("blog"));
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details</title>
</head>
<body>

	<!-- Read the id from the request and set the blog -->
	<%
		int id = Integer.parseInt(request.getParameter("id"));
		List<Blog> blogs = new BlogServiceImpl().getAllBlogs();
		Blog blog = blogs.get(id);
		pageContext.setAttribute("blog", blog);
	%>

	<center>
		<h1>Welcome on the details site!</h1>
	</center>


	<!-- Print the title and the content -->
	<h2>
		Title:

		<c:out value="${blog.title}"></c:out>
	</h2>
	<h3>
		Content:
		<c:out value="${blog.content}"></c:out>

	</h3>
</body>
</html>