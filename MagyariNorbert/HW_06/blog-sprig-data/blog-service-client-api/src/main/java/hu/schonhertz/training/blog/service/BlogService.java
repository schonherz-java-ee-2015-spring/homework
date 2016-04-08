package hu.schonhertz.training.blog.service;

import java.util.List;
import java.util.Map;

import hu.schonhertz.training.blog.vo.BlogSearchResult;
import hu.schonhertz.training.blog.vo.BlogVo;

public interface BlogService {

	public List<BlogVo> getAllBlog();

	public BlogVo getBlogById(Long id);

	public void createBlog(BlogVo blogVo);

	public List<BlogVo> getAllBlog(Integer page, Integer size);

	public Long countBlog();

	public BlogSearchResult searchBlog(String title, Integer page, Integer size);

	BlogSearchResult searchBlogByCategory(String category, Integer page, Integer size);
	
	public Map<String, Integer> getAllCategory();

//	BlogSearchResult searchParameterizedBlogByCategory(String category, Integer page, Integer size);
}
