//This is a UserQuizScore entity which going to make USER_QUIZ_SCORE table in database and create Many-to-One relationship with QUIZZES table.
package com.revature.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private Date submitDate;
	

	

	
	//We create one transient field for quizId.
	//It will take input from front-end and do the rest of the process which help to maintain relationship with QUIZZES table.
	private transient Long quizId;
	
	//We create unidirectional Many-To-One relationship from USER_QUIZ_SCORE table to QUIZZES table where quiz_id is a foreign key in USER_QUIZ_SCORE table
	@ManyToOne
    @JoinColumn(name = "QUIZ_ID")
    private Quiz quiz;
	
	

	public UserQuizScore() {
		super();
		
	}
	


	public UserQuizScore(long userScoreId, String userEmail, int userScore, Date submitDate, Long quizId, Quiz quiz) {
		super();
		this.userScoreId = userScoreId;
		this.userEmail = userEmail;
		this.userScore = userScore;
		this.submitDate = submitDate;
		this.quizId = quizId;
		this.quiz = quiz;
	}



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

	public Date getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public Long getQuizId() {
		return quizId;
	}

	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}


	@Override
	public String toString() {
		return "UserQuizScore [userScoreId=" + userScoreId + ", userEmail=" + userEmail + ", userScore=" + userScore
				+ ", submitDate=" + submitDate + ", quizId=" + quizId + "]";
	}
	
	





	




	
}
