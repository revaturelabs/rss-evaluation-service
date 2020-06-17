package com.revature.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.revature.entity.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long>, CrudRepository<Quiz, Long> {

}
