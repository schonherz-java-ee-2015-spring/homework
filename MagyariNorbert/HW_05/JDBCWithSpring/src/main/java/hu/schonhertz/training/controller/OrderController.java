package hu.schonhertz.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hu.schonhertz.training.jdbctemplate.OrderJDBCTemplate;
import hu.schonhertz.training.jdbctemplate.ProductJDBCTemplate;
import hu.schonhertz.training.jdbctemplate.UserJDBCTemplate;
import hu.schonhertz.training.pojo.Order;
import hu.schonhertz.training.pojo.Product;
import hu.schonhertz.training.pojo.User;

@Controller
@RequestMapping("/")
public class OrderController {
	  @Autowired
	  private OrderJDBCTemplate orderJDBCTemplate;
	  
	  @Autowired
	  private ProductJDBCTemplate productJDBCTemplate;
	  
	  @Autowired
	  private UserJDBCTemplate userJDBCTemplate;
	  
	  @RequestMapping(path = "/order",method = RequestMethod.GET)
	  public String listOrder(Model model) {
	    List<Order> order = orderJDBCTemplate.getAllOrder();
	    model.addAttribute("orders", order);
	    return "order/orderIndex";
	  }
	    
	  @RequestMapping(path = "order/details/{id}", method = RequestMethod.GET)
	  public String productDetails(@PathVariable Long id, Model model) {
	    List<Order> order = orderJDBCTemplate.getOrderByUserId(id);
	    model.addAttribute("order", order);
	    return "order/details";
	  }
	  
	  @RequestMapping(path = "order/create", method = RequestMethod.GET)
	  public ModelAndView newOrder(Model model) {
		    List<Product> product = productJDBCTemplate.getAllProduct();
		    model.addAttribute("products", product);
		    List<User> user = userJDBCTemplate.getAllUser();
		    model.addAttribute("users", user);
	    return new ModelAndView("order/create", "command", new Order());
	  }
	  
	  @RequestMapping(path = "order/create", method = RequestMethod.POST)
	  public String newOrder(@ModelAttribute Order order, Model model) {
		  orderJDBCTemplate.createOrder(order.getUser_id(), order.getProduct_id());
	    return "redirect:/order";
	  }
	  
	  @RequestMapping(path = "order/delete", method = RequestMethod.GET)
	  public ModelAndView newOrderForDelete(Model model) {
	    return new ModelAndView("order/delete", "command", new Order());
	  }
	  
	  @RequestMapping(path = "order/delete", method = RequestMethod.POST)
	  public String deleteOrderbyUserId(@ModelAttribute Order order, Model model) {
	    orderJDBCTemplate.deleteOrderByUserId(order.getUser_id());
	    return "redirect:/order";
	  }
}
