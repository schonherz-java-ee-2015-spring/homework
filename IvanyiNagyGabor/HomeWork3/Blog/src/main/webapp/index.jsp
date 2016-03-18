<%@page import="hu.schonherz.homework.blog.model.Blog"%>
<%@page import="hu.schonherz.homework.blog.service.BlogServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- Refresh the site every 5 seconds and set blogs to all blogs -->
<%
	pageContext.setAttribute("blogs", new BlogServiceImpl().getAllBlogs());
	response.setIntHeader("Refresh", 5);
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
</head>


<center>
	<h1>Welcome on main site!</h1>
</center>


<!-- print all titles and link to the details site -->
<form action="jsp/Details.jsp" method="post">
	<c:forEach items="${blogs}" var="blog" varStatus="status">
		<ul>
			<li><h3>
					<a href="jsp/Details.jsp?id=${status.index}"> <c:out
							value="${blog.title}"></c:out>
					</a>
				</h3>
				<p></li>
		</ul>
	</c:forEach>
</form>

<!-- Create a new blog button -->
<form action="jsp/NewBlog.jsp" method="post">
	<input type="submit" value="Create new blog">
</form>


</body>
</html>