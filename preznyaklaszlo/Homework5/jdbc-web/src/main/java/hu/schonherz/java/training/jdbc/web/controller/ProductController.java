package hu.schonherz.java.training.jdbc.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hu.schonherz.java.training.jdbc.service.ProductService;
import hu.schonherz.java.training.jdbc.service.vo.ProductVo;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(path = "/productDetails", method = RequestMethod.GET)
	public String listAllProduct(Model model) {
		List<ProductVo> productVos = productService.getAllProducts();
		model.addAttribute("productVos", productVos);
		return "product/productDetails";
	}

	@RequestMapping(path = "/createProduct", method = RequestMethod.GET)
	public ModelAndView newProduct(Model model) {

		return new ModelAndView("/product/createProduct", "product", new ProductVo());
	}

	@RequestMapping(path = "/createProduct", method = RequestMethod.POST)
	public String addNewProduct(@ModelAttribute("product") ProductVo productVo, Model model) {
		productService.addProduct(productVo);

		return "redirect:/";

	}

}
