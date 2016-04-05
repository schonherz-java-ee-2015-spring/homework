package hu.schonhertz.training.blog.service.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.schonhertz.training.blog.repository.CategoryRepository;
import hu.schonhertz.training.blog.service.CategoryService;
import hu.schonhertz.training.blog.service.mapper.CategoryMapper;
import hu.schonhertz.training.blog.vo.CategoryVo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CategoryServiceImpl implements CategoryService {

	static final Logger logger = LogManager.getLogger(CategoryService.class.getName());

	@Autowired
	private CategoryRepository categoryRepository;


	@Override
	public List<String> getAllCategoryName(String term) {
		List<String> categoryNames = CategoryMapper.toStr(categoryRepository.findByNameStartingWithIgnoreCase(term));
		return categoryNames;
	}

	@Override
	public CategoryVo getCategoryByName(String name) {
		return CategoryMapper.toVo(categoryRepository.findByName(name));
	}

	@Override
	public void createCategory(CategoryVo cvo) {
		try {
			categoryRepository.save(CategoryMapper.toDto(cvo));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	@Override
	public List<String> getAllCategoryName() {
		return CategoryMapper.toStr(categoryRepository.findAll());
	}

}
