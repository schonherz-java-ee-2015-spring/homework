package hu.schonherz.homework.blogApplication;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PostServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String BLOGS = "blogs";
	private BlogBeans blogBean;

	public PostServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);

		if (session.getAttribute(BLOGS) == null) {
			session.setAttribute(BLOGS, new BlogBeans());
		}

		blogBean = (BlogBeans) session.getAttribute(BLOGS);
		out.append("<a href='BlogServlet'>Back to blog list</a>");

		if (this.blogBean.getBlogs() != null) {
			for (Blog blog : blogBean.getBlogs()) {
				if (blog.getId() == Integer.parseInt(request.getParameter("id"))) {
					out.append("<div style='border: 1px solid;'><h1>" + blog.getTitle() + "</h1></div>");
					out.append("<div style='border: 1px solid;'><p>" + blog.getText() + "</p></div>");
				}
			}
		} else {

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
