<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>Shop WebApp</title>
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
					<sec:authorize access="hasRole('USER')">
						<li><a href="${pageContext.request.contextPath}/order"
							accesskey="4" title="">Orders</a></li>
					</sec:authorize>
					<li class="current_page_item"><a
						href="${pageContext.request.contextPath}/login" accesskey="5"
						title="">Login</a></li>
				</ul>
			</div>
		</div>
	</div>

	<div id="wrapper">
		<div id="featured-wrapper">
			<div id="featured" class="container">
				<div>
					<form method="post"
						action="${pageContext.request.contextPath}/login">
						<c:if test="${param.error}">
							<span class="error">Hibás felhasználónév vagy jelszó!</span>
						</c:if>
						<table>
							<tr>
								<td><label>Login</label></td>
								<td><input type="text" name="j_username" /></td>
							</tr>
							<tr>
								<td><label>Password</label></td>
								<td><input type="password" name="j_password" /></td>
							</tr>
							<tr>
								<td><label>Remember Me:</label></td>
								<td><input type="checkbox" name="remember-me" /></td>
							</tr>
							<tr>
								<td></td>
								<td colspan="1"><input type="submit" class="button"
									value="Login!" /></td>
							</tr>
						</table>
					</form>
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
