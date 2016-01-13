package kr.niee.mdt.article.web;

import kr.niee.mdt.article.service.ArticleService;
import kr.niee.mdt.article.vo.ArticleVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
public class ArticlesController{
	
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> articles(){
		return new ResponseEntity<>(articleService.getArticles(),HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.POST, consumes={MediaType.TEXT_PLAIN_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> insertArticles(@RequestBody ArticleVO articleVO, BindingResult result) throws Exception{
		if(result.hasErrors())
			return new ResponseEntity<>(result.getAllErrors(),HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(articleService.insertArticle(articleVO),HttpStatus.CREATED);
	}

	@RequestMapping(method=RequestMethod.PATCH, consumes={MediaType.TEXT_PLAIN_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> updateArticles(@RequestBody ArticleVO articleVO) throws Exception{
		return new ResponseEntity<>(articleService.updateArticle(articleVO),HttpStatus.ACCEPTED);
	}

	@RequestMapping(method=RequestMethod.DELETE, consumes={MediaType.TEXT_PLAIN_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> deleteArticles(@RequestBody ArticleVO articleVO) throws Exception{
		return new ResponseEntity<>(articleService.deleteArticle(articleVO),HttpStatus.NO_CONTENT);
	}
}
