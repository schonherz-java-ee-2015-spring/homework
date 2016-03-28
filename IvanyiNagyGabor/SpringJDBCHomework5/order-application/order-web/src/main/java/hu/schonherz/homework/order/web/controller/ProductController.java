package hu.schonherz.homework.order.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hu.schonherz.homework.order.service.ProductService;
import hu.schonherz.homework.order.vo.ProductVo;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(path = "/productDetails", method = RequestMethod.GET)
	public String listUsers(Model model) {
		try {
			List<ProductVo> productList = productService.getAllProduct();
			model.addAttribute("productList", productList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "product/productDetails";
	}

	@RequestMapping(path = "/createProduct", method = RequestMethod.GET)
	public ModelAndView newBlog(Model model) {
		return new ModelAndView("/product/createProduct", "command", new ProductVo());
	}

	@RequestMapping(path = "/createProduct", method = RequestMethod.POST)
	public String newBlog(@ModelAttribute ProductVo productVo, Model model) {
		try {
			productService.addProduct(productVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}
}
