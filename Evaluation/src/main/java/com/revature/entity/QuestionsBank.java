//This is a questionBank entity which going to make QUESTIONS_BANK table in database and create Many-to-One relationship with QUIZZES table.
package com.revature.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
	
	@OneToMany(
		mappedBy="qb",
		cascade = CascadeType.ALL,
        orphanRemoval = true	
	)
	private List<Option> options = new ArrayList<Option>();
	
	@Column(name="CORRECT_ANSWER", nullable=false)
	private String correctAnswer;
	
	//We create one transient field for quizId.
	//It will take input from front-end and do the rest of the process which help to maintain relationship with QUIZZES table.
	//private transient Long quizId;
	
	transient long quizId;
	
	//We create unidirectional Many-To-One relationship from QUESTIONS_BANK table to QUIZZES table where quiz_id is a foreign key in QUESTIONS_BANK table
	@ManyToOne
    @JoinColumn(name = "QUIZ_ID")
    private Quiz quiz;
	

	public QuestionsBank() {
		super();
	}

		
	public long getQuizId() {
		return quizId;
	}


	public void setQuizId(long quizId) {
		this.quizId = quizId;
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


	public List<Option> getOptions() {
		return options;
	}


	public void setOptions(List<Option> options) {
		this.options = options;
	}


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


	@Override
	public String toString() {
		return "QuestionsBank [questionId=" + questionId + ", questionValue=" + questionValue + ", question=" + question
				 + ", correctAnswer=" + correctAnswer + "]";
	}

	
	public void addOption(Option option) {
		this.options.add(option);
		option.setQb(this);
	}
	
	public void removeOption(Option option) {
		this.options.remove(option);
		option.setQb(null);
	}

}


