<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>Duck Shop - Create Order</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link
	href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900"
	rel="stylesheet" />
<spring:url value="/resources/default.css" var="defcss" />
<spring:url value="/resources/fonts.css" var="fontcss" />

<link href="${defcss}" rel="stylesheet" type="text/css" media="all" />
<link href="${fontcss}" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
	<div id="header-wrapper">
		<div id="header" class="container">
			<div id="logo">
				<h1>
					<a href="#">Duck Shop</a>
				</h1>
			</div>
			<div id="menu">
				<ul>
					<li><a href="${pageContext.request.contextPath}/"
						accesskey="1" title="">Homepage</a></li>
					<sec:authorize access="hasRole('ADMIN')">
						<li><a href="${pageContext.request.contextPath}/user"
							accesskey="2" title="">Users</a></li>
					</sec:authorize>
					<li><a href="${pageContext.request.contextPath}/product"
						accesskey="3" title="">Products</a></li>
					<sec:authorize access="hasRole('ADMIN')">
						<li class="current_page_item"><a
							href="${pageContext.request.contextPath}/order" accesskey="4"
							title="">Orders</a></li>
					</sec:authorize>
					<sec:authorize access="isAnonymous()">
						<li><a href="${pageContext.request.contextPath}/login"
							accesskey="5" title="">Login</a></li>
					</sec:authorize>
					<sec:authorize access="isAuthenticated()">
						<li><a href="${pageContext.request.contextPath}/logout"
							accesskey="5" title="">Logout</a></li>
					</sec:authorize>
				</ul>
			</div>
		</div>
	</div>

	<div id="wrapper">
		<div id="featured-wrapper">
			<div id="featured" class="container">
				<div>
					<table>
						<form:form action="create" method="POST">
							<tr>
								<td><label>User:</label></td>
								<td><form:select path="userId">
										<c:forEach var="user" items="${users}">
											<form:option value="${user.id}">${user.name}</form:option>
										</c:forEach>
									</form:select></td>
							</tr>
							<tr>
								<td><label>Product:</label></td>
								<td><form:select path="productId">
										<c:forEach var="product" items="${products}">
											<form:option value="${product.id}">${product.name}</form:option>
										</c:forEach>
									</form:select></td>
							</tr>
							<tr>
								<td></td>
								<td><input type="submit" value="Submit" class="button" /></td>
							</tr>
						</form:form>
					</table>
				</div>
			</div>
		</div>
		<div id="extra" class="container"></div>
	</div>

	<div id="copyright" class="container">
		<p>
			&copy; Duck Shop. All rights reserved. | Design by <a
				href="http://templated.co" rel="nofollow">TEMPLATED</a>.
		</p>
	</div>
</body>
</html>
