package hu.schonhertz.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("*")
public class HelloController{
 
  @RequestMapping(method = RequestMethod.GET)
  public String printHello(ModelMap model) {
    return "hello/hello";
  }

}
