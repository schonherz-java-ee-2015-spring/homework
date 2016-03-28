package hu.schonerz.java.training.hw5.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hu.schonerz.java.training.hw5.service.UserService;
import hu.schonerz.java.training.hw5.vo.UserVo;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;

	// If a HTTP GET request comes in the /user path this method will run.
	@RequestMapping(path="/user", method=RequestMethod.GET)
	public String listUsers(Model model){
		
		// Get all the users and store them in a list.
		List<UserVo> users = userService.getAllUsers();
		// Add the list object to the Model attribute as "users".
		model.addAttribute("users", users);
		
		// return to the index.jsp
		return "index";
	}
	
	// If a HTTP GET request comes in the /newuser path
	@RequestMapping(path="/newuser", method=RequestMethod.GET)
	public ModelAndView newUser(Model model){
		
		// Returns a Model with an attribute of "user" with a new UserVo object, and
		// returns to the index.jsp
		return new ModelAndView("index", "user", new UserVo());
	}
	
	// If a HTTP POST request comes in the /newuser path
	@RequestMapping(path="/newuser", method=RequestMethod.POST)
	// Comes with a UserVo attribute called "user"
	public String addNewUser(@ModelAttribute("user") UserVo user, Model model){
				
//		System.out.println(user.getName());
		// Add the UserVo to the database (Pass it to the service layer to add it)
		userService.addUser(user);
		
		// Redirects to the /user path to list the users.
		return "redirect:/user";
	}
	
}
