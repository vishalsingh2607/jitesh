package com.mobileprogramming.model;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Status {
	
	@Id
   private int id;
	private boolean status;
	

	
	public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}



	
	public Status()
	{
		
	}
	
	public Status(int id, boolean status) {
		
		this.id = id;
		this.status = status;
		
	}
	
	
}
