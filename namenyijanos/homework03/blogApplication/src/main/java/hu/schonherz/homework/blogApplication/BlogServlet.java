package hu.schonherz.homework.blogApplication;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BlogServlet extends HttpServlet {

	/**
	 * 
	 */
	// constants: easier refactoring and readability
	private static final String BLOGS = "blogs";
	private static final String NEWTITLE = "newtitle";
	private static final String NEWTEXT = "newtext";
	private static final String NEWID = "newid";

	private static final long serialVersionUID = 1L;
	private BlogBeans blogBean;

	public BlogServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// open session
		HttpSession session = request.getSession(true);

		// if there is no blog yet we create a new object
		if (session.getAttribute(BLOGS) == null) {
			session.setAttribute(BLOGS, new BlogBeans());
		}
		blogBean = (BlogBeans) session.getAttribute(BLOGS);
		PrintWriter out = response.getWriter();
		// temporary variable to store the Id of the current blog

		int tempID = 0;
		out.append("<h1>Blogs:</h1>");

		if (this.blogBean.getBlogs() != null) {
			// if there is a blog at least we list it/them
			for (Blog blog : blogBean.getBlogs()) {
				tempID = blog.getId();
				out.append("<div style='border: solid 1px;'><a href='PostServlet?id=" + tempID + "'>" + blog.getTitle()
						+ "</a></div>");
			}
		} else {
			out.append("<div>There is no blog yet</div>");
		}
		// increment the tempID to ensure that every blog get a unique Id
		tempID++;

		// scan the parameters for the new blog
		out.append("<h1>Add a new blog</h1>");
		out.append("<form style='border: 1px solid;' action='BlogServlet' method='POST'>");
		out.append("<input type='text' name='" + NEWTITLE + "'></input>");
		out.append("<textarea name='" + NEWTEXT + "'></textarea>");
		out.append("<input name='" + NEWID + "' type='hidden' value='" + tempID + "'></input>");
		out.append("<input type='submit' value='Submit'></input>");
		out.append("</form>");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// create list of blogs
		List<Blog> blogs;
		Blog tempBlog = new Blog();

		HttpSession session = request.getSession(true);
		if (session.getAttribute(BLOGS) == null) {
			this.blogBean = new BlogBeans();
		} else {
			this.blogBean = (BlogBeans) session.getAttribute(BLOGS);
		}

		if (this.blogBean.getBlogs() == null) {
			blogs = new ArrayList<Blog>();
		} else {
			blogs = blogBean.getBlogs();
		}

		tempBlog.setId(Integer.parseInt(request.getParameter(NEWID)));
		tempBlog.setTitle(request.getParameter(NEWTITLE));
		tempBlog.setText(request.getParameter(NEWTEXT));

		blogs.add(tempBlog);
		this.blogBean.setBlogs(blogs);
		session.setAttribute(BLOGS, this.blogBean);

		for (Blog blog : blogBean.getBlogs()) {
			System.out.println(blog.getId());
			System.out.println(blog.getTitle());
			System.out.println(blog.getText());
		}

		doGet(request, response);
	}

}
