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
	private String id = "0";

	public BlogApplicationNewBlog() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.append("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'><title>NewBlog</title><body style='background-color:activecaption;'>");
		out.append("<h2> Here you can make your own blog</h2>");
		//Getting the name and the entry of a blog in two text area
		out.append("<form action='BlogApplicationNewBlog' method='POST'>");
		out.append("<textarea rows='1' cols='50' name='" + NAME + "'>" + "</textarea><br>");
		out.append("<textarea rows='20' cols='100' name='" + NEWTEXT + "'>" + "</textarea><br>");
		out.append("<input type='submit'>" + "</input><br></br>");
		out.append("</form>");
		//The return button
		out.append(
				"<footer><form action='index.jsp' method='get'><input type='submit' value='Back to homepage' name='Submit' id='frm1_submit'/></form></footer>");
	}
		
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Adding the new blog to the bean
		List<Blogs> blogs;
		if (BlogBeans.getBlogs() == null) {
			blogs = new ArrayList<Blogs>();
		} else {
			blogs = BlogBeans.getBlogs();
		}
		Blogs blog = new Blogs();
		id = Integer.toString(Integer.parseInt(id)+1);
		blog.ID = id;
		blog.name = StringEscapeUtils.escapeHtml(request.getParameter(NAME));
		blog.text = StringEscapeUtils.escapeHtml(request.getParameter(NEWTEXT));
		blogs.add(blog);
		BlogBeans.setBlogs(blogs);	
		
		doGet(request, response);
	}

}
