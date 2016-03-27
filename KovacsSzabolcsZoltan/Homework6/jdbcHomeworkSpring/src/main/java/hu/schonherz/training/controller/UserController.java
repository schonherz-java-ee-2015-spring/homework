package hu.schonherz.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hu.schonherz.training.jdbcTemplate.UserJDBCTemplate;
import hu.schonherz.training.pojo.User;

@Controller
@RequestMapping("home/users")
public class UserController {

	@Autowired
	private UserJDBCTemplate userJDBCTemplate;

	@RequestMapping(method = RequestMethod.GET)
	public String listUsers(Model model) {
		List<User> users = userJDBCTemplate.getAllUser();
		model.addAttribute("users", users);
		return "home/user";
	}
	@RequestMapping(path = "/createUser", method = RequestMethod.GET)
	public ModelAndView newUser(Model model) {
		return new ModelAndView("home/createUser", "command", new User());
	}

	@RequestMapping(path = "/createUser", method = RequestMethod.POST)
	public String newUser(@ModelAttribute User user, Model model) {
		int count = user.getName().isEmpty() ? 0 : 1;
		if (count == 0) {
			model.addAttribute("count", count);
			return "redirect:/home/users/createUser";
		}
		
		userJDBCTemplate.createUser(user.getName());
		return "redirect:/home/users";
	}
}

