package hu.schonherz.training.hw.spring.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hu.schonherz.training.hw.spring.service.UserService;
import hu.schonherz.training.hw.spring.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String listUsers(Model model) {
		List<UserVo> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return "user/user";
	}

	@RequestMapping(path = "/create", method = RequestMethod.GET)
	public ModelAndView newUser(Model model) {
		return new ModelAndView("user/create", "command", new UserVo());
	}

	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public String newUser(@ModelAttribute UserVo user, Model model) {
		userService.addUser(user);
		return "redirect:/user";
	}

}
