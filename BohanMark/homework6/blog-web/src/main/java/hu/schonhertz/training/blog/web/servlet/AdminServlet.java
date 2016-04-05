package hu.schonhertz.training.blog.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.annotation.PostConstruct;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.google.gson.Gson;

import hu.schonhertz.training.blog.service.UserService;
import hu.schonhertz.training.blog.vo.RoleVo;
import hu.schonhertz.training.blog.vo.UserVo;

/**
 * This servlet handles the message box.
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {

	@Autowired
	private UserService userService;

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(AdminServlet.class);

	@PostConstruct
	public void postConstruct() {
		System.out.println("postconstruct has run.");
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String username = request.getParameter("username");
		if (username == null || username.isEmpty()) {
			List<UserVo> users = userService.getAllUsers();
			Gson gson = new Gson();
			gson.toJson(users, response.getWriter());
		} else {
			String role = request.getParameter("role");

			if (role == null || role.isEmpty()) {
				List<RoleVo> roles = null;
				try {
					roles = userService.setUpRoles(userService.findUserByName(username)).getRoles();
				} catch (Exception e) {
					e.printStackTrace();
				}

				Gson gson = new Gson();
				gson.toJson(roles, response.getWriter());

			}
			try {
				UserVo user = userService.setUpRoles(userService.findUserByName(username));
				List<RoleVo> roles = user.getRoles();
				RoleVo roleVo = new RoleVo();
				roleVo.setName(role);
				ListIterator<RoleVo> iterator = roles.listIterator();
				while (iterator.hasNext()) {
					if (iterator.next().getName() == role) {
						iterator.remove();

						user.setRoles(roles);

						userService.registrationUser(user);

						return;
					}
				}
				roles.add(roleVo);
				user.setRoles(roles);
				userService.registrationUser(user);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

}
