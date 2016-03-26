<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
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
					<li class="current_page_item"><a
						href="${pageContext.request.contextPath}/" accesskey="1" title="">Homepage</a></li>
					<sec:authorize access="hasRole('ADMIN')">
						<li><a href="${pageContext.request.contextPath}/user"
							accesskey="2" title="">Users</a></li>
					</sec:authorize>
					<li><a href="${pageContext.request.contextPath}/product"
						accesskey="3" title="">Products</a></li>
					<sec:authorize access="hasRole('ADMIN')">
						<li><a href="${pageContext.request.contextPath}/order"
							accesskey="4" title="">Orders</a></li>
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
	<div id="header-featured"></div>

	<div id="wrapper">
		<div id="featured-wrapper">
			<div id="featured" class="container">
				<div class="column1">
					<span class="icon icon-cogs"></span>
					<div class="title">
						<h2>Good Support</h2>
					</div>
					<p>If you have a question related to products or orders placed
						in our web shop, please call us at the the shop support phone
						number.</p>
				</div>
				<div class="column2">
					<span class="icon icon-legal"></span>
					<div class="title">
						<h2>Speed Delivery</h2>
					</div>
					<p>Your parcel will be delivered the next day before 8 pm. We
						will deliver 7 days a week, except Bank Holidays.</p>
				</div>
				<div class="column3">
					<span class="icon icon-unlock"></span>
					<div class="title">
						<h2>Extreme Discretion</h2>
					</div>
					<p>Discretion is of extreme importance in the world. It goes
						without saying, the same level of discretion is offered to
						clients.</p>
				</div>
				<div class="column4">
					<span class="icon icon-wrench"></span>
					<div class="title">
						<h2>Lifetime Guarantee</h2>
					</div>
					<p>So, if your duck ever breaks down, simply return it to our
						warranty center. We'll fix it or if we can't, we'll replace it or
						refund it.</p>
				</div>
			</div>
		</div>
		<div id="extra" class="container">
			<h2>Don't quack like a duck, soar like an eagle.</h2>
			<span>Don't quack like a duck, soar like an eagle.</span>

		</div>
	</div>

	<div id="copyright" class="container">
		<p>
			&copy; Duck Shop. All rights reserved. | Design by <a
				href="http://templated.co" rel="nofollow">TEMPLATED</a>.
		</p>
	</div>
</body>
</html>
