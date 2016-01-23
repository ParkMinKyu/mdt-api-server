package kr.niee.mdt.article.service;

import java.util.List;
import java.util.Map;

import kr.niee.mdt.article.vo.ArticleVO;

public interface ArticleService {
	public int getArticleCnt();
	public List<Map<String, Object>> getArticles(Map<String, Object> paramMap);
	public int insertArticle(ArticleVO articleVO) throws Exception;
	public int updateArticle(ArticleVO articleVO) throws Exception;
	public int deleteArticle(ArticleVO articleVO) throws Exception;
}