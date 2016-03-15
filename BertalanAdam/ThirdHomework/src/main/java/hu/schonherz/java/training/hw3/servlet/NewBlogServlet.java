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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewBlogServlet() {
        super();
    }

    /*
     * When the user is here, that means he or she want to create a new post.
     * There will be two textfields, one for the post name, and one for the content.
     * There will also be a post button that will send the input, and the new blog post
     * will appear on IndexServlet
     * */
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		// Create the input page.
		out.append("<form action='IndexServlet' method='POST'>");
			out.append("Name: <input type='text' name='name'></input><br></br>");
			out.append("Content: <textarea name='content' width='50' height='50'></textarea><br></br>");
			out.append("<input type='submit' value='Done'></input>");
		out.append("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
