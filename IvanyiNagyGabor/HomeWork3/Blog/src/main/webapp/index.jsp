<%@page import="hu.schonherz.homework.blog.model.Blog"%>
<%@page import="hu.schonherz.homework.blog.service.BlogServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	pageContext.setAttribute("blogs", new BlogServiceImpl().getAllBlogs());
	response.setIntHeader("Refresh", 5);
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
</head>
<body>


	<h2>Welcome</h2>



	<a href="jsp/NewBlog.jsp">New Blog</a>
	<form action="jsp/Details.jsp" method="post">
		<c:forEach items="${blogs}" var="blog" varStatus="status">
			<ul>
				<li><c:out value="${status.index}"></c:out> <a
					href="jsp/Details.jsp?id=${status.index}"> <c:out
							value="${blog.title}"></c:out>
				</a>
					<p></li>
			</ul>
		</c:forEach>
	</form>


</body>
</html>