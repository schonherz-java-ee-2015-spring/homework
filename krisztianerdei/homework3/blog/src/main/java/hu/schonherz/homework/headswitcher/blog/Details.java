package hu.schonherz.homework.headswitcher.blog;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.schonherz.homework.headswitcher.blog.beans.BlogPostBean;

/**
 * Servlet implementation class Details
 */
public class Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<BlogPostBean> bloglist;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Details() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BlogPostBean post;
		String id;
		PrintWriter out = response.getWriter();
 //from the Reallindex gets the parameter and checks if valid
		if (request.getParameter("id") == "" || request.getParameter("id") == null)
			id = null;
		else
			id = request.getParameter("id");

	//bloglist gets the atrubute blogs 
		ServletContext context = request.getSession().getServletContext();
		if (context.getAttribute("blogs") == null)
			context.setAttribute("blogs", new LinkedList<>());
		bloglist = (List<BlogPostBean>) context.getAttribute("blogs");
		
		//write out
		if (bloglist.isEmpty() == false && id != null) {
			int szamlalkiiras = 0;

			for (BlogPostBean blogPostBean : bloglist) {
				if (blogPostBean.getId() == Integer.parseInt(id)) {
					out.append("<h1>" + blogPostBean.getTitle() + "<h1>");
					out.append("<h3>" + blogPostBean.getContent() + "<h3>");
					szamlalkiiras++;
				}
			}
			if (szamlalkiiras == 0) {
				out.append("<h1>Nincs ilyen ID-val rendelkezo blog<h1>");
			}

		} else
			out.append("<h1>Üres a blogod, vagy nem adtál meg ID<h1>");

		out.append("<form action='RealIndex'>");
		out.append("<input type='submit' value='INDEX'></input>");
		out.append("</form>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
