package com.user.payload;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder    // follow builder pattern to build the object of this class...
public class ApiResponse {
	
	public String message;
	public boolean success;
	public HttpStatus status;

}
