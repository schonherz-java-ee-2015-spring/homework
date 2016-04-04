<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>HomeWork</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link href="resources/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="container">
  <div id="top">
    <h1>JDBC with Spring</h1>
    <div class="search">
      <form method="post" action="#">
        <p>
          <input type="text" name="search" value="demo only" class="search" />
          <input type="submit" value="Search" class="searchSubmit" />
        </p>
      </form>
    </div>
  </div>
  <div id="navcontainer">
    <ul id="navlist">
      <li><a href="/JDBCWithSpring/user">Users</a></li>
      <li><a href="/JDBCWithSpring/product">Products</a></li>
      <li><a href="/JDBCWithSpring/order">Orders</a></li>
    </ul>
  </div>
  <div id="leftnav">
    <h2>More Links</h2>
    <ul id="leftnavmenu">
      <li><a href="#">SNAPP HAPPY</a></li>
      <li><a href="#">OPEN DESIGNS</a></li>
      <li><a href="#">ANDREAS VIKLUND</a></li>
      <li><a href="#">JAMES KOSTER</a></li>
      <li><a href="#"> CSS PLAY</a></li>
      <li><a href="#">LISTAMATIC</a></li>
      <li><a href="#"> LAYOUTGALA</a></li>
      <li><a href="#"> BLUEROBOT</a></li>
    </ul>
    <h2>Archives</h2>
    <ul>
      <li><a href="#">January</a></li>
      <li><a href="#">February</a></li>
      <li><a href="#">March</a></li>
      <li><a href="#">April</a></li>
      <li><a href="#">May</a></li>
    </ul>
    <p class="quote">CSS is a journey, not a destination.</p>
  </div>
  <div id="content">
    <h2>Welcome to <span style="font-weight:bold; color:#b29b35;">Clean Blue</span> Template</h2>
			<c:forEach items="${orders}" var="order">
				<ul>
					<a href="order/details/${order.user_id}">
						<li>User id: ${order.user_id} Product id: ${order.product_id }</li>

					</a>
				</ul>
			</c:forEach>
			<a href="/JDBCWithSpring/order/create"> <input type="button"
				value="Create" />
			</a> <a href="/JDBCWithSpring/order/delete"> <input
				type="button" value="Delete" />
			</a> <a href="/JDBCWithSpring/"> <input type="button"
				value="Home" />
			</a>
			<h2>Previous Article</h2>
			<p>
				<img class="imgleft" src="images/1.png" alt="" />Lorem ipsum dolor
				sit amet, consectetuer adipiscing elit. Morbi quis ligula. Donec
				tortor purus, ornare vel, tincidunt at, lacinia ac, leo. Nunc
				fermentum congue odio. Mauris cursus, pede vitae sagittis luctus,
				dolor felis aliquam arcu, ac pulvinar lacus massa non ipsum.
				Praesent volutpat, felis in consectetuer lobortis, nibh orci nonummy
				quam, nec lobortis tellus purus eget turpis. Vestibulum placerat
				sagittis lorem. Praesent interdum ultricies massa. Morbi dolor. Nunc
				fermentum congue odio. Mauris cursus, pede vitae sagittis luctus,
				dolor felis aliquam arcu, ac pulvinar lacus massa non ipsum.
			</p>
			<p class="post">
				<a href="#" class="readmore">Read more</a> <a href="#"
					class="comments">Comments (3)</a> <span class="date">March
					28, 2007</span>
			</p>
		</div>
  <div id="footer">
    <p><a href="/JDBCWithSpring/">homepage</a> | <a href="#">contact</a> | &copy; 2007 Anyone | Design by <a href="http://www.mitchinson.net"> www.mitchinson.net</a> | Licensed under a <a rel="license" target="_blank" href="http://creativecommons.org/licenses/by/3.0/">Creative Commons Attribution 3.0 License</a></p>
  </div>
</div>
</body>
</html>
