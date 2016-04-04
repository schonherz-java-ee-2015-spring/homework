package hu.schonherz.homework.blog.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// this is a controller
@Controller
@RequestMapping("/")
public class HelloController{

  @RequestMapping(method = RequestMethod.GET)
  public String gohome(ModelMap model) {
		return "redirect:/user";
		}
}
