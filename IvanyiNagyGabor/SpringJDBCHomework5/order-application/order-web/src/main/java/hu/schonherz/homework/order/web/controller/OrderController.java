package hu.schonherz.homework.order.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hu.schonherz.homework.order.model.OrderByNames;
import hu.schonherz.homework.order.service.OrderService;
import hu.schonherz.homework.order.service.ProductService;
import hu.schonherz.homework.order.service.UserService;
import hu.schonherz.homework.order.vo.OrderVo;
import hu.schonherz.homework.order.vo.ProductVo;
import hu.schonherz.homework.order.vo.UserVo;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private UserService userService;
	@Autowired
	private ProductService productService;
	@Autowired
	private OrderService orderService;

	@RequestMapping(path = "/orderDetails", method = RequestMethod.GET)
	public String listUsers(Model model) {

		try {
			List<OrderByNames> list = new ArrayList<OrderByNames>();
			List<UserVo> userVo = userService.getAllUser();
			List<ProductVo> productVo = productService.getAllProduct();
			String userName;
			String productName;

			for (OrderVo orderVo : orderService.getAllOrder()) {
				userName = userVo.stream().filter(user -> user.getId().equals(orderVo.getUserId())).findFirst().get()
						.getName();

				productName = productVo.stream().filter(product -> product.getId().equals(orderVo.getProductId()))
						.findFirst().get().getName();
				
				list.add(new OrderByNames(userName, productName));
			}
			model.addAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "order/orderDetails";
	}

	@RequestMapping(path = "/addOrder", method = RequestMethod.GET)
	public ModelAndView newBlog(Model model) {

		try {
			List<UserVo> userList = userService.getAllUser();
			List<ProductVo> productList = productService.getAllProduct();
			model.addAttribute("userList", userList);
			model.addAttribute("productList", productList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("/order/addOrder", "command", new OrderVo());
	}

	@RequestMapping(path = "/addOrder", method = RequestMethod.POST)
	public String newBlog(@ModelAttribute OrderVo orderVo, Model model) {
		System.out.println(orderVo);
		try {
			orderService.addOrder(orderVo);
		} catch (Exception e) {

		}
		return "redirect:/";
	}

}
