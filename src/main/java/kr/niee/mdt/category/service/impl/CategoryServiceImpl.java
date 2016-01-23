package kr.niee.mdt.category.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.niee.mdt.category.dao.CategoryDAO;
import kr.niee.mdt.category.service.CategoryService;
import kr.niee.mdt.category.vo.CategoryVO;

@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Override
	public List<Map<String, Object>> getCategories(CategoryVO categoryVO) {
		// TODO Auto-generated method stub
		return categoryDAO.getCategories(categoryVO);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public int insertCategory(CategoryVO categoryVO){
		// TODO Auto-generated method stub
		int maxId = categoryDAO.getMaxId();
		categoryVO.setId(maxId + 1);
		return categoryDAO.insertCategory(categoryVO);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public int updateCategory(CategoryVO categoryVO) throws Exception {
		// TODO Auto-generated method stub
		return categoryDAO.updateCategory(categoryVO);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public int deleteCategory(CategoryVO categoryVO) throws Exception {
		// TODO Auto-generated method stub
		return categoryDAO.deleteCategory(categoryVO);
	}

}
