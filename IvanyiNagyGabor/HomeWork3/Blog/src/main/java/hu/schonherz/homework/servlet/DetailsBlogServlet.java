package hu.schonherz.homework.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.schonherz.homework.blog.model.Blog;
import hu.schonherz.homework.blog.service.BlogServiceImpl;

/**
 * @author Iványi-Nagy Gábor
 * NOT USED CLASS!!!!
 */
public class DetailsBlogServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		Blog blog = new BlogServiceImpl().getAllBlogs().get((int) id);
		request.setAttribute("blog", blog);
		
		
	}

}
