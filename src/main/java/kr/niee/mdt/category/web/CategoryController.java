package kr.niee.mdt.category.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.niee.mdt.category.service.CategoryService;
import kr.niee.mdt.category.vo.CategoryVO;

@RestController
@RequestMapping("/categories")
public class CategoryController{
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> categories(@ModelAttribute CategoryVO categoryVO){
		return new ResponseEntity<>(categoryService.getCategories(categoryVO),HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.POST, consumes={MediaType.TEXT_PLAIN_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> insertcategories(@RequestBody CategoryVO categoryVO, BindingResult result) throws Exception{
		if(result.hasErrors())
			return new ResponseEntity<>(result.getAllErrors(),HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(categoryService.insertCategory(categoryVO),HttpStatus.CREATED);
	}

	@RequestMapping(method=RequestMethod.PATCH, consumes={MediaType.TEXT_PLAIN_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> updateArticles(@RequestBody CategoryVO categoryVO) throws Exception{
		return new ResponseEntity<>(categoryService.updateCategory(categoryVO),HttpStatus.ACCEPTED);
	}

	@RequestMapping(method=RequestMethod.DELETE, consumes={MediaType.TEXT_PLAIN_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> deleteArticles(@RequestBody CategoryVO categoryVO) throws Exception{
		return new ResponseEntity<>(categoryService.deleteCategory(categoryVO),HttpStatus.NO_CONTENT);
	}
}
