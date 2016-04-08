package hu.schonhertz.training.blog.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import hu.schonhertz.training.blog.entity.Category;
import hu.schonhertz.training.blog.vo.CategoryVo;

public class CategoryMapper {

	private static Mapper mapper = new DozerBeanMapper();

	public static CategoryVo toVo(Category categoryDto) {
		if (categoryDto == null) {
			return null;
		}
		return mapper.map(categoryDto, CategoryVo.class);
	}

	public static Category toDto(CategoryVo categoryVo) {
		if (categoryVo == null) {
			return null;
		}
		return mapper.map(categoryVo, Category.class);
	}

	public static List<CategoryVo> toVo(List<Category> categoryDtos) {
		List<CategoryVo> categoryVos = new ArrayList<>();
		for (Category categoryDto : categoryDtos) {
			categoryVos.add(toVo(categoryDto));
		}
		return categoryVos;
	}

	public static List<Category> toDto(List<CategoryVo> categoryVos) {
		List<Category> categoryDtos = new ArrayList<>();
		for (CategoryVo categoryVo : categoryVos) {
			categoryDtos.add(toDto(categoryVo));
		}
		return categoryDtos;
	}

	public static List<String> toStr(List<Category> categoryDtos) {
		List<String> str = new ArrayList<>();
		for (Category categoryDto : categoryDtos) {
			str.add(categoryDto.getName());
		}
		return str;
	}

}
