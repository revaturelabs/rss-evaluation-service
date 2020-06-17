package com.revature.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.revature.entity.QuestionsBank;

public interface QuestionsBankRepository extends JpaRepository<QuestionsBank, Long>, CrudRepository<QuestionsBank, Long> {

}
