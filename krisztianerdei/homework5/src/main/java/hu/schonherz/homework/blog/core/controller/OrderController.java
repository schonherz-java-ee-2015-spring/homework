package hu.schonherz.homework.blog.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hu.schonherz.homework.blog.core.entitiy.Order;
import hu.schonherz.homework.blog.core.repository.impl.OrderJDBCTemplate;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderJDBCTemplate orderJDBCTemplate;

	@RequestMapping(path = "/create", method = RequestMethod.GET)
	public ModelAndView newBlog(Model model) {
		return new ModelAndView("order/create", "command", new Order());
	}

	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public String newUser(@ModelAttribute Order order, Model model) {
		orderJDBCTemplate.addOrder(order.getUser_id(), order.getProduct_id());
		return "redirect:/product";
	}

}
