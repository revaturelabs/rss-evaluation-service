package com.revature.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.revature.entity.AnswersBank;

public interface AnswersBankRepository extends JpaRepository<AnswersBank,Long>, CrudRepository<AnswersBank,Long>{


}
