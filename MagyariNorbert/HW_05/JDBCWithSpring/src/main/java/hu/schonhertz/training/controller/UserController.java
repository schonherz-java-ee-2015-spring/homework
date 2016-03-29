package hu.schonhertz.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hu.schonhertz.training.jdbctemplate.UserJDBCTemplate;
import hu.schonhertz.training.pojo.User;


@Controller
@RequestMapping("/")
public class UserController {
 
	
  @Autowired
  private UserJDBCTemplate userJDBCTemplate;
  
  
  @RequestMapping(path = "/user",method = RequestMethod.GET)
  public String listBlogs(Model model) {
    List<User> user = userJDBCTemplate.getAllUser();
    model.addAttribute("users", user);
    return "user/userindex";
  }
  
  /*
  @RequestMapping(path = "/details", method = RequestMethod.GET)
  public String blogDetails(@RequestParam(name="id") int id, Model model) {
    Blog blog = blogJDBCTemplate.getBlogById(id);
    model.addAttribute("blog", blog);
    return "blog/details";
  }*/
  
  @RequestMapping(path = "user/details/{id}", method = RequestMethod.GET)
  public String userDetails(@PathVariable Long id, Model model) {
    User user = userJDBCTemplate.getUserById(id);
    model.addAttribute("user", user);
    return "user/details";
  }
  
  @RequestMapping(path = "user/create", method = RequestMethod.GET)
  public ModelAndView newUser(Model model) {
    return new ModelAndView("user/create", "command", new User());
  }
  
  @RequestMapping(path = "user/create", method = RequestMethod.POST)
  public String newUser(@ModelAttribute User user, Model model) {
    userJDBCTemplate.createUser(user.getName(), user.getId());
    return "redirect:/user";
  }
  
  @RequestMapping(path = "user/delete", method = RequestMethod.GET)
  public ModelAndView newUserFordelete(Model model) {
    return new ModelAndView("user/delete", "command", new User());
  }
  
  @RequestMapping(path = "user/delete", method = RequestMethod.POST)
  public String deleteUser(@ModelAttribute User user, Model model) {
    userJDBCTemplate.deleteUser(user.getName());
    return "redirect:/user";
  }
  
}
