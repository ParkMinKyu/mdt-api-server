package kr.niee.mdt.article.dao;

import java.util.List;
import java.util.Map;

import kr.niee.mdt.article.vo.ArticleVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("articleDAO")
public class ArticleDAO {
	
	@Autowired
	private JdbcTemplate template;
	
	public List<Map<String, Object>> getArticles(){
		return template.queryForList("select * from article");
	}
	
	public int insertArticle(ArticleVO articleVO){
		return template.update("insert into article values(?, ?, ?, NOW(), NOW(), ?)",articleVO.getId(),articleVO.getTitle(),articleVO.getContents(),articleVO.getWriter());
	}

	public int updateArticle(ArticleVO articleVO){
		return template.update("update article set title = ? , contents = ? , modtime = NOW() where id = ? and writer = ?",articleVO.getTitle(),articleVO.getContents(),articleVO.getId(), articleVO.getWriter());
	}

	public int deleteArticle(ArticleVO articleVO){
		return template.update("delete from article where id = ? ",articleVO.getId());
	}

	public int getMaxId(){
		return template.queryForObject("select NVL(MAX(id),0) from article", Integer.class);
	}
}
