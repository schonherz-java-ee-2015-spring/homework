package hu.schonerz.java.training.hw5.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// Instead of welcome file
@Controller
public class IndexController {

	// When a HTTP GET request comes in the / path
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String index(Model model){
		// immediately returns to index.jsp
		return "index";
	}
}
