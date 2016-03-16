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

	// private field of the BlogBean object.
	private BlogBean blogbean;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetailsServlet() {
		super();
	}
	/*
	 * When the user is in this page, that means he or she clicked on a blog name, and want
	 * to see the content of that blog.
	 * */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Get the writer of the response to write to this page.
		PrintWriter out = response.getWriter();
		out.append("<link type='text/css' rel='stylesheet' href='style.css'></link>");

		// For application scope use ServletContext
		ServletContext context = request.getSession().getServletContext();

		// if the application hasn't got a blogNames attribute,
		if (context.getAttribute("blogNames") == null) {
			// set a new attribute with blogNames and with a new BlogBean object
			context.setAttribute("blogNames", new BlogBean());
		}

		// One way or another, here we have a BlogBean object (a new one or the existing one with already some data in it)
		// so store that object locally here in blogbean.
		blogbean = (BlogBean) context.getAttribute("blogNames");

		// Go through every blog in the object
		// it does not matter which field we use here for iterate, they all have the same size.
		for (int i = 0; i < blogbean.getIds().size(); i++) {
			// if there is a blog which id is equal with the id we got as a parameter,
			if( blogbean.getIds().get(i) == Integer.parseInt(request.getParameter("id")) ){
				// then write the blog data out.
				out.append("<div>BLOG NAME: <br></br><div class='blog'>" + blogbean.getBlogNames().get(i) + "</div></div>");
				out.append("<br></br>");
				out.append("<div>BLOG CONTENT: <br></br><div class='blog'>"+ blogbean.getBlogContents().get(i) + "</div></div>"); 
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
