package hu.schonherz.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hu.schonherz.training.jdbcTemplate.OrderJDBCTemplate;
import hu.schonherz.training.pojo.Order;
import hu.schonherz.training.pojo.Product;
import hu.schonherz.training.pojo.User;

@Controller
@RequestMapping("home/orders")
public class OrderController {

	@Autowired
	private OrderJDBCTemplate orderJDBCTemplate;

	@RequestMapping(method = RequestMethod.GET)
	public String listOrders(Model model) {
		List<Order> orders = orderJDBCTemplate.getAllOrder();
		model.addAttribute("orders", orders);
		return "home/order";
	}
	@RequestMapping(path = "/createOrder", method = RequestMethod.GET)
	public ModelAndView newOrder(Model model) {
		List<User> users = orderJDBCTemplate.getAllUser();
		model.addAttribute("users", users);
		List<Product> products = orderJDBCTemplate.getAllProduct();
		model.addAttribute("products", products);
		return new ModelAndView("home/createOrder", "command", new Order());
	}

	@RequestMapping(path = "/createOrder", method = RequestMethod.POST)
	public String newOrder(@ModelAttribute Order order, Model model) {
		List<User> users = orderJDBCTemplate.getAllUser();
		model.addAttribute("users", users);
		List<Product> products = orderJDBCTemplate.getAllProduct();
		model.addAttribute("products", products);
		int count = 0;
		for (Product product : products) {
			if (product.getId() == order.getProductId()) {
				count = 1;
			}
		}
		if (count == 0) {
			model.addAttribute("count", count);
			return "redirect:/home/orders/createOrder";
		}
		count = 0;
		for (User user : users) {
			if (user.getId() == order.getUserId()) {
				count = 1;
			}
		}
		if (count == 0) {
			model.addAttribute("count", count);
			return "redirect:/home/orders/createOrder";
		}
		
		orderJDBCTemplate.createOrder(order.getUserId(), order.getProductId());
		return "redirect:/home/orders";
	}
}

