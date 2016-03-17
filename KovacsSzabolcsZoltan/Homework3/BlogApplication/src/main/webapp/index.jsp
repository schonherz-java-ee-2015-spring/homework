<%@page import="java.io.PrintWriter"%>
<%@page import="org.apache.taglibs.standard.tag.common.core.ForEachSupport"%>
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
	class="hu.schonherz.training.beans.BlogBeans" scope="application">
	<%-- 	<jsp:setProperty name="blogBeans" property="blogs" value="<%= new Blogs("1", "Katsa", "Teszt sz�veg ehhez a retkes bloghoz!") %>" /> --%>
</jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	final String NEWTEXT = "newtext";
	final String NAME = "name";
	final String ID = "id";

	// 	List<Blogs> blogs = blogBeans.getBlogs();
	// 	Blogs blogTest = new Blogs("1", "Katsa", "Teszt sz�veg ehhez a retkes bloghoz!");
	// 	blogs.add(blogTest);
	// 	blogBeans.setBlogs(blogs);
	List<Blogs> blogs = blogBeans.getBlogs();
// 	if (blogs == null) {
// 		blogs = new ArrayList<Blogs>();
// 	}
	
%>

<html>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Homepage</title>
<body style="background-color:activecaption;">
	<h1 align="center"><font style=" color:green; ; font: small-caps;">Adventure time!</font></h1>
	<p>
		Blogs:<br>
		<%if (blogs == null) {%>
		<h3>You don't have blogs yet!</h3><%
		}%>

		<%if (blogs == null) {
			blogs = new ArrayList<Blogs>();
		} else {
			%><ul><%
			for (Blogs blog : blogs) {
				%><li><a href="BlogApplicationDetails?name=<%=blog.name%>&id=<%=blog.ID%>"><%=blog.name%></a></li><%}}%>
		</ul>

	</p>
	<footer><form action='BlogApplicationNewBlog' method='get'><input type='submit' value='Create a new blog' name='Submit' id='frm1_submit'/></form></footer>
</body>
</html>
