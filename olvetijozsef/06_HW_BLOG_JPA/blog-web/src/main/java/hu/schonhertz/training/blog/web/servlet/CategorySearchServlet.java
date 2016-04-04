package hu.schonhertz.training.blog.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.google.gson.Gson;

import hu.schonhertz.training.blog.service.CategoryService;

@WebServlet("/categorySearch")
public class CategorySearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	CategoryService categoryService;

	@PostConstruct
	public void postConstruct() {
		System.out.println("postconstruct has run.");
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json");
		try {
			String term = request.getParameter("term");
			List<String> list = categoryService.getAllCategoryName(term);
			String searchList = new Gson().toJson(list);
			response.getWriter().write(searchList);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		List<String> categories = categoryService.getAllCategoryName();
		request.getSession().setAttribute("categories", categories);
	}

}
