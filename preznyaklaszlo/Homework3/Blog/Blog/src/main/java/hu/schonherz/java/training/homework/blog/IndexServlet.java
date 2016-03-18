package hu.schonherz.java.training.homework.blog;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringEscapeUtils;
//This is the Index servlet

public class IndexServlet extends HttpServlet {

	// In this page will be the links to the blogs and the New Blog button
	// to create a new blog!
	/**
	 * 
	 */
	private static final long serialVersionUID = -7913923065592747698L;

	// A BlogBean to store List objects
	private BlogBean bean;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// ServletContext for application scope
		ServletContext context = request.getSession().getServletContext();
		// Writer to write to the page
		PrintWriter out = response.getWriter();

		// Setting the style of the page
		out.append(
				"<style> body {background-color:rgb(204, 254, 255);} h1 {color:rgb(0, 0, 129);text-align:center;font-size:150%;}</style>");

		out.append("<h1><i>Welcome to my blog!</i></h1><br/>");

		// if there is no blog titles yet
		if (context.getAttribute("titles") == null) {
			// set a new one
			context.setAttribute("titles", new BlogBean());
		}

		bean = (BlogBean) context.getAttribute("titles");

		// New Blog button to create new blog --> NewBlog Servlet
		out.append("<form action='NewBlog' method='GET'>");
		out.append(
				"<input type='submit' style=\"background-color:rgb(234, 254, 255)\" align='left' value = \"Let's write something new\"></input>");
		out.append("</form>");

		out.append("<hr>");

		// If there is at least one title (so there is one blog min.)
		if (bean.getTitles() != null) {
			out.append("<ul>");
			// We go through every blog and create a link to the content with
			// the titles
			for (int i = 0; i < bean.getTitles().size(); i++) {
				out.append("<li>");
				// We use the ids to find the matching content to the title
				out.append("<a href='Details?id=" + bean.getIds().get(i) + "'>");
				out.append(bean.getTitles().get(i));
				out.append("</a>");
				out.append("</li>");

			}
			out.append("</ul>");

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Integer> ids;
		List<String> titles;
		List<String> writings;

		ServletContext context = request.getSession().getServletContext();

		if (context.getAttribute("titles") == null) {
			this.bean = new BlogBean();
		} else {
			this.bean = (BlogBean) context.getAttribute("titles");
		}
		// If there is no blogs yet
		if (this.bean.getTitles() == null) {
			// We create the elements
			ids = new ArrayList<Integer>();
			titles = new ArrayList<String>();
			writings = new ArrayList<String>();
		} else {
			// IF there are some blogs
			// We get the elements in the lists
			ids = this.bean.getIds();
			titles = this.bean.getTitles();
			writings = this.bean.getWritings();
		}

		// add the data to the lists
		ids.add(Integer.parseInt(request.getParameter("id")));
		titles.add(StringEscapeUtils.escapeHtml(request.getParameter("title")));
		writings.add(StringEscapeUtils.escapeHtml(request.getParameter("writing")));

		// Setting the bean object
		this.bean.setIds(ids);
		this.bean.setTitles(titles);
		this.bean.setWritings(writings);

		doGet(request, response);
	}

}
