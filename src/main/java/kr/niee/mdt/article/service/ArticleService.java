package kr.niee.mdt.article.service;

import java.util.List;
import java.util.Map;

import kr.niee.mdt.article.vo.ArticleVO;

public interface ArticleService {
	public List<Map<String, Object>> getArticles();
	public int insertArticle(ArticleVO ArticleVO) throws Exception;
	public int updateArticle(ArticleVO ArticleVO) throws Exception;
	public int deleteArticle(ArticleVO ArticleVO) throws Exception;
}