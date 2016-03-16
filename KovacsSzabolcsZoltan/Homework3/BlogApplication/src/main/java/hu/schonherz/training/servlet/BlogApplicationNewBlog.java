package hu.schonherz.training.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringEscapeUtils;

import hu.schonherz.training.beans.BlogBeans;
import hu.schonherz.training.beans.Blogs;

public class BlogApplicationNewBlog extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String NEWTEXT = "newtext";
	private static final String NAME = "name";
	private static final String ID = "id";
	
	private BlogBeans adattag;
	
	private List<Blogs> blogBeans = BlogBeans.getBlogs();
	public int id = (Integer) ((blogBeans.size() != 0) ? blogBeans.get(blogBeans.size()-1).ID : 0);
	
	public BlogApplicationNewBlog() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		id++;
		PrintWriter out = response.getWriter();
		out.append("<h1> Here you can make your own blog</h1>");

		out.append("<form action='BlogApplicationNewBlog' method='POST'>");
		out.append("<input name='" + ID + "' type='hidden' value='" + id + "'></input>");
		out.append("<textarea rows='1' cols='50' name='" + NAME + "'>" + "</textarea>");
		out.append("<input type='submit'>" + "</input");
		out.append("<textarea rows='20' cols='100' name='" + NEWTEXT + "'>" + "</textarea>");
		out.append("<input type='submit'>" + "</input");
		out.append("</form>");
		
	}
		
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Blogs> blogs;
		
		if (this.blogBeans.isEmpty()) {
			blogs = new ArrayList<Blogs>();
		} else {
			blogs = BlogBeans.getBlogs();
		}
		
		Blogs blog = null;
		blog.ID = request.getParameter(ID);
		blog.name = StringEscapeUtils.escapeHtml(request.getParameter(NAME));
		blog.text = StringEscapeUtils.escapeHtml(request.getParameter(NEWTEXT));
		blogs.add(blog);
		
		adattag.setBlogs(blogs);
		
		
		doPost(request, response);
	}

}
