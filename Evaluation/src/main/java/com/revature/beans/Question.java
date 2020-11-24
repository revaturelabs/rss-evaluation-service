//This is a question bean which is a dummy bean used to send only questions and their options without correct answers to the front-end for security purposes. 
//So that no one hack the JSON object and get the correct answers.
package com.revature.beans;

import java.util.List;

import com.revature.entity.Option;

public class Question {
	
	private long questionId;
	
	private int questionValue;
	
	private String question;
	
	private List<Option> options;
	
//	private List<String> options;
	
//	private String option1;
//	
//	private String option2;
//	
//	private String option3;
//	
//	private String option4;
//	
//	private String option5;
	
	private String selectedAnswer;
	
	private String userEmail;

	public Question() {
		super();
	}

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	public int getQuestionValue() {
		return questionValue;
	}

	public void setQuestionValue(int questionValue) {
		this.questionValue = questionValue;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
//	public List<String> getOptions() {
//		return options;
//	}
//
//	public void setOptions(List<String> options) {
//		this.options = options;
//	}
	
	public void setOptions(List<Option> list) {
		this.options = list;
	}
	public List<Option> getOptions() {
		return options;
	}
	
//
//	public String getOption1() {
//		return option1;
//	}
//
//	public void setOption1(String option1) {
//		this.option1 = option1;
//	}
//
//	public String getOption2() {
//		return option2;
//	}
//
//	public void setOption2(String option2) {
//		this.option2 = option2;
//	}
//
//	public String getOption3() {
//		return option3;
//	}
//
//	public void setOption3(String option3) {
//		this.option3 = option3;
//	}
//
//	public String getOption4() {
//		return option4;
//	}
//
//	public void setOption4(String option4) {
//		this.option4 = option4;
//	}
//
//	public String getOption5() {
//		return option5;
//	}
//
//	public void setOption5(String option5) {
//		this.option5 = option5;
//	}
	
	

	public String getSelectedAnswer() {
		return selectedAnswer;
	}

	public void setSelectedAnswer(String selectedAnswer) {
		this.selectedAnswer = selectedAnswer;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionValue=" + questionValue + ", question=" + question
				+ ", options=" + options + ", selectedAnswer=" + selectedAnswer + ", userEmail=" + userEmail + "]";
	}

	
//	@Override
//	public String toString() {
//		return "Question [questionId=" + questionId + ", questionValue=" + questionValue + ", question=" + question
//				+ ", option1=" + option1 + ", option2=" + option2 + ", option3=" + option3 + ", option4=" + option4
//				+ ", option5=" + option5 + ", selectedAnswer=" + selectedAnswer + ", userEmail=" + userEmail + "]";
//	}

}
