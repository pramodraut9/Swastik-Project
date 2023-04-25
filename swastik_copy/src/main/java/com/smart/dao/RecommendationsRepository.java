package com.smart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smart.Entity.Recommendation;

@Repository
public interface RecommendationsRepository extends JpaRepository<Recommendation, Integer>{

}
