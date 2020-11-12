package com.revature.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Option {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long optid;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="QUESTION_ID")
	private QuestionsBank qb;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
