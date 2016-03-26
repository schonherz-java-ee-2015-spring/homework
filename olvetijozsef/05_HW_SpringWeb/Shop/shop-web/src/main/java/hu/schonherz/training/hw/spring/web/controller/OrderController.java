package hu.schonherz.training.hw.spring.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hu.schonherz.training.hw.spring.service.OrderService;
import hu.schonherz.training.hw.spring.service.ProductService;
import hu.schonherz.training.hw.spring.service.UserService;
import hu.schonherz.training.hw.spring.vo.OrderVo;
import hu.schonherz.training.hw.spring.vo.ProductVo;
import hu.schonherz.training.hw.spring.vo.UserVo;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private UserService userService;

	@Autowired
	private ProductService productService;

	@RequestMapping(method = RequestMethod.GET)
	public String listOrders(Model model) {
		List<OrderVo> orders = orderService.getAllOrders();
		model.addAttribute("orders", orders);
		return "order/order";
	}

	@RequestMapping(path = "/create", method = RequestMethod.GET)
	public ModelAndView newOrder(Model model) {
		List<UserVo> users = userService.getAllUsers();
		List<ProductVo> products = productService.getAllProducts();
		model.addAttribute("users", users);
		model.addAttribute("products", products);
		return new ModelAndView("order/create", "command", new OrderVo());
	}

	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public String newOrder(@ModelAttribute OrderVo order, Model model) {
		orderService.addOrder(order);
		return "redirect:/order";
	}
}
