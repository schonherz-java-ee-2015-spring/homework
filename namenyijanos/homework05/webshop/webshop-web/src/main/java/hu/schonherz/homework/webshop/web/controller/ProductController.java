package hu.schonherz.homework.webshop.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hu.schonherz.homework.webshop.service.ProductService;
import hu.schonherz.homework.webshop.vo.ProductVo;



@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	
	
	@RequestMapping(path="/product", method=RequestMethod.GET)
	public String listProducts(Model model){
		
	
		List<ProductVo> products = productService.getAllProducts();
		
		model.addAttribute("products", products);
		
		
		return "index";
	}
	
	@RequestMapping(path="/newproduct", method=RequestMethod.GET)
	public ModelAndView newProduct(Model model){
		
		return new ModelAndView("index", "product", new ProductVo());
	}
	
	
	@RequestMapping(path="/newproduct", method=RequestMethod.POST)
	
	public String addNewProduct(@ModelAttribute("product") ProductVo product, Model model){
		
		
		productService.addProduct(product);
		
		return "redirect:/user";
	}
}
