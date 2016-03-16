package hu.schonherz.training.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.schonherz.training.beans.BlogBeans;
import hu.schonherz.training.beans.Blogs;

public class BlogApplicationDetails extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// private static final String NEWTEXT = "newtext";
	private static final String NAME = "name";
	private static final String ID = "id";

	List<Blogs> blogBeans = BlogBeans.getBlogs();

	public BlogApplicationDetails() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String name = request.getParameter(NAME);
		String id = request.getParameter(ID);

		if (blogBeans.size() == 0) {
			out.append("<h1>Don't have any blogs yet!</h1>");
		} else {

			int count = 0;

			for (Blogs blogs : blogBeans) {
				count++;
				if (blogs.ID.equals(id)) {
					break;
				}
			}

			String text = blogBeans.get(count).text;

			out.append("<h1><b>" + name + "</b></h1>");
			out.append("<div>" + text.replace("\n", "</ br>") + "</div>");
			out.append(
					"<footer><input type='submit' value='Go to my link location' onclick='index.jsp' </input></footer>");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}

}
