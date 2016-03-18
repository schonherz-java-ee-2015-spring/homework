<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	final String NEWBLOGTITLE = "newblogtitle";
	final String NEWBLOGTEXT = "newblogtext";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create new blogpost!</title>
</head>
<body bgcolor="#404040" link="#FBB266" vlink="#CC6600" alink="#FFFF00">
	<font face="courier new" color="#FF8000">
		<h1 align="center">
			Create a new blogpost!
			</h2>
			<hr>
			<!-- This form POSTs a NEWBLOGTITLE and NEWBLOGTEXT, which is then added to our list of blogs -->
			<form action='../index.jsp' method='POST'>
				<h3>
					Title:<input name="<%=NEWBLOGTITLE%>"></input>
				</h3>
				<h3>Text:</h3>
				<textarea rows="4" cols="50" name="<%=NEWBLOGTEXT%>"></textarea>
				<input type='submit' value='Submit' />
			</form>
			<hr>
			<a href="../index.jsp">Back to index...</a>
	</font>
</body>
</html>