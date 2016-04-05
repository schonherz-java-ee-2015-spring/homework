package hu.schonherz.homework.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hu.schonherz.homework.service.interf.ServiceInterf;
import hu.schonherz.homework.service.vo.UserVo;

@Controller
public class UserController {

	@Autowired
	private ServiceInterf<UserVo> userServiceImpl;

	@RequestMapping(path = "/user", method = RequestMethod.GET)
	public String loadUserPage(Model model) {
		List<UserVo> users = userServiceImpl.getAllVos();
		model.addAttribute("users", users);
		return "user/index";
	}

	@RequestMapping(path = "/adduser", method = RequestMethod.GET)
	public ModelAndView newUser(Model model) {
		return new ModelAndView("user/adduser", "user", new UserVo());
	}

	@RequestMapping(path = "/adduser", method = RequestMethod.POST)
	public String newUser(@ModelAttribute UserVo user, Model model) {
		userServiceImpl.addVo(user);
		return "redirect:/user";
	}
}
