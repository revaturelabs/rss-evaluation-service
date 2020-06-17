package com.revature.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	
	@Column(name="CREATOR_EMAIL", nullable=false)
	private String creatorEmail;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SUBJECT_ID")
    private Subject subject;
	
	@OneToMany(mappedBy = "quiz")
	private List<UserQuizScore> uqsList;
	
	@OneToMany(mappedBy = "quizQuestion")
	private List<QuestionsBank> qbList;

	public List<UserQuizScore> getUqsList() {
		return uqsList;
	}

	public void setUqsList(List<UserQuizScore> uqsList) {
		this.uqsList = uqsList;
	}

	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
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

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public List<QuestionsBank> getQbList() {
		return qbList;
	}

	public void setQbList(List<QuestionsBank> qbList) {
		this.qbList = qbList;
	}
	
	
}
