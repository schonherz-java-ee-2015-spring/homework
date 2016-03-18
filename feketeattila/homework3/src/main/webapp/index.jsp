<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="org.apache.commons.lang.StringEscapeUtils"%>
<%@ page import="hu.schonherz.homework3.blog.Blog"%>
<jsp:useBean id="blogBean" class="hu.schonherz.homework3.beans.BlogBean"
	scope="application" />
<%
	final String NEWBLOGTITLE = "newblogtitle";
	final String NEWBLOGTEXT = "newblogtext";
	final String BLOGS = "blogs";

	final String[] contributors = { "Fekete Attila (Atka)" };
	pageContext.setAttribute("contributors", contributors);
	// We set our blogBean as an attribute of the session, so it can be referenced from other jsps
	session.setAttribute(BLOGS, blogBean);

	// If the page has a parameter with the name NEWBLOGTITLE, it adds a new blog to the current list
	if (request.getParameter(NEWBLOGTITLE) != null) {
		List<Blog> blogs = blogBean.getBlogs();
		if (blogs == null) {
			blogs = new ArrayList<Blog>();
		}
		Blog tempBlog = new Blog();
		tempBlog.setTitle(StringEscapeUtils.escapeHtml(request.getParameter(NEWBLOGTITLE)));
		tempBlog.setText(StringEscapeUtils.escapeHtml(request.getParameter(NEWBLOGTEXT)));
		blogs.add(tempBlog);

		blogBean.setBlogs(blogs);
	}
%>

<html>
<head>
<title>Atka Homework Blog Index</title>
</head>
<body bgcolor="#404040" link="#FBB266" vlink="#CC6600" alink="#FFFF00">
	<font face="courier new" color="#FF8000">
		<h1 align="center">Welcome to my Homework blog, feel free to
			spam!</h1>
		<hr> <a href="jsp/NewBlogJsp.jsp"
		style="border: solid 1px; background-color: #303030"><b>Make a
				new blogpost!</b></a>
		<div>
			<h2>Blogposts:</h2>

			<c:choose>
				<c:when test="${blogBean.getBlogs() == null}">
					<div style="border: solid 1px; background-color: #303030">
						<h4>There are no blogposts yet!</h4>
					</div>
				</c:when>
				<c:otherwise>
					<c:forEach items="${blogBean.getBlogs()}" var="blog"
						varStatus="iterator">
						<div style="border: solid 1px; background-color: #303030">
							<h4>
								<!-- Creates a link for every blog there is at the moment, 
								the link sends you to the Details jsp with an ID as parameter.
								This ID will identify our blog in out Details jsp -->
								<a href="jsp/BlogDetailJsp.jsp?id=${iterator.getCount()-1}">${blog.getTitle()}</a>
							</h4>
						</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
		<hr>
		<div>
			<h3>Contributors:</h3>
			<ul>
				<c:forEach items="${contributors}" var="contributor">
					<li>${contributor}</li>
				</c:forEach>
			</ul>
		</div>
	</font>
</body>
</html>
