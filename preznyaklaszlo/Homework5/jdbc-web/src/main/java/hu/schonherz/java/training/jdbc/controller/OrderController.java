package hu.schonherz.java.training.jdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hu.schonherz.java.training.jdbc.service.OrderService;
import hu.schonherz.java.training.jdbc.service.ProductService;
import hu.schonherz.java.training.jdbc.service.UserService;
import hu.schonherz.java.training.jdbc.vo.OrderVo;
import hu.schonherz.java.training.jdbc.vo.ProductVo;
import hu.schonherz.java.training.jdbc.vo.UserVo;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private UserService userService;

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderService orderService;

	@RequestMapping(path = "/addOrder", method = RequestMethod.GET)
	public ModelAndView newOrder(Model model) {
		List<UserVo> userVos = userService.getAllUsers();
		List<ProductVo> productVos = productService.getAllProducts();

		model.addAttribute("userVos", userVos);
		model.addAttribute("productVos", productVos);

		return new ModelAndView("/order/addOrder", "order", new OrderVo());
	}

	@RequestMapping(path = "/addOrder", method = RequestMethod.POST)
	public String addNewOrder(@ModelAttribute("order") OrderVo orderVo, Model model) {

		orderService.addOrder(orderVo);
		

		return "redirect:/";
	}

}
