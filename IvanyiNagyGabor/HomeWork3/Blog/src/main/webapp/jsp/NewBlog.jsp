<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>You have a chance to create a new blog</title>
</head>
<body>

	<center>
		<h1>Welcome on the creating site!</h1>
	</center>

	<!-- Create a new blog -->
	<form action="../CreateBlogServlet" method="post" id="blogForm">
		<h3>
			Title: <input type="text" name="title" size="40">
			<p>
				Note:
				<textarea rows="5" cols="50" name="content"></textarea>
			<p>
				<input type="submit" value="Post">
		</h3>
	</form>


</body>
</html>