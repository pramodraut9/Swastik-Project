package com.smart.service;

import java.util.List;
import java.util.Optional;

import com.smart.Entity.Recommendation;

public interface RecommendationsService {

	public List<Recommendation>FindAll();
	
	public Optional<Recommendation>FindById(int theId);
	
	public void save(Recommendation rec);
	
	public String DeleteById(int theId);
}
