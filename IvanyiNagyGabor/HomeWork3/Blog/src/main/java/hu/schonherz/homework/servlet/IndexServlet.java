package hu.schonherz.homework.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.schonherz.homework.blog.model.Blog;

/**
 * @author Iványi-Nagy Gábor
 *
 */
public class IndexServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static List<Blog> blogBeans = new ArrayList<Blog>();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Reading the user input

		if (request.getParameter("title") != null && request.getParameter("content") != null) {
			String title = request.getParameter("title");
			String content = request.getParameter("content");

			if (blogBeans.stream().anyMatch(blog -> blog.getTitle().equalsIgnoreCase(title)) == false) {
				Blog blogBean = new Blog();
				blogBean.setTitle(title);
				blogBean.setContent(content);
				blogBeans.add(blogBean);

				request.setAttribute("blogBeans", blogBeans);

			}
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

}
