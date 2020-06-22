package com.revature.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.revature.entity.UserQuizScore;

public interface UserQuizScoreRepository extends JpaRepository<UserQuizScore, Long>, CrudRepository<UserQuizScore, Long> {
	
	public List<UserQuizScore> findQuizByUserEmail(String userEmail);
}
