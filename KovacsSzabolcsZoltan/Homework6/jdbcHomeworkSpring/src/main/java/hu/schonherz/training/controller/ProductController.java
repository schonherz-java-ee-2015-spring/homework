package hu.schonherz.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hu.schonherz.training.jdbcTemplate.ProductJDBCTemplate;
import hu.schonherz.training.pojo.Product;

@Controller
@RequestMapping("home/products")
public class ProductController {

	@Autowired
	private ProductJDBCTemplate productJDBCTemplate;

	@RequestMapping(method = RequestMethod.GET)
	public String listProducts(Model model) {
		List<Product> products = productJDBCTemplate.getAllProduct();
		model.addAttribute("products", products);
		return "home/product";
	}
	@RequestMapping(path = "/createProduct", method = RequestMethod.GET)
	public ModelAndView newProduct(Model model) {
		return new ModelAndView("home/createProduct", "command", new Product());
	}

	@RequestMapping(path = "/createProduct", method = RequestMethod.POST)
	public String newProduct(@ModelAttribute Product product, Model model) {
		
		int count = product.getName().isEmpty() ? 0 : 1;
		if (count == 0) {
			model.addAttribute("count", count);
			return "redirect:/home/products/createProduct";
		}
		count = product.getPrice() == 0 ? 0 : 1;
		if (count == 0) {
			model.addAttribute("count", count);
			return "redirect:/home/products/createProduct";
		}
		
		productJDBCTemplate.createProduct(product.getName(), product.getPrice());
		return "redirect:/home/products";
	}
}

