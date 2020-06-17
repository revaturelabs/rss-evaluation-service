package com.revature.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="USER_QUIZ_SCORE")
public class UserQuizScore {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="USER_QUIZ_SEQ")
	@Column(name="USER_SCORE_ID")
	private long userScoreId;
	
	@Column(name="USER_EMAIL", nullable=false)
	private String userEmail;
	
	@Column(name="USER_SCORE", nullable=false)
	private int userScore;
	
	@Column(name="SUBMIT_DATE", nullable=false, columnDefinition="TimeStamp")
	private Timestamp submitDate;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "QUIZ_ID")
    private Quiz quiz;

	public long getUserScoreId() {
		return userScoreId;
	}

	public void setUserScoreId(long userScoreId) {
		this.userScoreId = userScoreId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public int getUserScore() {
		return userScore;
	}

	public void setUserScore(int userScore) {
		this.userScore = userScore;
	}

	public Timestamp getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Timestamp submitDate) {
		this.submitDate = submitDate;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	
	
}
