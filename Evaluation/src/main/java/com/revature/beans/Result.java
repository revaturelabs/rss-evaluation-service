//This is a result bean which is a dummy bean used only to send required result of quiz to the front-end and it is not persisted in table.
package com.revature.beans;

public class Result {

	private int totalQuestions;
	
	private  int correctAnswers;
	
	private int totalPoints;

	public Result() {
		super();
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
		return "Result [totalQuestions=" + totalQuestions + ", correctAnswers="
				+ correctAnswers + ", totalPoints=" + totalPoints + "]";
	}
	
}
