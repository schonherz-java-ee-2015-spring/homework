package hu.schonherz.homework.webshop.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hu.schonherz.homework.webshop.service.OrderService;
import hu.schonherz.homework.webshop.service.ProductService;
import hu.schonherz.homework.webshop.service.UserService;
import hu.schonherz.homework.webshop.vo.OrderVo;
import hu.schonherz.homework.webshop.vo.ProductVo;
import hu.schonherz.homework.webshop.vo.UserVo;


@Controller
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	ProductService productService;
	
	
	@RequestMapping(path="/neworder", method=RequestMethod.GET)
	public ModelAndView addOrder(Model model) {
		
		List<UserVo> users = userService.getAllUsers();

		List<ProductVo> products = productService.getAllProducts();

		model.addAttribute("users_", users);
		model.addAttribute("products_", products);
	
		return new ModelAndView("index", "order", new OrderVo());
	}
	
	
	@RequestMapping(path="/neworder", method=RequestMethod.POST)
	
	public String addNewOrder(@ModelAttribute("order") OrderVo order, Model model){
	
		
		orderService.addOrder(order.getUserId(), order.getProductId());
		
		return "redirect:/user";
	}
}
