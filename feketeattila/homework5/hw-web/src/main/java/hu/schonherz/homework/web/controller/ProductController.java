package hu.schonherz.homework.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hu.schonherz.homework.service.interf.ServiceInterf;
import hu.schonherz.homework.service.vo.ProductVo;

@Controller
public class ProductController {

	@Autowired
	private ServiceInterf<ProductVo> productServiceImpl;

	@RequestMapping(path = "/product", method = RequestMethod.GET)
	public String loadProductPage(Model model) {
		List<ProductVo> products = productServiceImpl.getAllVos();
		model.addAttribute("products", products);
		return "product/index";
	}

	@RequestMapping(path = "/addproduct", method = RequestMethod.GET)
	public ModelAndView newProduct(Model model) {
		return new ModelAndView("product/addproduct", "product", new ProductVo());
	}

	@RequestMapping(path = "/addproduct", method = RequestMethod.POST)
	public String newProduct(@ModelAttribute ProductVo product, Model model) {
		productServiceImpl.addVo(product);
		return "redirect:/product";
	}
}
