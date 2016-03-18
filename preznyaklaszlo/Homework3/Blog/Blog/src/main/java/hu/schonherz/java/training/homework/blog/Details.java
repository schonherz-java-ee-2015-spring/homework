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
		bean = (BlogBean) context.getAttribute("titles");
		for (int i = 0; i < this.bean.getIds().size(); i++) {
			if (this.bean.getIds().get(i).equals(Integer.parseInt(request.getParameter("id")))) {
				out.append("<h2 style=\"color:green\">Blog title: " + this.bean.getTitles().get(i) + "</h2><br/>");
				out.append("<h3 style=\"color:blue\">Story: " + this.bean.getWritings().get(i) + "</h3><br/>");

			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
