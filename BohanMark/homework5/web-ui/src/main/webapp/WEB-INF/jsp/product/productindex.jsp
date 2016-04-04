<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.List"%>
<%@page import="hu.schonherz.training.homework5.pojo.Product"%>

<%
	Gson gson = new Gson();
	List<Product> products = (ArrayList<Product>)request.getAttribute("products");
    gson.toJson(products, response.getWriter());
    out.flush();
%>