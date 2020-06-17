package com.revature.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.entity.Score;

@Repository
public interface ScoreDAO extends JpaRepository<Score, Long>{

}
