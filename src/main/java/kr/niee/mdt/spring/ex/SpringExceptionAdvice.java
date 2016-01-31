package kr.niee.mdt.spring.ex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class SpringExceptionAdvice {
	
	@ExceptionHandler(FileUploadException.class)
	public ResponseEntity<?> exception(FileUploadException exception) {
		Map<String, String> exMap = new HashMap<String, String>();
		exMap.put("message", "fileUploadError");
		exMap.put("localizedMassage", "파일 용량은 5MB를 넘을수 없습니다.");
		return new ResponseEntity<> (exMap,HttpStatus.BAD_REQUEST);
	}
	/*
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> exception(Exception exception) {
		Map<String, String> exMap = new HashMap<String, String>();
		exMap.put("message", exception.getMessage());
		exMap.put("localizedMassage", exception.getLocalizedMessage());
		return new ResponseEntity<> (exMap,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value={MethodArgumentNotValidException.class, TypeMismatchException.class})
    public ResponseEntity<?> handleException(Exception exception) {
		List<ObjectError> errors = new ArrayList<ObjectError>();
		if(exception instanceof MethodArgumentNotValidException){
			MethodArgumentNotValidException mnve = (MethodArgumentNotValidException) exception;
			errors = mnve.getBindingResult().getAllErrors();
		}else if(exception instanceof TypeMismatchException){
			TypeMismatchException tme = (TypeMismatchException) exception;
			ObjectError objectError = new ObjectError(tme.getErrorCode(), tme.getMessage());
			errors.add(objectError);
		}
		
		return new ResponseEntity<> (errors,HttpStatus.BAD_REQUEST);
    }*/
}
