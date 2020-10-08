package com.revature.entity;

import java.util.Optional;

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
	
	@Column(name = "USER_ANSWER", nullable=false)
	private String userAnswer;
	
	@ManyToOne
	@JoinColumn(name = "QUESTION_ID")
	private QuestionsBank question;
	
	@ManyToOne
	@JoinColumn(name = "USER_SCORE_ID")
	private UserQuizScore userScore;
	
	//We create unidirectional Many-To-One relationship from QUESTIONS_BANK table to QUIZZES table where quiz_id is a foreign key in QUESTIONS_BANK table
//	@ManyToOne
//	@JoinColumn(name = "QUIZ_ID")
//	private Quiz quiz;
	

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


	public QuestionsBank getQuestion() {
		return question;
	}


	public void setQuestion(QuestionsBank question) {
		this.question = question;
	}


	public UserQuizScore getUserScore() {
		return userScore;
	}


	public void setUserScore(UserQuizScore userScore) {
		this.userScore = userScore;
	}

	
//	public Quiz getQuiz() {
//		return quiz;
//	}
//
//
//	public void setQuiz(Quiz quiz) {
//		this.quiz = quiz;
//	}


	@Override
	public String toString() {
		return "AnswersBank [answerId=" + answerId + ", userAnswer=" + userAnswer + ", question=" + question
				+ ", userScore=" + userScore + "]";
	}



}