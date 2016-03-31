
package hu.schonhertz.training.blog.web.servlet;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
import hu.schonhertz.training.blog.vo.UserVo;

@WebServlet(name = "/changeRole", urlPatterns = "/changeRole")
@MultipartConfig
public class ChangeRoleServlet extends HttpServlet {
	 static final Logger logger =
	 LogManager.getLogger(ChangeRoleServlet.class.getName());

	private static final long serialVersionUID = 1795959081410371020L;
	private List<RoleVo> allRoleList;
	private List<UserVo> userList;
	

	@Autowired
	RoleService roleService;

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

		String userName = request.getParameter("userName");
		System.out.println(userName);
		System.out.println("User role: " + (request.getParameter("isUserRole") != null));
		System.out.println("Blogger role: " + (request.getParameter("isBloggerRole") != null));
		
		

		Map<RoleVo, Boolean> isRoles = new LinkedHashMap<RoleVo, Boolean>();
		isRoles.put(allRoleList.get(0), request.getParameter("isUserRole") != null);
		isRoles.put(allRoleList.get(1), request.getParameter("isBloggerRole") != null);
		isRoles.put(allRoleList.get(2), request.getParameter("isAdminRole") != null);

		List<RoleVo> roles = isRoles.entrySet().stream().filter(map -> map.getValue()).map(map -> map.getKey()).collect(Collectors.toList());
		UserVo userVo = userList.stream().filter(user -> user.getUserName().equals(userName)).findFirst().get();
		
		userVo.setRoles(roles);
		System.out.println("Role users: " + userVo.getRoles());
		

		
		// List<UserVo> userList = null;
		 try {
			 roleService.removeAllRoleByUserId(userVo.getId());
			 userService.changeRolesToUser(userVo);
		 } catch (Exception e) {
		 logger.error(e.getMessage(), e);
		 }

		request.setAttribute("userList", userList);
		request.setAttribute("msg", "Success");
		request.getRequestDispatcher("/pages/role/changeRole.jsp").forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// List<UserVo> userList = null;
		try {
			
			UserVo admin = userService.findUserByName("admin");
			userList = userService.getAllUserBySorted();
			userList.remove(admin);
			allRoleList = admin.getRoles();
		} catch (Exception e) {
			 logger.error(e.getMessage(), e);
		}

		request.setAttribute("userList", userList);
		request.setAttribute("msg", "Success");
		request.getRequestDispatcher("/pages/role/changeRole.jsp").forward(request, response);
	}

}
