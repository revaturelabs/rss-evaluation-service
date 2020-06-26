//This is a subject entity which going to make SUBJECTS table in database.
package com.revature.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SUBJECTS")
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="SUBJECT_SEQ")
	@Column(name="SUBJECT_ID")
	private long subjectId;
	
	@Column(name="SUBJECT_NAME", unique=true)
	private String subjectName;
	
	public Subject() {
		super();
	}
	
	public Subject(long subjectId, String subjectName) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
	}

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subjectName=" + subjectName + "]";
	}
	
}
