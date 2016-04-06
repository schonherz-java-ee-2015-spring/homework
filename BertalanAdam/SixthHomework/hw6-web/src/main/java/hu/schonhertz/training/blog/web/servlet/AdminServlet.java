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

/**
 * Servlet implementation class AdminServlet
 */
// THE WHOLE FILE ADMIN PART
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<UserVo> userVos = null;
		try {
			userVos = userService.getAllUsers();
			// végigmegyünk minden felhasználón
			for (UserVo userVo : userVos) {
				// uj role lista
				List<RoleVo> roles = new ArrayList<>();
				
				// lekérjük a felhasználó id-ját és megnézzük hogy kapott-e user jogot
				String actual_id = request.getParameter( userVo.getId() +"u");
				
				if( !(actual_id == null) ){
					// ha kapott, akkor 
					RoleVo role = new RoleVo();
					role.setId(1L);
					role.setName("ROLE_USER");
					roles.add(role);
				}
				
				// lekérjük hogy az adott felhasználó kapott-e blogger jogot
				actual_id = request.getParameter( userVo.getId() +"b");
				
				if( !(actual_id == null) ){
					// ha kapott, akkor 
					RoleVo role = new RoleVo();
					role.setId(2L);
					role.setName("ROLE_BLOGGER");
					roles.add(role);
				}
				
				// lekérjük hogy az adott felhasználó kapott-e admin jogot
				actual_id = request.getParameter( userVo.getId() +"a");
				
				if( !(actual_id == null) ){
					// ha kapott, akkor 
					RoleVo role = new RoleVo();
					role.setId(3L);
					role.setName("ROLE_ADMIN");
					roles.add(role);
				}
				
				System.out.println("USER: " + userVo.getId() + " ROLES: " + userVo.getRoles());
				
				userService.setUpRoles(userVo, roles);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("/pages/blogs.jsp").forward(request, response);
	}

}
