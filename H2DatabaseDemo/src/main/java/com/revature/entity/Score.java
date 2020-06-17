package com.revature.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name="QUIZ_SCORE")
public class Score {
		
	@Column(name = "ACCOUNT_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "SCORE")
	private int score;
	@Column(name = "QUIZ_ID")
	private long quizid;
	@Column(name = "SUBMIT_DATE")
	private java.sql.Timestamp date;
	
	@PrePersist
	protected void prePersist() {
		if (this.date == null) {
			long millis = System.currentTimeMillis();
			java.sql.Timestamp ts = new java.sql.Timestamp(millis);
			this.date = ts;
		}
	}

	public Score() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public long getQuizid() {
		return quizid;
	}

	public void setQuizid(long quizid) {
		this.quizid = quizid;
	}

	public java.sql.Timestamp getDate() {
		return date;
	}

	public void setDate(java.sql.Timestamp date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Score [id=" + id + ", email=" + email + ", score=" + score + ", quizid=" + quizid + ", date=" + date
				+ "]";
	}

		 

}

