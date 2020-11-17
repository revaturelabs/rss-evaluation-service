package com.revature.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Option {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="OPTIONS_SEQ")
	private long optid;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "QUESTION_ID")
	private QuestionsBank qb;
	
	Option(){
		super();
	}

	public long getOptid() {
		return optid;
	}

	public void setOptid(long optid) {
		this.optid = optid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public QuestionsBank getQb() {
		return qb;
	}

	public void setQb(QuestionsBank qb) {
		this.qb = qb;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (optid ^ (optid >>> 32));
		result = prime * result + ((qb == null) ? 0 : qb.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Option other = (Option) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (optid != other.optid)
			return false;
		if (qb == null) {
			if (other.qb != null)
				return false;
		} else if (!qb.equals(other.qb))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Option [optid=" + optid + ", description=" + description  + "]";
	}

	

}
