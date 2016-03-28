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
<c:forEach items="${users}" var="user">
	<div>
		<a href="user/details/${user.id}">
			${user.name}
		</a>
		
	</div>
</c:forEach>

<footer>
<a href="/JDBCWithSpring/user/create">
   <input type="button" value="Create" />
</a>
<a href="/JDBCWithSpring/user/delete">
   <input type="button" value="Delete" />
</a>

<a href="/JDBCWithSpring/">
   <input type="button" value="Home" />
</a>

</footer>
</body>
</html>