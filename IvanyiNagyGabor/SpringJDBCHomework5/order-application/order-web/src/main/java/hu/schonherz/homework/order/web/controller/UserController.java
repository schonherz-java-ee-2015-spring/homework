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

//
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(path = "/userDetails", method = RequestMethod.GET)
	public String listUsers(Model model) {
		List<UserVo> list;
		try {
			list = userService.getAllUser();
			model.addAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "user/userDetails";
	}

	@RequestMapping(path = "/create", method = RequestMethod.GET)
	public ModelAndView newBlog(Model model) {
		return new ModelAndView("/user/create", "command", new UserVo());
	}

	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public String newBlog(@ModelAttribute UserVo userVo, Model model) {
		try {
			userService.addUser(userVo);
		} catch (Exception e) {
			
			return "redirect:/user/create/?msg=error";
		}
		return "redirect:/";
	}

}
