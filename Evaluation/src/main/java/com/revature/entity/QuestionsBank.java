//This is a questionBank entity which going to make QUESTIONS_BANK table in database and create Many-to-One relationship with QUIZZES table.
package com.revature.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="QUESTIONS_BANK")
public class QuestionsBank {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="QUESTIONS_BANK_SEQ")
	@Column(name="QUESTION_ID")
	private long questionId;
	
	@Column(name="QUESTION_VALUE", nullable=false)
	private int questionValue;
	
	@Column(name="QUESTION", nullable=false)
	private String question;
	
	@OneToMany(mappedBy="qb")
	private List<Option> options;

	
//	@Column(name="Option_1", nullable=false)
//	private String option1;
//	
//	@Column(name="Option_2", nullable=false)
//	private String option2;
//	
//	@Column(name="Option_3", nullable=true)
//	private String option3;
//	
//	@Column(name="Option_4", nullable=true)
//	private String option4;
//	
//	@Column(name="Option_5", nullable=true)
//	private String option5;
	
	@Column(name="CORRECT_ANSWER", nullable=false)
	private String correctAnswer;
	
	//We create one transient field for quizId.
	//It will take input from front-end and do the rest of the process which help to maintain relationship with QUIZZES table.
	//private transient Long quizId;
		
	//We create unidirectional Many-To-One relationship from QUESTIONS_BANK table to QUIZZES table where quiz_id is a foreign key in QUESTIONS_BANK table
	@ManyToOne
    @JoinColumn(name = "QUIZ_ID")
    private Quiz quiz;
	

	public QuestionsBank() {
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
	public void setOptions(List<Option> options) {
		this.options = options;
	}
	public List<Option> getOptions() {
		return options;
	}
	

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

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public Quiz getQuiz() {
		return quiz;
	}


	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

//	public Long getQuizId() {
//		return quizId;
//	}
//
//	public void setQuizId(Long quizId) {
//		this.quizId = quizId;
//	}

	@Override
	public String toString() {
		return "QuestionsBank [questionId=" + questionId + ", questionValue=" + questionValue + ", question=" + question
				+ ", options=" + options + ", correctAnswer=" + correctAnswer + "]";
	}


//	@Override
//	public String toString() {
//		return "QuestionsBank [questionId=" + questionId + ", questionValue=" + questionValue + ", question=" + question
//				+ ", option1=" + option1 + ", option2=" + option2 + ", option3=" + option3 + ", option4=" + option4
//				+ ", option5=" + option5 + ", correctAnswer=" + correctAnswer + ", quiz=" + quizId + "]";
//	}

	

}


