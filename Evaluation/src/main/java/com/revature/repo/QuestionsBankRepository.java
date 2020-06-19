package com.revature.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.revature.entity.QuestionsBank;
import com.revature.entity.Quiz;

public interface QuestionsBankRepository extends JpaRepository<QuestionsBank, Long>, CrudRepository<QuestionsBank, Long> {

	public List<QuestionsBank> findQuestionsByQuiz(Quiz q);

}
