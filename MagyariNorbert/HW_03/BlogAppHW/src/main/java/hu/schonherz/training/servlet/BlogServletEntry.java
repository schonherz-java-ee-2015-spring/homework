package hu.schonherz.training.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.schonherz.training.beans.BlogBeans;

public class BlogServletEntry extends HttpServlet {
	
	private static List<BlogBeans> lista;
	int thisId;
	String thisName;

	public BlogServletEntry() {
		super();
		}

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		thisId = Integer.parseInt((request.getParameter("id")));
		thisName = request.getParameter("name");
		lista = BlogServletNew.getLista();
		
		if (lista != null) {
				out.append("<title>Details</title>");
				out.append("<h1><center>" + lista.get(thisId).getTitle() + "</center></h1></br>");
				out.append("<div>" + lista.get(thisId).getEntry() + "</div>");
//				out.append("<div style='border: solid 1px'>" + lista.get(thisId).getTitle() + " " + lista.get(thisId).getId()+ "</br> "
//						+ lista.get(thisId).getEntry() + "</div>");
				out.append("</br>");
		} else {	out.append("<div><center>There is no blog yet</center></div>");	}
		out.append(
				"<footer><form action='index.jsp' method='get'><input type='submit' value='Vissza a fooldalra' name='Submit' id='frm1_submit'/></form></footer>");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	
}
