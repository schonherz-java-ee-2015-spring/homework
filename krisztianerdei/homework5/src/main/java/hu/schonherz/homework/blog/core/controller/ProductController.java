package hu.schonherz.homework.blog.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hu.schonherz.homework.blog.core.entitiy.Product;
import hu.schonherz.homework.blog.core.repository.impl.ProductJDBCTemplate;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductJDBCTemplate prodcutJDBCTemplate;

	@RequestMapping(method = RequestMethod.GET)
	public String listBlogs(Model model) {
		List<Product> products = prodcutJDBCTemplate.getAllProduct();
		model.addAttribute("products", products);
		return "product/productindex";
	}

	@RequestMapping(path = "/create", method = RequestMethod.GET)
	public ModelAndView newBlog(Model model) {
		return new ModelAndView("product/create", "command", new Product());
	}

	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public String newUser(@ModelAttribute Product product, Model model) {
		prodcutJDBCTemplate.addProduct(product.getName(),product.getPrice());
		return "redirect:/product";
	}

}
