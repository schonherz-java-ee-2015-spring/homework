package hu.schonherz.java.training.jdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hu.schonherz.java.training.jdbc.service.UserService;
import hu.schonherz.java.training.jdbc.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(path = "/userDetails", method = RequestMethod.GET)
	public String listAllUser(Model model) {
		List<UserVo> userVos = userService.getAllUsers();
		model.addAttribute("userVos", userVos);
		return "user/userDetails";
	}

	@RequestMapping(path = "/createUser", method = RequestMethod.GET)
	public ModelAndView newUser(Model model) {
		return new ModelAndView("/user/createUser", "user", new UserVo());
	}

	@RequestMapping(path = "/createUser", method = RequestMethod.POST)
	public String addNewUser(@ModelAttribute("user") UserVo userVo, Model model) {
		userService.addUser(userVo);

		return "redirect:/";
	}

}
