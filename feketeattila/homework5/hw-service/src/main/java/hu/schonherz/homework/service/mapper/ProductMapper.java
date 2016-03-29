package hu.schonherz.homework.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import hu.schonherz.homework.core.dto.ProductDto;
import hu.schonherz.homework.service.vo.ProductVo;

public class ProductMapper {

	private static Mapper mapper = new DozerBeanMapper();

	public static ProductVo toVo(ProductDto product) {
		return mapper.map(product, ProductVo.class);
	}

	public static ProductDto toDto(ProductVo productVo) {
		return mapper.map(productVo, ProductDto.class);
	}

	public static List<ProductVo> toVo(List<ProductDto> products) {
		List<ProductVo> productVos = new ArrayList<>();
		for (ProductDto product : products) {
			productVos.add(toVo(product));
		}
		return productVos;
	}

	public static List<ProductDto> toDto(List<ProductVo> productVos) {
		List<ProductDto> products = new ArrayList<>();
		for (ProductVo productVo : productVos) {
			products.add(toDto(productVo));
		}
		return products;
	}

}