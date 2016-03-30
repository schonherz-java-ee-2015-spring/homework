package hu.schonherz.training.homework5.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import hu.schonherz.training.homework5.dao.OrderJdbcTemplate;
import hu.schonherz.training.homework5.dao.ProductJdbcTemplate;
import hu.schonherz.training.homework5.dao.UserJdbcTemplate;
import hu.schonherz.training.homework5.pojo.Order;
import hu.schonherz.training.homework5.pojo.User;


@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderJdbcTemplate orderJdbcTemplate;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderController() {
		super();
	}
	  
	  @RequestMapping(value = "new/{userId}/{productId}",method = RequestMethod.GET)
	  public String newUser(@PathVariable int userId,@PathVariable int productId , Model model) {
		orderJdbcTemplate.createOrder(userId, productId);
	    return "";
	  }
	

	@PostConstruct
	public void postConstruct() {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		/*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/web-ui-servlet.xml");
		context.refresh();
		userJdbcTemplate = (UserJdbcTemplate)context.getBean("userJdbcTemplate");*/
	}

}
