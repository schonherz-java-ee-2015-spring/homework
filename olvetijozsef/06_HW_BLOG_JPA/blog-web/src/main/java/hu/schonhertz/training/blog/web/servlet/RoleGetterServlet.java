package hu.schonhertz.training.blog.web.servlet;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.google.gson.Gson;

import hu.schonhertz.training.blog.service.UserService;
import hu.schonhertz.training.blog.vo.UserVo;

@WebServlet("/roleGetter")
public class RoleGetterServlet extends HttpServlet {
	static final Logger logger = LogManager.getLogger(RoleGetterServlet.class.getName());

	private static final long serialVersionUID = 1795959081410371020L;

	@Autowired
	UserService userService;

	@PostConstruct
	public void postConstruct() {
		System.out.println("postconstruct has run.");
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		
		String userName = request.getParameter("userName");
		UserVo user = null;
		try {
			user = userService.findUserByName(userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setContentType("application/json");
		resp.setStatus(HttpServletResponse.SC_OK);
		Gson gson = new Gson();
		gson.toJson(user.getRoles(), resp.getWriter());
	}
}
