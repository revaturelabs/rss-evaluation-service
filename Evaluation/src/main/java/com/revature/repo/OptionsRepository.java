package com.revature.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.entity.Option;

@Repository
public interface OptionsRepository extends JpaRepository<Option, Long>{

}
