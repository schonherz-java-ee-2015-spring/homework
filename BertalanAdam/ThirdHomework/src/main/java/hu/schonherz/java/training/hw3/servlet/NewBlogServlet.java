package hu.schonherz.java.training.hw3.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewBlogServlet
 */
public class NewBlogServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static int id = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewBlogServlet() {
        super();
    }

    /*
     * When the user is in this page, that means he or she want to create a new post.
     * There will be two inputs, one for the post name, and one for the content.
     * There will also be a post button that will store the input, and the new blog post
     * will appear on IndexServlet.
     * */
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Get the response's writer to be able to write to this page.
		PrintWriter out = response.getWriter();

		out.append("<link type='text/css' rel='stylesheet' href='style.css'></link>");
		
		if( request.getParameter("valid") != null && request.getParameter("valid").equals("false")){
			out.append("<h4 style='color:red;'>There is already a blog with this name!</h4>");	
		}
		
		// A form to post data to the IndexServlet page.
		out.append("<form action='IndexServlet' method='POST'>");
			out.append("<div class='name' >Name of the blog: <input id='valami' type='text' name='name'></input>");
			out.append("<input type='submit' value='Done'></input>");
			out.append("</div>");
			out.append("<div class='name' >Content of the blog: <br> <textarea name='content' id='textfield'></textarea></div><br></br>");
			out.append("<input type='hidden' name='id' value='" + id++ + "'>");
		out.append("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
	
		doGet(request, response);
			
		}		
}
