package hu.schonherz.homework.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.schonherz.homework.blog.service.BlogServiceImpl;

/**
 * @author Iványi-Nagy Gábor
 *
 */

public class GetAllBlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * call the doPost() method
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}


	/**
	 * Set request attribute to the new blog list and go back to the index page
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("blogs", new BlogServiceImpl().getAllBlogs());
		new BlogServiceImpl().getAllBlogs();
		System.out.println(new BlogServiceImpl().getAllBlogs());
		response.sendRedirect("index.jsp");
	}
	
	
	

}
