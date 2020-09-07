package com.fis.ms.controller.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ConstructResponseEntity {
	

	public static ResponseEntity<ApiResponse> getResponseEntity(String errorDesc, HttpStatus status, Object responseData)
	{
		ApiResponse response = new ApiResponse();
		response.setErrorDesc(errorDesc);
		response.setResponseData(responseData);
		return new ResponseEntity<ApiResponse>(response, status);
	}

	public static ResponseEntity<ApiResponse> getResponseEntity(String errorDesc, HttpStatus status)
	{
		ApiResponse response = new ApiResponse();
		response.setErrorDesc(errorDesc);
		return new ResponseEntity<ApiResponse>(response, status);
	}
}
