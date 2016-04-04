package hu.schonherz.homework.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hu.schonherz.homework.service.interf.ServiceInterf;
import hu.schonherz.homework.service.vo.OrderVo;
import hu.schonherz.homework.service.vo.ProductVo;
import hu.schonherz.homework.service.vo.UserVo;

@Controller
public class OrderController {

	@Autowired
	private ServiceInterf<OrderVo> orderServiceImpl;
	@Autowired
	private ServiceInterf<ProductVo> productServiceImpl;
	@Autowired
	private ServiceInterf<UserVo> userServiceImpl;

	@RequestMapping(path = "/order", method = RequestMethod.GET)
	public String loadOrderPage(Model model) {
		List<OrderVo> orders = orderServiceImpl.getAllVos();
		List<ProductVo> products = productServiceImpl.getAllVos();
		List<UserVo> users = userServiceImpl.getAllVos();
		List<ProductVo> resultProducts = new ArrayList<>();
		List<UserVo> resultUsers = new ArrayList<>();
		for (OrderVo order : orders) {
			for (ProductVo product : products) {
				if (order.getProductId() == product.getId()) {
					resultProducts.add(product);
				}
			}
			for (UserVo user : users) {
				if (order.getUserId() == user.getId()) {
					resultUsers.add(user);
				}
			}
		}
		model.addAttribute("products", resultProducts);
		model.addAttribute("users", resultUsers);
		return "order/index";
	}

	@RequestMapping(path = "/addorder", method = RequestMethod.GET)
	public ModelAndView newOrder(Model model) {
		return new ModelAndView("order/addorder", "order", new OrderVo());
	}

	@RequestMapping(path = "/addorder", method = RequestMethod.POST)
	public String newOrder(@ModelAttribute OrderVo order, Model model) {
		orderServiceImpl.addVo(order);
		return "redirect:/order";
	}
}