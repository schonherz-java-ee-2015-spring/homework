package hu.schonhertz.training.blog.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

import hu.schonhertz.training.blog.service.RoleService;
import hu.schonhertz.training.blog.service.UserService;
import hu.schonhertz.training.blog.vo.RoleVo;
import hu.schonhertz.training.blog.vo.UserNameVo;
import hu.schonhertz.training.blog.vo.UserVo;

@WebServlet("/manageUser")
public class ManageUserServlet extends HttpServlet {
	static final Logger logger = LogManager.getLogger(ManageUserServlet.class.getName());

	private static final long serialVersionUID = 1795959081410371020L;

	@Autowired
	UserService userService;

	@Autowired
	RoleService roleService;

	@PostConstruct
	public void postConstruct() {
		System.out.println("postconstruct has run.");
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<UserNameVo> users = null;
		try {
			users = userService.getAllUserName();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		request.getSession().setAttribute("userNames", users);
		request.getSession().setAttribute("msg", "Success");
		request.getRequestDispatcher("/pages/admin/manageUsers.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userSelect");
		String roleAdmin = request.getParameter("roleAdmin");
		String roleUser = request.getParameter("roleUser");
		String roleBlogger = request.getParameter("roleBlogger");
		
		UserVo userVO = null;
		List<RoleVo> userRoles = new ArrayList<>();
		try {
			userVO = userService.findUserByName(userName);
			if (userVO != null) {
				if (roleAdmin != null) {
					userRoles.add(roleService.getRoleByName("ROLE_ADMIN"));
				}
				if (roleUser != null) {
					userRoles.add(roleService.getRoleByName("ROLE_USER"));
				}
				if (roleBlogger != null) {
					userRoles.add(roleService.getRoleByName("ROLE_BLOGGER"));
				}

				roleService.removeAllRoles(userVO.getId());
				for (RoleVo roleVo : userRoles) {
					roleService.addRoles(roleVo.getId(), userVO.getId());
				}
				request.setAttribute("msg", "Success");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/pages/admin/manageUsers.jsp").forward(request, response);
	}
}
