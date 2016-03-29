package hu.schonerz.java.training.hw5.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hu.schonerz.java.training.hw5.service.OrderService;
import hu.schonerz.java.training.hw5.service.ProductService;
import hu.schonerz.java.training.hw5.service.UserService;
import hu.schonerz.java.training.hw5.vo.OrderVo;
import hu.schonerz.java.training.hw5.vo.ProductVo;
import hu.schonerz.java.training.hw5.vo.UserVo;

@Controller
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	ProductService productService;
	
	// If a HTTP GET request comes in the /neworder path this method will run.
	@RequestMapping(path="/neworder", method=RequestMethod.GET)
	public ModelAndView addOrder(Model model){
		
		// Get all the users
		List<UserVo> users = userService.getAllUsers();
		// And get all the products
		List<ProductVo> products = productService.getAllProducts();
		
		// add the two lists to the Model as an attribute.
		model.addAttribute("users_", users);
		model.addAttribute("products_", products);
		
		// Returns with a new OrderVo object called "order" to the index.jsp
		return new ModelAndView("index", "order", new OrderVo());
	}
	
	//	If a HTTP POST request comes in the /neworder path this method will run.
	@RequestMapping(path="/neworder", method=RequestMethod.POST)
	// Comes with a model Attribute called "order"
	public String addNewOrder(@ModelAttribute("order") OrderVo order, Model model){
	
		// add the new order to the database
		orderService.addOrder(order.getUser_id(), order.getProduct_id());
		
		return "redirect:/user";
	}
}
