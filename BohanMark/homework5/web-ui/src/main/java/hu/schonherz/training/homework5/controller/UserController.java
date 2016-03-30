package hu.schonherz.training.homework5.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import hu.schonherz.training.homework5.dao.UserJdbcTemplate;
import hu.schonherz.training.homework5.pojo.User;


@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserJdbcTemplate userJdbcTemplate;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserController() {
		super();
	}
	  
	  @RequestMapping(method = RequestMethod.GET)
	  public String listUsers(Model model) {
	    List<User> users = userJdbcTemplate.getAllUsers();
	    model.addAttribute("users", users);
	    return "user/userindex";
	  }
	  @RequestMapping(value = "new/{name}",method = RequestMethod.GET)
	  public String newUser(@PathVariable String name, Model model) {
		User user = new User();
		user.setName(name);
		if(name != null || !name.isEmpty())
			userJdbcTemplate.createUser(user);
	    return "";
	  }
	

	@PostConstruct
	public void postConstruct() {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		/*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/web-ui-servlet.xml");
		context.refresh();
		userJdbcTemplate = (UserJdbcTemplate)context.getBean("userJdbcTemplate");*/
	}

}
