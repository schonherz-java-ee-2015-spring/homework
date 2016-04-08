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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.google.gson.Gson;

import hu.schonhertz.training.blog.service.UserService;
import hu.schonhertz.training.blog.vo.RoleVo;
import hu.schonhertz.training.blog.vo.UserVo;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -2436053024210292582L;

	public AdminServlet() {
		super();
	}
	
	@Autowired
	UserService userService;
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("postconstruct has run.");
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<UserVo> userVos = null;
		
		try {
			userVos = userService.getAllUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("users", userVos);
		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_OK);
		
		Gson gson = new Gson();
		gson.toJson(userVos, response.getWriter());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<UserVo> userVos = null;
		try {
			userVos = userService.getAllUsers();
			for (UserVo userVo : userVos) {
				List<RoleVo> roles = new ArrayList<>();
				
				String idLocal = request.getParameter(userVo.getId() + "u");
				if (!(idLocal == null)) {
					RoleVo role = new RoleVo();
					role.setId(1L);
					role.setName("ROLE_USER");
					roles.add(role);
				}
				
				idLocal = request.getParameter(userVo.getId() + "b");
				if (!(idLocal == null)) {
					RoleVo role = new RoleVo();
					role.setId(2L);
					role.setName("ROLE_BLOGGER");
					roles.add(role);
				}
				
				idLocal = request.getParameter(userVo.getId() + "a");
				if (!(idLocal == null)) {
					RoleVo role = new RoleVo();
					role.setId(3L);
					role.setName("ROLE_ADMIN");
					roles.add(role);
				}
				
				System.out.println("User: " + userVo.getId() + ", roles: " + userVo.getRoles());
				
				userService.setUpRoles(userVo, roles);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/pages/blogs.jsp").forward(request, response);
	}
	
}
