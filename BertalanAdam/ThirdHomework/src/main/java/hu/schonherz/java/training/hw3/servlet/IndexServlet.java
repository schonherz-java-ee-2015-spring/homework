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

import org.apache.commons.lang.StringEscapeUtils;

import hu.schonherz.java.training.hw3.beans.BlogBean;

/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/* Here comes the blog names in a list.
	If the user clicks on a blog name, the user will be forwarded to DetailsServlet
	and the blog loads in details, eg. the name and the content of the blog.
	There will be a button, "new blog" and that button will take the user to the
	NewBlogServlet page where the user will be able to add a blog name, and
	the content.
	*/

	// Locally stored BlogBean
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

		// Get the response's writer to write to the page.
		PrintWriter out = response.getWriter();

		// For application scope, use ServletContext.
		ServletContext context = request.getSession().getServletContext();

		// if there is no blogNames attribute in the scope
		if (context.getAttribute("blogNames") == null) {
			// create one and set in the context
			context.setAttribute("blogNames", new BlogBean());
		}

		// One way or another, here we have a BlogBean object (a new one or the existing one with already some data in it)
		// so store that object locally here in blogbean.
		blogbean = (BlogBean) context.getAttribute("blogNames");

		// Create a "new blog" button which will forward the user to the NewBlogServlet page.
		out.append("<table>");
		out.append("<tr>");
		out.append("<td>");
		out.append("<form action='NewBlogServlet'>");
		out.append("<input type='submit' align='center' value=\"Create new blog\"></input>");
		out.append("</form>");
		out.append("</td>");
		out.append("<td>");
		out.append("<h1>Welcome to the blogs page!</h1>");
		out.append("</td>");
		out.append("</tr>");
		out.append("<table>");
		out.append("<br>");
		
		out.append("<hr></hr>");
		
		out.append("<link type='text/css' rel='stylesheet' href='style.css'></link>");

		// if there is any blog, write them into a list.
		if (blogbean.getBlogNames() != null) {
			out.append("<ul>");
			// Go through every blog
			for (int i = 0; i < blogbean.getBlogNames().size(); i++) {
				out.append("<li>");
					// write a link with a parameter which is the blog's ID 
					out.append("<a href='DetailsServlet?id=" + blogbean.getIds().get(i) + "'>");
						// write the name of the blog
						out.append(blogbean.getBlogNames().get(i));
					out.append("</a>");
				out.append("</li>");
			}
			out.append("</ul>");
			// In case there is no blogs yet,
		} else {
			out.append("There is no blog posts yet!");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		PrintWriter out = response.getWriter();

		List<String> names = null;
		List<String> contents = null;
		List<Integer> ids = null;

		// For application scope
		ServletContext context = request.getSession().getServletContext();

		
		if (context.getAttribute("blogNames") == null) {
			blogbean = new BlogBean();
			assert false : "Code mustn't reach this point, since the index page cannot start with a POST method";
		} else {
			blogbean = (BlogBean) context.getAttribute("blogNames");
		}

		// if there is no blogs yet
		if (blogbean.getBlogNames() == null) {
			// If there is no blogNames yet, that means there is no contents and ids either.
			// so create them here all
			names = new ArrayList<String>();
			contents = new ArrayList<String>();
			ids = new ArrayList<Integer>();
		} else {
			// but if there is a blog name, that means there must be a blogContent and a blogId too.
			// so get them all here
			names = blogbean.getBlogNames();
			contents = blogbean.getBlogContents();
			ids = blogbean.getIds();
		}

		// validation
		
		boolean validName = true;
		String inputName = request.getParameter("name");
		if( blogbean.getBlogNames() != null){
			for (String blogName : blogbean.getBlogNames()) {
				if( blogName.equals(inputName)){
					validName = false;
				}
			}			
		}
		
		if( validName ){
			
			// Add the posted data to the list.
			names.add(StringEscapeUtils.escapeHtml(request.getParameter("name")));
			contents.add(StringEscapeUtils.escapeHtml(request.getParameter("content")));
			ids.add(Integer.parseInt(request.getParameter("id")));
			
			// And set them in the object
			blogbean.setBlogNames(names);
			blogbean.setBlogContents(contents);
			blogbean.setIds(ids);
		} else {
			response.sendRedirect("NewBlogServlet?valid=false");
		}

		// No need to set the context again, because the object is already in context, and all we done is set the attributes of the object.
		doGet(request, response);
	}

}
