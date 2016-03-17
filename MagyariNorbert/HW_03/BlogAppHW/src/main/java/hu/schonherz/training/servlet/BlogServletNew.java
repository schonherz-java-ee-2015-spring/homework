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
		out.append("<title>NewBlog</title>");
		out.append("<h1><center>Uj blog hozzaadasa:</center></h1>");
		//out.append("<h1>Hello " + (name != null ? name : "Blog") + "</h1>");

		out.append("<form action='BlogServletNew' method='POST'>");
		out.append("<input name='" + NAME + "' type='hidden' value='" + name + "' ></input>");
		out.append("<h4>A blog cime:</h2>");
		out.append("<textarea rows='1' cols='20' name='" + TITLE + "' ></textarea></br>");
		out.append("<h4>A blog tartalma:</h2>");
		out.append("<textarea rows='8' cols='100' name='" + NEWBLOG + "'></textarea></br>");
		out.append("<input type='submit' value='Submit'/>");
		out.append("</form>");
		
		out.append(
				"<footer><form action='index.jsp' method='get'><input type='submit' value='Vissza a fooldalra' name='Submit' id='frm1_submit'/></form></footer>");

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


}
