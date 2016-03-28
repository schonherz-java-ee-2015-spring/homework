package hu.schonerz.java.training.hw5.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hu.schonerz.java.training.hw5.service.ProductService;
import hu.schonerz.java.training.hw5.vo.ProductVo;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	//	If a HTTP GET request comes in the /product path this method will run.
	@RequestMapping(path="/product", method=RequestMethod.GET)
	public String listProducts(Model model){
		
		// Get all the products
		List<ProductVo> products = productService.getAllProducts();
		// Add the products list as a modelAttribute with the "products" name.
		model.addAttribute("products", products);
		
		// Return to index.jsp
		return "index";
	}
	// If a HTTP GET request comes in the /newproduct path this method will run.
	@RequestMapping(path="/newproduct", method=RequestMethod.GET)
	public ModelAndView newProduct(Model model){
		// Return a new Model with a ProductVo attribute named "product" and
		// returns to index.jsp
		return new ModelAndView("index", "product", new ProductVo());
	}
	
	// If a HTTP POST request comes in the /newproduct path this method will run.
	@RequestMapping(path="/newproduct", method=RequestMethod.POST)
	// Comes with a ModelAttribute named "product" contains a ProductVo object.
	public String addNewProduct(@ModelAttribute("product") ProductVo product, Model model){
		
		// Add the attribute to the database (pass it to the service layer)
		productService.addProuduct(product);
		
		// redirect to the /user path
		return "redirect:/user";
	}
	
}
