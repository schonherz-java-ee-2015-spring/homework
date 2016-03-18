<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="hu.schonherz.homework3.beans.BlogBean"%>
<%@ page import="hu.schonherz.homework3.blog.Blog"%>
<%@ page isELIgnored="false"%>
<%
	final String BLOGS = "blogs";
	// We can reference the homepage's blogBean, since we added it to an attribute of the current session
	BlogBean blogBean = (BlogBean) session.getAttribute(BLOGS);
	Blog currentBlog;
	// If something goes wrong with the requesting (bad indexing, etc.), instead of an actual blogpost,
	// we get an errorpost
	try {
		currentBlog = blogBean.getBlogs().get(Integer.parseInt(request.getParameter("id")));
	} catch (Exception e) {
		currentBlog = new Blog();
		currentBlog.setTitle("Oops, something went wrong!");
		currentBlog.setText(
				"I can't find the blogpost you are looking for. Maybe something went wrong with the indexing?");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%=currentBlog.getTitle()%></title>
</head>
<body bgcolor="#404040" link="#FBB266" vlink="#CC6600" alink="#FFFF00">
	<font face="courier new" color="#FF8000">
		<div style="border: solid 1px; background-color: #303030">
			<h1 align="center"><%=currentBlog.getTitle()%></h1>
		</div>
		<div>
			<%=currentBlog.getText()%>
		</div>
		<hr> <a href="../index.jsp">Back to index...</a>
	</font>
</body>
</html>