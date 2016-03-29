package hu.schonherz.homework.webshop.service.mapper;

import java.util.ArrayList;
import java.util.List;

import hu.schonherz.homework.webshop.dto.Product;
import hu.schonherz.homework.webshop.vo.ProductVo;

public class ProductMapper {

	public static ProductVo toVo( Product product ){
		ProductVo vo = new ProductVo();
		vo.setId(product.getId());
		vo.setPrice(product.getPrice());
		vo.setName(product.getName());
		return vo;
	}
	
	public static List<ProductVo> toVo(List<Product> products) {
		List<ProductVo> vos = new ArrayList<>();
		for (Product product : products) {
			vos.add( toVo(product) );
		}
		return vos;
	}
	
	public static Product toDto( ProductVo vo ){
		Product product = new Product();
		product.setId(vo.getId());
		product.setPrice(vo.getPrice());
		product.setName(vo.getName());
		return product;
	}
	
	public static List<Product> toDto(List<ProductVo> vos) {
		List<Product> products = new ArrayList<>();
		for (ProductVo vo : vos) {
			products.add(toDto(vo));
		}
		return products;
	}
}
