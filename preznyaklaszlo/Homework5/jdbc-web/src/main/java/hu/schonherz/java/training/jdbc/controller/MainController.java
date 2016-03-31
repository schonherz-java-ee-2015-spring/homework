package hu.schonherz.java.training.jdbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/")
public class MainController {

	@RequestMapping(method = RequestMethod.GET)
	public String loadMainPage(Model model) {
		return "main";
	}

}
