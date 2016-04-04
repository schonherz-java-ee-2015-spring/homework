package hu.schonhertz.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hu.schonhertz.training.jdbctemplate.ProductJDBCTemplate;
import hu.schonhertz.training.pojo.Product;


@Controller
@RequestMapping("/")
public class ProductController {
  
  @Autowired
  private ProductJDBCTemplate productJDBCTemplate;
  
  @RequestMapping(path = "/product",method = RequestMethod.GET)
  public String listProduct(Model model) {
    List<Product> product = productJDBCTemplate.getAllProduct();
    model.addAttribute("products", product);
    return "product/productIndex";
  }
  
  
  @RequestMapping(path = "product/details/{id}", method = RequestMethod.GET)
  public String productDetails(@PathVariable Long id, Model model) {
    Product product = productJDBCTemplate.getProductById(id);
    model.addAttribute("product", product);
    return "product/details";
  }
  
  @RequestMapping(path = "product/create", method = RequestMethod.GET)
  public ModelAndView newProduct(Model model) {
    return new ModelAndView("product/create", "command", new Product());
  }
  
  @RequestMapping(path = "product/create", method = RequestMethod.POST)
  public String newProduct(@ModelAttribute Product product, Model model) {
	  productJDBCTemplate.createProduct(product.getName(), product.getPrice(), product.getId());
    return "redirect:/product";
  }
  
  @RequestMapping(path = "product/delete", method = RequestMethod.GET)
  public ModelAndView newProductForDelete(Model model) {
    return new ModelAndView("product/delete", "command", new Product());
  }
  
  @RequestMapping(path = "product/delete", method = RequestMethod.POST)
  public String deleteProduct(@ModelAttribute Product product, Model model) {
    productJDBCTemplate.deleteProduct(product.getName());
    return "redirect:/product";
  }
  
}
