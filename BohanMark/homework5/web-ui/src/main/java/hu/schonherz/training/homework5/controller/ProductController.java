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

import hu.schonherz.training.homework5.dao.ProductJdbcTemplate;
import hu.schonherz.training.homework5.pojo.Product;
import hu.schonherz.training.homework5.pojo.User;


@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductJdbcTemplate productJdbcTemplate;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductController() {
		super();
	}
	  
	  @RequestMapping(method = RequestMethod.GET)
	  public String listProducts(Model model) {
	    List<Product> products = productJdbcTemplate.getAllProducts();
	    model.addAttribute("products", products);
	    return "product/productindex";
	  }
	  @RequestMapping(value = "new/{name}/{price}",method = RequestMethod.GET)
	  public String newProduct(@PathVariable String name, @PathVariable int price,  Model model) {
		Product product = new Product();
		product.setName(name);
		product.setPrice(price);
		if(name != null || !name.isEmpty())
			productJdbcTemplate.createProduct(product);
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
