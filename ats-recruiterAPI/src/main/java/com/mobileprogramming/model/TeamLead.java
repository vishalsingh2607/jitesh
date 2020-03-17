package com.mobileprogramming.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@JsonInclude(content = Include.NON_NULL)
public class TeamLead {
	
		@Id
		//@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="TL_ID")
		private int id;
		
		@Column(name="TL_NAME")
	   private String name;
		@JsonIgnore
	 transient List<Assigned>  assigneds;
		
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	
		public TeamLead(int id, String name) {
			
			this.id = id;
			this.name = name;
		}
	
		
		public TeamLead()
		{
			
		}
		public List<Assigned> getAssigneds() {
			return assigneds;
		}
		public void setAssigneds(List<Assigned> assigneds) {
			this.assigneds = assigneds;
		}
		
		
}
