package hu.schonherz.java.training.homework.blog;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewBlog extends HttpServlet {

	static int id = 0;
	/**
	 * 
	 */
	private static final long serialVersionUID = -5722602813508133843L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		out.append(
				"<style> body {background-color:rgb(204, 254, 255);} h1 {color:rgb(0, 0, 129);text-align:center;font-size:150%;} div {color:rgb(0, 0, 129); </style>");

		out.append("<h1><i>Be creative!</i></h1>");
		out.append("<form action='IndexServlet' method='POST'>");
		out.append("<div class='name'> Title: <br/><input id='in' type='text' name='title'></input>");
		out.append("<input type='submit' value='Send'></input>");
		out.append("<br/>");
		out.append("<div class='name'> Write your story here: <br/>");
		out.append("<textarea name='writing' rows=\"15\" cols=\"50\" id='textpart'></textarea>");
		out.append("</div>");
		out.append("<input type='hidden' name='id' value='" + id++ + "'>");
		out.append("</form>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}
}
