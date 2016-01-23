package kr.niee.mdt.article.service.impl;

import java.util.List;
import java.util.Map;

import kr.niee.mdt.article.dao.ArticleDAO;
import kr.niee.mdt.article.service.ArticleService;
import kr.niee.mdt.article.vo.ArticleVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("articleService")
@Transactional
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	private ArticleDAO articleDAO;
	
	@Override
	public int getArticleCnt() {
		// TODO Auto-generated method stub
		return articleDAO.getArticleCnt();
	}
	
	@Override
	public List<Map<String, Object>> getArticles(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return articleDAO.getArticles(paramMap);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public int insertArticle(ArticleVO articleVO) throws Exception {
		// TODO Auto-generated method stub
		int maxId = articleDAO.getMaxId();
		articleVO.setId(maxId + 1);
		return articleDAO.insertArticle(articleVO);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public int updateArticle(ArticleVO articleVO) throws Exception {
		// TODO Auto-generated method stub
		return articleDAO.updateArticle(articleVO);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public int deleteArticle(ArticleVO articleVO) throws Exception {
		// TODO Auto-generated method stub
		return articleDAO.deleteArticle(articleVO);
	}

}
