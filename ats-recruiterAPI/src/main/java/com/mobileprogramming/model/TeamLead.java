package com.mobileprogramming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TeamLead {
	
		@Id
		//@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="TL_ID")
		private int id;
		
		@Column(name="TL_NAME")
	   private String name;
		
		
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
		
}
