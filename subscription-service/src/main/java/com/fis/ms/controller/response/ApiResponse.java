package com.fis.ms.controller.response;

public class ApiResponse {

	private String errorDesc;
	private Object responseData;
	
	public String getErrorDesc() {
		return errorDesc;
	}
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
	
	public Object getResponseData() {
		return responseData;
	}
	
	public void setResponseData(Object responseData) {
		this.responseData = responseData;
	}
}
