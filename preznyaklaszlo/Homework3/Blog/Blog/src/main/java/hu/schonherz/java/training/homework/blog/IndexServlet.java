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

public class IndexServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7913923065592747698L;

	private BlogBean bean;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServletContext context = request.getSession().getServletContext();
		PrintWriter out = response.getWriter();

		out.append("<h1 style=\"color:blue;font-size:150%;text-align:center;\">Welcome to my blog!</h1><br/>");

		if (context.getAttribute("titles") == null) {

			context.setAttribute("titles", new BlogBean());
		}

		bean = (BlogBean) context.getAttribute("titles");
		out.append("<h1 style =\"color:blue;\">");
		out.append("<form action='NewBlog' method='GET'>");
		out.append("<input type='submit' align='left' value = \"Let's write something new\"></input>");
		out.append("</form>");
		out.append("</h1>");

		out.append("<hr>");

		if (bean.getTitles() != null) {
			out.append("<ul>");

			for (int i = 0; i < bean.getTitles().size(); i++) {
				out.append("<li>");
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

		if (this.bean.getTitles() == null) {
			ids = new ArrayList<Integer>();
			titles = new ArrayList<String>();
			writings = new ArrayList<String>();
		} else {
			ids = this.bean.getIds();
			titles = this.bean.getTitles();
			writings = this.bean.getWritings();
		}

		// comments.add(StringEscapeUtils.escapeHtml(request.getParameter(NEWCOMMENT)));
		ids.add(Integer.parseInt(request.getParameter("id")));
		titles.add(StringEscapeUtils.escapeHtml(request.getParameter("title")));
		writings.add(StringEscapeUtils.escapeHtml(request.getParameter("writing")));

		this.bean.setIds(ids);
		this.bean.setTitles(titles);
		this.bean.setWritings(writings);

		doGet(request, response);
	}

}
