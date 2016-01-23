package kr.niee.mdt.category.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.niee.mdt.category.vo.CategoryVO;

@Repository("categoryDAO")
public class CategoryDAO {
	
	@Autowired
	private JdbcTemplate template;
	
	public List<Map<String, Object>> getCategories(CategoryVO categoryVO){
		return template.queryForList("select * from category where writer = ? order by id asc",categoryVO.getWriter());
	}
	
	public int insertCategory(CategoryVO categoryVO){
		return template.update("insert into category values(?,?,?)", categoryVO.getTitle(), categoryVO.getGroupid(),categoryVO.getWriter());
	}

	public int updateCategory(CategoryVO categoryVO){
		return template.update("update category set title = ? , groupid = ? , where id = ?", categoryVO.getTitle(), categoryVO.getGroupid(), categoryVO.getId());
	}

	public int deleteCategory(CategoryVO categoryVO){
		return template.update("delete from category where id = ? ", categoryVO.getId());
	}

	public int getMaxId(){
		return template.queryForObject("select NVL(MAX(id),0) from category", Integer.class);
	}
}
