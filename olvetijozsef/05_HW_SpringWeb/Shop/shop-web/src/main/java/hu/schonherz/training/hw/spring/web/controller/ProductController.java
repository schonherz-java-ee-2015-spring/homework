package hu.schonherz.training.hw.spring.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hu.schonherz.training.hw.spring.service.ProductService;
import hu.schonherz.training.hw.spring.vo.ProductVo;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(method = RequestMethod.GET)
	public String listProducts(Model model) {
		List<ProductVo> products = productService.getAllProducts();
		model.addAttribute("products", products);
		return "product/product";
	}

	@RequestMapping(path = "/create", method = RequestMethod.GET)
	public ModelAndView newProduct(Model model) {
		return new ModelAndView("product/create", "command", new ProductVo());
	}

	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public String newProduct(@ModelAttribute ProductVo product, Model model) {
		productService.addProduct(product);
		return "redirect:/product";
	}
}
