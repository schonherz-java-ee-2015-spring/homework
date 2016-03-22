<%@page import="hu.schonhertz.training.blog.Blog"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<jsp:useBean id="blogsBean"
	class="hu.schonhertz.training.blog.beans.BlogsBean" scope="application" />

<%


	/**
	 * Requires an 'id' parameter, which gives the id of a blog.
	 * If it's not found, or invalid, site redirects to index.jsp,
	 * otherwise shows the data.
 	 */
	Blog blog = null;
	try{
		blog = blogsBean.findBlog(Integer.parseInt(request.getParameter("id")));
	}catch(java.lang.NumberFormatException | java.util.NoSuchElementException e){

		response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", "index.jsp");
	}
	
	String blogname = blog == null ? "" : blog.getName();
	String blogtext = blog == null ? "" : blog.getText(); 
%>




<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Blog:</title>
</head>
<body>
<a href="index.jsp">index</a><br />
<h1>
<%= blogname %>
</h1>
<div>
<%= blogtext %>
</div>
</body>
</html>