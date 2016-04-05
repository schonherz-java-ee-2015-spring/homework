package hu.schonhertz.training.blog.service;

import java.util.List;

import hu.schonhertz.training.blog.vo.CategoryVo;

public interface CategoryService {

	public List<String> getAllCategoryName(String term);

	public CategoryVo getCategoryByName(String name);

	public void createCategory(CategoryVo cvo);

	public List<String> getAllCategoryName();
}
