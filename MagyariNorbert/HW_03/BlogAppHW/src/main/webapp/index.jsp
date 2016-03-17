<%@page import="hu.schonherz.training.beans.BlogBeans"%>
<%@page import="hu.schonherz.training.servlet.BlogServletNew"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<!-- Use JSTL tags, and those will be access via 'c' (like c:out) -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- page wont ignore EL expression ${ expression } -->
<%@ page isELIgnored="false" %>

<jsp:useBean id="title" class="hu.schonherz.training.beans.BlogBeans" scope="application"></jsp:useBean>

<%
List<BlogBeans> blogok = BlogServletNew.getLista();	%>

<html>
<body>
<h2><center>Blogolda</center></h2>

<div style="margin-bottom: 30px">
		<h2>Blogok:</h2>

		<!-- if there are no blogs -->
		<%if (blogok == null) {
			blogok = new ArrayList<BlogBeans>();
			%><h3>Meg nincs egy uj blog sem :(</h3><%
		} else {
			%><ul><%
			for (BlogBeans blog : blogok) { //creating links to the blogs and sending blogs title and id
				%><li><a href="BlogServletEntry?name=<%=blog.getTitle()%>&id=<%=blog.getId()%>"><%=blog.getTitle()%></a></li><%}}%>
		</ul>
		
	
	<a href="BlogServletNew">Keszitek egy uj blogot!</a></br>

	</div>
</body>
</html>
