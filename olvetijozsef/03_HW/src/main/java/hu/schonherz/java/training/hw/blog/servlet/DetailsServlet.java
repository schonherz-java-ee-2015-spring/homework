package hu.schonherz.java.training.hw.blog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.schonherz.java.training.hw.blog.bean.Blog;
import hu.schonherz.java.training.hw.blog.bean.BlogBean;

/**
 * Implements the DetailsServlet.
 * 
 * @author Ölveti József
 * 
 */
public class DetailsServlet extends HttpServlet {
	private static final String BLOGBEAN = "blogbean";
	private static final String INDEXJSP = "index.jsp";
	private static final String ID = "id";
	private static final long serialVersionUID = 1L;
	private BlogBean blogbean;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetailsServlet() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Redirect to "index.jsp". Any POST, any time!
		response.sendRedirect(INDEXJSP);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// No id parameter -> Redirect to "index.jsp".
		if (request.getParameter(ID) == null) {
			response.sendRedirect(INDEXJSP);
		} else {
			// There is id parameter -> try parse to int.
			try {
				int id = Integer.parseInt(request.getParameter(ID));
				// Id parameter is good, get blogbean from ServletContext.
				blogbean = (BlogBean) getServletContext().getAttribute(BLOGBEAN);
				// No blogs, blogbean is null -> redirect to "index.jsp".
				if (blogbean == null) {
					response.sendRedirect(INDEXJSP);
				} else {
					// ID is not used blog id -> return to "index.jsp".
					if ((blogbean.getBlogs().size() - 1) < id) {
						response.sendRedirect(INDEXJSP);
					} else {
						// Get the blog details from blogs list. Copy the Blog.
						Blog blog = blogbean.getBlogs().get(id);
						// Print HTML content.
						PrintWriter out = response.getWriter();
						out.append("<html>");
						out.append("<head>" + "<link rel='stylesheet' href='styles/styles.css'>" + "</head>");
						out.append("<body>");
						out.append("<div id='bcontainer'>");
						out.append("<div class='blogsBig'>");
						out.append("<div class='bloghead'>");
						out.append(blog.getTitle());
						out.append("<span>");
						out.append(blog.getDate());
						out.append("</span>");
						out.append("</div>");
						out.append("<div class='blogbodyBig'>");
						out.append(blog.getContent());
						out.append("</div>");
						out.append("</div>");
						out.append("<form action='details' method='POST'>");
						out.append("<input type='submit' value='Vissza a blogokhoz' name='back'></input>");
						out.append("</form>");
						out.append("</div>");
						out.append("</body");
						out.append("</html>");
					}
				}
			} catch (NumberFormatException nfe) {
				// ID parameter is not int -> NumberFormatException
				// -> Redirect to "index.jsp".
				response.sendRedirect(INDEXJSP);
			}
		}
	}
}
