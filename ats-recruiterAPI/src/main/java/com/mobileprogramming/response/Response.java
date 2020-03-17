package com.mobileprogramming.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mobileprogramming.model.Recruiter;
import com.mobileprogramming.model.TeamLead;

@JsonInclude(value = Include.NON_NULL)
public class Response<T> {
	private Boolean success;
	private String message;
	
	private Boolean status;
	
	private TeamLead teamLead;
	
	private Recruiter recruiter;
	public Recruiter getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(Recruiter recruiter) {
		this.recruiter = recruiter;
	}

	private String role;
	
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

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public TeamLead getTeamLead() {
		return teamLead;
	}

	public void setTeamLead(TeamLead teamLead) {
		this.teamLead = teamLead;
	}

}
