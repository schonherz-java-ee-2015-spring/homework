package hu.schonherz.homework.order.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hu.schonherz.homework.order.service.UserService;
import hu.schonherz.homework.order.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(path = "/userDetails", method = RequestMethod.GET)
	public String listUsers(Model model) {
		try {
			List<UserVo> userList = userService.getAllUser();
			model.addAttribute("userList", userList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "user/userDetails";
	}

	@RequestMapping(path = "/createUser", method = RequestMethod.GET)
	public ModelAndView newBlog(Model model) {
		return new ModelAndView("/user/createUser", "command", new UserVo());
	}

	@RequestMapping(path = "/createUser", method = RequestMethod.POST)
	public String newBlog(@ModelAttribute UserVo userVo, Model model) {
		try {
			userService.addUser(userVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}

}
