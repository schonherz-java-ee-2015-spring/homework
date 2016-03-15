package hu.schonherz.java.training.hw3.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.schonherz.java.training.hw3.beans.BlogBean;

/**
 * Servlet implementation class DetailsServlet
 */
public class DetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BlogBean blogbean;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetailsServlet() {
		super();
	}
	/*
	 * When the user is here, that means he or she clicked on a blog name, and want
	 * to see the content of that blog.
	 * */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();

		ServletContext context = request.getSession().getServletContext();

		if (context.getAttribute("blogNames") == null) {
			context.setAttribute("blogNames", new BlogBean());
		}

		blogbean = (BlogBean) context.getAttribute("blogNames");

		for (int i = 0; i < blogbean.getIds().size(); i++) {
			if( blogbean.getIds().get(i) == Integer.parseInt(request.getParameter("id")) ){
				out.append("<div>BLOG NAME: <br></br>" + blogbean.getBlogNames().get(i) + "</div>");
				out.append("<br></br>");
				out.append("<div>BLOG CONTENT: <br></br>"+ blogbean.getBlogContents().get(i) + "</div>"); 
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
