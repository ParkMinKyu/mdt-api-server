package kr.niee.mdt.category.service;

import java.util.List;
import java.util.Map;

import kr.niee.mdt.category.vo.CategoryVO;

public interface CategoryService {

	public List<Map<String, Object>> getCategories(CategoryVO categoryVO);
	public int insertCategory(CategoryVO categoryVO) throws Exception;
	public int updateCategory(CategoryVO categoryVO) throws Exception;
	public int deleteCategory(CategoryVO categoryVO) throws Exception;
	
}
