package com.revature.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ANSWERS_BANK")
public class AnswersBank {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ANSWER_ID")
	private long answerId;
	
	@Column(name = "USER_ANSWER")
	private String userAnswer;
	
	@ManyToOne
	@JoinColumn(name = "QUESTION_ID")
	private QuestionsBank questionId;
	
	@ManyToOne
	@JoinColumn(name = "USER_SCORE_ID")
	private UserQuizScore userScoreId;
	

	public AnswersBank() {
		super();
	}


	public long getAnswerId() {
		return answerId;
	}


	public void setAnswerId(long answerId) {
		this.answerId = answerId;
	}


	public String getUserAnswer() {
		return userAnswer;
	}


	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}


	public QuestionsBank getQuestionId() {
		return questionId;
	}


	public void setQuestionId(QuestionsBank questionId) {
		this.questionId = questionId;
	}


	public UserQuizScore getUserScoreId() {
		return userScoreId;
	}


	public void setUserScoreId(UserQuizScore userScoreId) {
		this.userScoreId = userScoreId;
	}


	@Override
	public String toString() {
		return "AnswersBank [answerId=" + answerId + ", userAnswer=" + userAnswer + ", questionId=" + questionId
				+ ", userScoreId=" + userScoreId + "]";
	}

}