<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="hu.schonherz.training.beans.Blogs"%>
<%@page import="org.apache.commons.lang.StringEscapeUtils"%>
<%@page import="javax.swing.text.StyledEditorKit.ForegroundAction"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<jsp:useBean id="blogBeans"
	class="hu.schonherz.training.beans.BlogBeans" scope="application"></jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	final String NEWTEXT = "newtext";
	final String NAME = "name";
	final String ID = "id";

	if (request.getParameter(NEWTEXT) != null) {
		List<Blogs> blogs = blogBeans.getBlogs();
		if (blogs == null) {
			blogs = new ArrayList<Blogs>();
		}
		Blogs blog = null;
		blog.ID = request.getParameter(ID);
		blog.name = StringEscapeUtils.escapeHtml(request.getParameter(NAME));
		blog.text = StringEscapeUtils.escapeHtml(request.getParameter(NEWTEXT));
		blogs.add(blog);

		blogBeans.setBlogs(blogs);
	}
%>

<html>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<body style="background-color: aqua;">
	<h2>Hello World!</h2>
	<div>
		Blogs:<br></br>

		<c:choose>
			<c:when test="${blogBeans.getBlogs() == null}">
				There is no blog yet!<br></br>
			</c:when>
			<c:otherwise>
				<c:forEach items="${blogBeans.comments }" var="comment">
					<div style="border: solid 1px">${comment}</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</div>




	<a href="BlogApplicationNewBlog">BlogApplicationNewBlog<br></a>
	<a href="BlogApplicationDetails">BlogApplicationDetails</a>
</body>
</html>
