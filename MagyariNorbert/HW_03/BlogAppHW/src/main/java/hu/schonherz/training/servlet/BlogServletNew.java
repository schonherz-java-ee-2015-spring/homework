package hu.schonherz.training.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringEscapeUtils;

import hu.schonherz.training.beans.BlogBeans;

public class BlogServletNew extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static List<BlogBeans> lista;

	private static final String NEWBLOG = "newblog";
	private static final String NAME = "name";
	private static final String TITLE = "title";
	int idCount = 0;

	public BlogServletNew() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = (request.getParameter(NAME) != null ? request.getParameter(NAME) : "Blog");
		PrintWriter out = response.getWriter();
		out.append("<h1>Hello " + (name != null ? name : "Blog") + "</h1>");

//		if (lista != null) {
//			for (int i = 0; i < lista.size(); i++) {
//				out.append("<div style='border: solid 1px'>" + lista.get(i).getTitle() + " " + lista.get(i).getId()
//						+ "</br> " + lista.get(i).getEntry() + "</div>");
//				out.append("</br>");
//			}
//		} else {
//			out.append("<div>There is no blog yet</div>");
//		}

		out.append("<form action='BlogServletNew' method='POST'>");
		out.append("<input name='" + NAME + "' type='hidden' value='" + name + "' ></input>");
		out.append("<textarea name='" + TITLE + "'></textarea></br>");
		out.append("<textarea name='" + NEWBLOG + "'></textarea>");
		out.append("<input type='submit' value='Submit'/>");
		out.append("</form>");
		
		out.append(
				"<footer><form action='index.jsp' method='get'><input type='submit' value='Back to homepage' name='Submit' id='frm1_submit'/></form></footer>");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BlogBeans newBlog = new BlogBeans();

		if (lista == null) {
			lista = new ArrayList<BlogBeans>();
		}

		newBlog.setTitle(StringEscapeUtils.escapeHtml(request.getParameter(TITLE)));
		newBlog.setEntry(StringEscapeUtils.escapeHtml(request.getParameter(NEWBLOG)));
		newBlog.setId(idCount);
		idCount++;
		lista.add(newBlog);

		for (BlogBeans listas : lista) {
			System.out.println(listas.getEntry());
		}

		doGet(request, response);
	}

	public static List<BlogBeans> getLista() {
		return lista;
	}

	public void setLista(List<BlogBeans> lista) {
		this.lista = lista;
	}

}
