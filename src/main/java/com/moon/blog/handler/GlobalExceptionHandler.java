package com.moon.blog.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.moon.blog.dto.ResponseDto;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

	@ExceptionHandler(value=Exception.class)
	public ResponseDto handleArgumentException(Exception e) {
		return new ResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseDto processValidationError(MethodArgumentNotValidException ex) {
	    return new ResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(),  ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
	}
}
