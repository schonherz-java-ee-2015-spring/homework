package hu.schonherz.homework.headswitcher.blog;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.schonherz.homework.headswitcher.blog.beans.BlogPostBean;

/**
 * Servlet implementation class RealIndex
 */
public class RealIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<BlogPostBean> bloglist;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RealIndex() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		BlogPostBean post;
		PrintWriter out = response.getWriter();
//Search textare and button,it will redirect to Details
		out.append("<form action='Details' method='GET'>");
		out.append("<h2></h2>");
		out.append("<textarea rows='1' cols='10' name='" + "id" + "' ></textarea></br>");
		out.append("<input type='submit' value='KERESS'/>");
		out.append("</form>");

//New blog button, it will redirect to Index 
		out.append("<form action='Index'>");
		out.append("<input type='submit' value='NEW'></input>");
		out.append("</form>");

	//Make linked list if needed 	
		ServletContext context = request.getSession().getServletContext();
		if (context.getAttribute("blogs") == null)
			context.setAttribute("blogs", new LinkedList<>());
		// set bloglist via contex for future use;
		bloglist = (List<BlogPostBean>) context.getAttribute("blogs");
		//from the "Index" (witch is the NewBlog) gets the parameters
		post = new BlogPostBean(request.getParameter("title"), request.getParameter("content"));
		bloglist.add(post);
		//Write out
		if (bloglist.isEmpty() == true)
			out.append("<h1>Nincsenek még blogjaid</h1>");
		else {
		
			for (BlogPostBean blogPostBean : bloglist) {
				if (blogPostBean.getTitle() != null) {
					out.append("<table border='1' style='width:100%'>");
					out.append("<tr>");
					out.append("<td>" + blogPostBean.getTitle() + "</td>");
					out.append("<td>" + blogPostBean.getId() + "</td>");
					out.append("</tr>");
					out.append("</table>");
				
				}
			}
		}
//set the atribute for scoope use
		context.setAttribute("blogs", bloglist);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
