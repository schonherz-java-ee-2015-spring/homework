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
	final String NAME = "name";
	final String TEXT = "text";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>new blog</title>
</head>
<body>
		<%
			//if the form was submitted, we create a new blog, and redirect to index
			if(request.getParameter(NAME) != null){
				List<Blog> blogs = blogsBean.getBlogs();
					blogs.add(new Blog(blogsBean.requestID(), request.getParameter(NAME), 
							request.getParameter(TEXT)));
				blogsBean.setBlogs(blogs);
		%>
			<script type="text/javascript">window.location = "index.jsp"</script>
			<%} %>
	<form method="post">
		<div>
			name: <input type="text" name="<%= NAME %>" />
		</div>
		<div>
			text:
			<div>
				<textarea rows="25" cols="100" name="<%= TEXT %>"></textarea>
			</div>
		</div>
		<div>
			<input type="submit"/>
		</div>
	</form>
</body>
</html>