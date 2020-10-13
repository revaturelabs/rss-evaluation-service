//This is a quiz entity which going to make QUIZZES table in database and create Many-to-One relationship with SUBJECTS table.
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
@Table(name="QUIZZES")
public class Quiz {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="QUIZ_SEQ")
	@Column(name="QUIZ_ID")
	private long quizId;
	
	@Column(name="QUIZ_TOPIC", nullable=false)
	private String quizTopic;
	
	@Column(name="QUIZ_DESCRIPTION", nullable=true)
	private String quizDescription;
	
	@Column(name="QUIZ_TOTAL_POINTS", nullable=true)
	private int quizTotalPoints;
	
	@Column(name="QUIZ_DIFFICULTY", nullable=true)
	private String quizDifficulty;
	
	
	@Column(name="CREATOR_EMAIL", nullable=false)
	private String creatorEmail;
	
	//We create one transient field for subjectId.
	//It will take input from front-end and do the rest of the process which help to maintain relationship with SUBJECTS table. 
	private transient Long subjectId;
	
	//We create unidirectional Many-To-One relationship from QUIZZES table to SUBJECTS table where subject_id is a foreign key in QUIZZES table
	@ManyToOne
    @JoinColumn(name = "SUBJECT_ID")
    private Subject subject;
	

	public Quiz() {
		super();
	}
	


	public Quiz(long quizId, String quizTopic, String quizDescription, int quizTotalPoints, String quizDifficulty,
			String creatorEmail, Long subjectId, Subject subject) {
		super();
		this.quizId = quizId;
		this.quizTopic = quizTopic;
		this.quizDescription = quizDescription;
		this.quizTotalPoints = quizTotalPoints;
		this.quizDifficulty = quizDifficulty;
		this.creatorEmail = creatorEmail;
		this.subjectId = subjectId;
		this.subject = subject;
	}


	public long getQuizId() {
		return quizId;
	}

	public void setQuizId(long quizId) {
		this.quizId = quizId;
	}

	public String getQuizTopic() {
		return quizTopic;
	}

	public void setQuizTopic(String quizTopic) {
		this.quizTopic = quizTopic;
	}

	public String getQuizDescription() {
		return quizDescription;
	}

	public void setQuizDescription(String quizDescription) {
		this.quizDescription = quizDescription;
	}

	public String getCreatorEmail() {
		return creatorEmail;
	}

	public void setCreatorEmail(String creatorEmail) {
		this.creatorEmail = creatorEmail;
	}
	
	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	
	public int getQuizTotalPoints() {
		return quizTotalPoints;
	}

	
	public void setQuizTotalPoints(int quizTotalPoints) {
		this.quizTotalPoints = quizTotalPoints;
	}

	
	public String getQuizDifficulty() {
		return quizDifficulty;
	}


	public void setQuizDifficulty(String quizDifficulty) {
		this.quizDifficulty = quizDifficulty;
	}



	@Override
	public String toString() {
		return "Quiz [quizId=" + quizId + ", quizTopic=" + quizTopic + ", quizDescription=" + quizDescription
				+ ", quizTotalPoints=" + quizTotalPoints + ", quizDifficulty=" + quizDifficulty + ", creatorEmail="
				+ creatorEmail + ", subject=" + subject + "]";
	}


		
	
}
