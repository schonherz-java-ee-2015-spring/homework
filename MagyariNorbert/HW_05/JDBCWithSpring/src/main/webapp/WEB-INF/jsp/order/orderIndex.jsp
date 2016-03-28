<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${orders}" var="order">
	<ul>
		<a href="order/details/${order.user_id}">
			<li>User id: ${order.user_id}	Product id: ${order.product_id }</li>
			
		</a>	
	</ul>
</c:forEach>

<footer>
<a href="/JDBCWithSpring/order/create">
   <input type="button" value="Create" />
</a>
<a href="/JDBCWithSpring/order/delete">
   <input type="button" value="Delete" />
</a>

<a href="/JDBCWithSpring/">
   <input type="button" value="Home" />
</a>

</footer>
</body>
</html>