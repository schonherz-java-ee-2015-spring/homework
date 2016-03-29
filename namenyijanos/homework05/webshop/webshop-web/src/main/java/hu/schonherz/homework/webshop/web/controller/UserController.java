package hu.schonherz.homework.webshop.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hu.schonherz.homework.webshop.service.UserService;
import hu.schonherz.homework.webshop.vo.UserVo;


@Controller
public class UserController {

	@Autowired
	UserService userService;

	
	@RequestMapping(path="/user", method=RequestMethod.GET)
	public String listUsers(Model model){
		
		
		List<UserVo> users = userService.getAllUsers();
		
		model.addAttribute("users", users);
		
		
		return "index";
	}
	
	
	@RequestMapping(path="/newuser", method=RequestMethod.GET)
	public ModelAndView newUser(Model model){
		
		
		return new ModelAndView("index", "user", new UserVo());
	}
	
	
	@RequestMapping(path="/newuser", method=RequestMethod.POST)
	
	public String addNewUser(@ModelAttribute("user") UserVo user, Model model){
				

		userService.addUser(user);
		
		
		return "redirect:/user";
	}
}
