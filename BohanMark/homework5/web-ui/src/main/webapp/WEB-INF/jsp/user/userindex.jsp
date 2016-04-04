<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.List"%>
<%@page import="hu.schonherz.training.homework5.pojo.User"%>

<%
	Gson gson = new Gson();
	List<User> users = (ArrayList<User>)request.getAttribute("users");
    gson.toJson(users, response.getWriter());
    out.flush();
%>