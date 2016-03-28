package hu.schonherz.homework.order.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import hu.schonherz.homework.order.dto.ProductDto;
import hu.schonherz.homework.order.vo.ProductVo;

public class ProductMapper {
	private static Mapper mapper = new DozerBeanMapper();

	/**
	 * Convert Product to ProductVo
	 */
	public static ProductVo toVo(ProductDto product) {
		return mapper.map(product, ProductVo.class);
	}

	/**
	 * Convert ProductVo to Product
	 */
	public static ProductDto toDto(ProductVo productVo) {
		return mapper.map(productVo, ProductDto.class);
	}

	/**
	 * Convert Product list to ProductVo list
	 */
	public static List<ProductVo> toVo(List<ProductDto> products) {
		List<ProductVo> productsVos = new ArrayList<ProductVo>();
		for (ProductDto product : products) {
			productsVos.add(toVo(product));
		}
		return productsVos;
	}

	/**
	 * Convert ProductVo list to Product list
	 */
	public static List<ProductDto> toDto(List<ProductVo> productVos) {
		List<ProductDto> products = new ArrayList<ProductDto>();
		for (ProductVo productVo : productVos) {
			products.add(toDto(productVo));
		}
		return products;
	}
}
