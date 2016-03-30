package hu.schonherz.java.training.jdbc.mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import hu.schonherz.java.training.jdbc.records.Product;
import hu.schonherz.java.training.jdbc.vo.ProductVo;

public class ProductMapper {

	private static Mapper mapper = new DozerBeanMapper();

	public static ProductVo toVo(Product product) {
		return mapper.map(product, ProductVo.class);
	}

	public static Product toDto(ProductVo productVo) {
		return mapper.map(productVo, Product.class);
	}

	public static List<ProductVo> toVo(List<Product> products) {
		List<ProductVo> productVos = new ArrayList<>();
		for (Product product : products) {
			productVos.add(toVo(product));
		}
		return productVos;
	}

	public static List<Product> toDto(List<ProductVo> productVos) {
		List<Product> products = new ArrayList<>();
		for (ProductVo productVo : productVos) {
			products.add(toDto(productVo));
		}
		return products;
	}

	public ProductMapper() {
		super();
	}

}
