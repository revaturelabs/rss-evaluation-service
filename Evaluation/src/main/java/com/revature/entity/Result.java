package com.revature.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Result {
	
	@Id
	private int resultId;
	
	private int totalQuestions;
	
	private  int correctAnswers;
	
	private int totalPoints;

	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getResultId() {
		return resultId;
	}

	public void setResultId(int resultId) {
		this.resultId = resultId;
	}

	public int getTotalQuestions() {
		return totalQuestions;
	}

	public void setTotalQuestions(int totalQuestions) {
		this.totalQuestions = totalQuestions;
	}

	public int getCorrectAnswers() {
		return correctAnswers;
	}

	public void setCorrectAnswers(int correctAnswers) {
		this.correctAnswers = correctAnswers;
	}

	public int getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}

	@Override
	public String toString() {
		return "Result [resultId=" + resultId + ", totalQuestions=" + totalQuestions + ", correctAnswers="
				+ correctAnswers + ", totalPoints=" + totalPoints + "]";
	}
	
}
