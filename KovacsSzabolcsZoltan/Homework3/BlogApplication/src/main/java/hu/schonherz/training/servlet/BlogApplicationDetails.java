package hu.schonherz.training.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
//		out.append("<h3> ID =" + id + "</h3>");

		if (BlogBeans.getBlogs() == null) {
			out.append("<h1>Don't have any blogs yet!</h1>");
			blogBeans = new ArrayList<Blogs>();
		} else {

			int count = 0;
			for (Blogs blogs : blogBeans) {
//				out.append("<h3>*" + blogs + "*</h3>");

				if (blogs.ID.equals(id)) {
					break;
				} else {
					count++;
				}

			}
//			for (Blogs blogs : blogBeans) {
//				out.append("<div>**" + blogs + "**</div>");
//			}

//			out.append("<h2>BASZÁÁÁÁS</h2>");
		

		out.append("<h1>" + name + "-" + id + "</h1>");
		out.append("<div>" + blogBeans.get(count).text.replace("\n", "<br>") + "</div>");
		out.append(
				"<footer><form action='index.jsp' method='get'><input type='submit' value='Back to homepage' name='Submit' id='frm1_submit'/></form></footer>");
//		out.append("<form action='BlogApplicationDetails' method='POST'>");
//		out.append("<input name='" + ID + "' type='hidden' value='" + id + "'></input>");
//		out.append("<input name='" + NAME + "' type='hidden' value='" + name + "'></input>");
//		out.append("<input type='submit'>" + "</input");
//		out.append("</form>");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		Blogs blogTest = new Blogs("1", "Katsa", "Teszt szöveg ehhez a retkes bloghoz!");
//		blogBeans.add(blogTest);
//		BlogBeans.setBlogs(blogBeans);

		doGet(request, response);

	}

}
