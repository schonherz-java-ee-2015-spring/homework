<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form method="POST" action="create">

				<form:select path="user_id">
					<c:forEach var="user" items="${users}">
						<form:option value="${user.id}"> ${user.name} 
           </form:option>
					</c:forEach>
				</form:select>

				<form:select path="product_id">
					<c:forEach var="product" items="${products}">
						<form:option value="${product.id}"> ${product.name} 
           </form:option>
					</c:forEach>
				</form:select>
				<tr>
					<td><input type="submit" value="Create Order"></td>
				</tr>
	</form:form>




</body>

</html>