<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="hu.schonherz.java.training.hw.blog.bean.BlogBean"%>
<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="blogBean"
	class="hu.schonherz.java.training.hw.blog.bean.BlogBean"
	scope="application"></jsp:useBean>
<%
	// 	Get global blogBean from ServletContext and add to the page context.
	blogBean = (BlogBean) this.getServletContext().getAttribute("blogbean");
	pageContext.setAttribute("blogBean", blogBean);
%>
<html>
<head>
<!-- Load Styles -->
<link rel='stylesheet' href='styles/styles.css' />
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
</head>
<body>
	<!-- The blogs container. -->
	<div id="bcontainer">
		<!-- Create form for submit. -->
		<form action="newblog" method="GET">
			<input type="submit" value="Blog készítése">
		</form>
		<!-- There are available blogs -> print all in <div></div> tags. -->
		<c:if test="${blogBean.getBlogs() != null}">
			<c:forEach items="${blogBean.getBlogs()}" var="blog">
				<div class="blogs">
					<div class="bloghead">
						<a href="details?id=${blog.getId()}">${blog.getTitle()}</a> <span>${blog.getDate()}</span>
					</div>
				</div>
			</c:forEach>
		</c:if>
		<!-- No blogs -> no blogs. :) -->
		<c:if test="${blogBean.getBlogs() == null}">
			<div class="blogs">
				<div class="bloghead">Nem találhatóak blogok!</div>
			</div>
		</c:if>
	</div>
</body>
</html>
