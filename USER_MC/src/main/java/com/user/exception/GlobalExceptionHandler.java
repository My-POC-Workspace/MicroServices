package com.user.exception;

import org.apache.catalina.valves.rewrite.InternalRewriteMap.Escape;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.user.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserNotFound.class)
 	public ResponseEntity<ApiResponse> handlerUserNotFound(UserNotFound ex){
		
		String msg =  ex.getMessage();
		ApiResponse response = ApiResponse.builder().message(msg).success(true).status(HttpStatus.NOT_FOUND).build(); // It will build the apiresponse in one line...
		return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);

		
 	}
	
}
