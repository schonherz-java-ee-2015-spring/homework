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
 *
 */
public class CreateBlogServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Call the doPost method
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	/**
	 * Try to create blog and if it is succesful then make it
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		new BlogServiceImpl().createBlog(new Blog(0L, title, content));

		request.getRequestDispatcher("GetAllBlogServlet").forward(request, response);

	}

}
