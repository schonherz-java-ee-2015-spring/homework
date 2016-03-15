package hu.schonherz.java.training.hw.blog.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringEscapeUtils;

import hu.schonherz.java.training.hw.blog.bean.Blog;
import hu.schonherz.java.training.hw.blog.bean.BlogBean;

/**
 * Servlet implementation class NewBlogServlet
 * 
 * @author Ölveti József
 * 
 */
public class NewBlogServlet extends HttpServlet {
	private static final String INDEXJSP = "index.jsp";
	private static final String BACK = "back";
	private static final String SEND = "send";
	private static final String BLOGBEAN = "blogbean";
	private static final String BLOGCONTENT = "blogcontent";
	private static final String BLOGTITLE = "blogtitle";
	private static final long serialVersionUID = 1L;
	private BlogBean blogBean;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewBlogServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Print the HTML content with form.
		PrintWriter out = response.getWriter();
		out.append("<html>");
		out.append("<head>" + "<link rel='stylesheet' href='styles/styles.css'>" + "</head>");
		out.append("<body>");
		out.append("<div class='styled'>");
		out.append("<form action='newblog' method='POST'>");
		out.append("<input autofocus placeholder='Blog címe' type='text' name='" + BLOGTITLE + "'></input><br/>");
		out.append("<textarea placeholder='Ide írd a blog tartalmát!' name='" + BLOGCONTENT + "'></textarea><br/>");
		out.append("<input type='submit' value='Vissza a blogokhoz' name='" + BACK + "'></input>");
		out.append("<input type='submit' value='Blog beküldése' name='" + SEND + "'></input>");
		out.append("</form>");
		out.append("</div>");
		out.append("</body");
		out.append("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Back parameter not null -> Redirect to the blogs(index.jsp).
		if (request.getParameter(BACK) != null) {
			response.sendRedirect(INDEXJSP);
		} else {
			// Get parameters string.
			String blogTitle = request.getParameter(BLOGTITLE);
			String blogContent = request.getParameter(BLOGCONTENT);
			String send = request.getParameter(SEND);
			// Validate parameters.
			// Not null -> good, Not Empty -> good, else wrong!
			if (blogTitle != null && blogContent != null && send != null) {
				if (blogTitle != "" && blogContent != "") {
					// Everything is ok.
					// Get current blogbean from ServletContext.
					this.blogBean = (BlogBean) this.getServletContext().getAttribute(BLOGBEAN);
					// No blogbean - > Create new bean.
					if (this.blogBean == null) {
						this.blogBean = new BlogBean();
					}
					// Get blogs from bean. No blogs -> create new blog list.
					List<Blog> blogs = this.blogBean.getBlogs();
					if (blogs == null) {
						blogs = new ArrayList<Blog>();
					}
					// Add new blog to the list at the first place,
					// id = the biggest next id.
					// Store date as a String. It's easier.
					DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					blogs.add(0,
							new Blog(blogs.size(), StringEscapeUtils.escapeHtml(blogTitle),
							StringEscapeUtils.escapeHtml(blogContent),
							dateFormat.format(new Date(System.currentTimeMillis()))));
					// Set new blog list to the bean.
					blogBean.setBlogs(blogs);
					// Add blogbean to ServletContext.
					this.getServletContext().setAttribute(BLOGBEAN, this.blogBean);
				}
			}
			// Reload page for new blog posting.
			doGet(request, response);
		}
	}

}
