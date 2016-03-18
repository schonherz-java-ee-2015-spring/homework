package hu.schonherz.java.training.homework.blog;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Details extends HttpServlet {

	private BlogBean bean;
	/**
	 * 
	 */
	private static final long serialVersionUID = 5917694750927785165L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext context = request.getSession().getServletContext();
		PrintWriter out = response.getWriter();
		out.append(
				"<style> body {background-color:rgb(204, 254, 255);} h1 {color:rgb(0, 0, 129);text-align:center;font-size:150%;} pre {color:rgb(0, 0, 129)}</style>");

		bean = (BlogBean) context.getAttribute("titles");
		for (int i = 0; i < this.bean.getIds().size(); i++) {
			if (this.bean.getIds().get(i).equals(Integer.parseInt(request.getParameter("id")))) {
				out.append("<h1>Title: " + this.bean.getTitles().get(i) + "</h1><br/>");
				out.append("<hr><hr>");
				out.append("<h1>Story: </h1><br/><pre>" + this.bean.getWritings().get(i) + "</pre><br/>");

			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
