package hu.schonherz.homework.headswitcher.blog;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.schonherz.homework.headswitcher.blog.beans.BlogPostBean;

/**
 * Servlet implementation class Index
 */
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private List<BlogPostBean> Postok;
	// private BlogPostBean Post;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Index() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//CLASS NEEDS NAME REFACTOR
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		//Textares and buttons to get the blog conent to the "RealIndex" page
		out.append("<form action='RealIndex' method='POST'>");
		out.append("<input name='" + "name" + "' type='hidden' value='" + "name" + "' ></input>");
		out.append("<h2 align=center>Title</h2>");

		out.append("<p align='center'>");
		out.append("<textarea rows='1' cols='40' name='" + "title" + "' ></textarea></br>");
		out.append("</p>");

		out.append("<h3 align=center>Content</h3>");

		out.append("<p align=center>");
		out.append("<textarea rows='8' cols='100' name='" + "content" + "'></textarea></br>");
		out.append("</p>");

		out.append("<p align=center>");
		out.append("<input type='submit' value='Submit'/>");
		out.append("</p>");

		out.append("</form>");

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		if (Postok == null)
//			this.Postok = new ArrayList<>();
//
//		BlogPostBean blog = new BlogPostBean(request.getParameter("title"), request.getParameter("content"));
//		Postok.add(blog);
		doGet(request, response);
	}

}
