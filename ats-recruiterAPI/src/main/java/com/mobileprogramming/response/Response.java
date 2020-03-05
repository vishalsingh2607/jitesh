package com.mobileprogramming.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class Response<T> {
	private Boolean success;
	private String message;
	private T response;
	private T[] responses;
	
	public T[] getResponses() {
		return responses;
	}

	public void setResponses(T[] responses) {
		this.responses = responses;
	}

	

	public T getResponse() {
		return response;
	}

	public void setResponse(T response) {
		this.response = response;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

}
