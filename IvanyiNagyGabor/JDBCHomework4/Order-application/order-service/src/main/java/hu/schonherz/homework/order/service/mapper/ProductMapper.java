package hu.schonherz.homework.order.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import hu.schonherz.homework.order.dto.Product;
import hu.schonherz.homework.order.vo.ProductVo;

public class ProductMapper {
	private static Mapper mapper = new DozerBeanMapper();

	public static ProductVo toVo(Product product) {
		return mapper.map(product, ProductVo.class);
	}

	public static Product toDto(ProductVo productVo) {
		return mapper.map(productVo, Product.class);
	}

	public static List<ProductVo> toVo(List<Product> products) {
		List<ProductVo> productsVos = new ArrayList<ProductVo>();
		for (Product product : products) {
			productsVos.add(toVo(product));
		}
		return productsVos;
	}

	public static List<Product> toDto(List<ProductVo> productVos) {
		List<Product> products = new ArrayList<Product>();
		for (ProductVo productVo : productVos) {
			products.add(toDto(productVo));
		}
		return products;
	}
}
