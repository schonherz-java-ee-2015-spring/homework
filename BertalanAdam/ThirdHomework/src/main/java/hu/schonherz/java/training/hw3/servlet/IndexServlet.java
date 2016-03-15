package hu.schonherz.java.training.hw3.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringEscapeUtils;

import hu.schonherz.java.training.hw3.beans.BlogBean;

/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static int id = 0;

	/* Here comes the blog names in a list.
	If the user clicks on a blog name, DetailsServlet will be fired
	and the blog loads in details, so the name and the content of the blog.
	There will be a button, "new blog" and that button will take to the
	NewBlogServlet page where the user will be able to add a blog name, and
	the content.
	*/

	private BlogBean blogbean;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexServlet() {
		super();
	}

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

		out.append("<h1>Welcome to the blogs page!</h1>");
		out.append("<br>");

		if (blogbean.getBlogNames() != null) {
			out.append("<ul>");
			for (int i = 0; i < blogbean.getBlogNames().size(); i++) {
				out.append("<li>");
					out.append("<a href='DetailsServlet?id=" + blogbean.getIds().get(i) + "'>");
						out.append(blogbean.getBlogNames().get(i));
					out.append("</a>");
				out.append("</li>");
			}
			out.append("</ul>");
		} else {
			out.append("There is no blog posts yet!");
		}
		
		out.append("<form action='NewBlogServlet'>");
			out.append("<input type='submit' value=\"Create new blog\"></input>");
		out.append("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		List<String> names;
		List<String> contents;
		List<Integer> ids;

		ServletContext context = request.getSession().getServletContext();

		if (context.getAttribute("blogNames") == null) {
			blogbean = new BlogBean();
		} else {
			blogbean = (BlogBean) context.getAttribute("blogNames");
		}

		if (blogbean.getBlogNames() == null) {
			names = new ArrayList<String>();
		} else {
			names = blogbean.getBlogNames();
		}

		names.add(StringEscapeUtils.escapeHtml(request.getParameter("name")));

		if (blogbean.getBlogContents() == null) {
			contents = new ArrayList<String>();
		} else {
			contents = blogbean.getBlogContents();
		}
		
		contents.add(StringEscapeUtils.escapeHtml(request.getParameter("content")));
		
		if( blogbean.getIds() == null ){
			ids = new ArrayList<Integer>();
		} else {
			ids = blogbean.getIds();
		}
		
		ids.add(id++);
		
		blogbean.setBlogNames(names);
		blogbean.setBlogContents(contents);
		blogbean.setIds(ids);
		
		context.setAttribute("blogNames", blogbean);
		context.setAttribute("blogContents", blogbean);
		context.setAttribute("blogIDs", blogbean);
			
		doGet(request, response);
	}

}
