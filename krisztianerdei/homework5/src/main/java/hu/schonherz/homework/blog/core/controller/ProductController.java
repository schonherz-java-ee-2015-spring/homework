package hu.schonherz.homework.blog.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hu.schonherz.homework.blog.core.entitiy.User;
import hu.schonherz.homework.blog.core.repository.impl.UserJDBCTemplate;

@Controller
@RequestMapping("/Product")
public class ProductController {

	@Autowired
	private UserJDBCTemplate userJDBCTemplate;

	@RequestMapping(method = RequestMethod.GET)
	public String listBlogs(Model model) {
		List<User> users = userJDBCTemplate.getAllUser();
		model.addAttribute("users", users);
		return "user/userindex";
	}

	@RequestMapping(path = "/create", method = RequestMethod.GET)
	public ModelAndView newBlog(Model model) {
		return new ModelAndView("user/create", "command", new User());
	}

	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public String newUser(@ModelAttribute User user, Model model) {
		userJDBCTemplate.addUser(user.getName());
		return "redirect:/user";
	}

}
