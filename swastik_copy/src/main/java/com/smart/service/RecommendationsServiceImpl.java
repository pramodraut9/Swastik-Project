package com.smart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.Entity.Crops;
import com.smart.Entity.Recommendation;
import com.smart.dao.RecommendationsRepository;

import jakarta.transaction.Transactional;

@Service
public class RecommendationsServiceImpl implements RecommendationsService {

	@Autowired
	private RecommendationsRepository recommendationsRepository;
	
	
	@Override
	@Transactional
	public List<Recommendation> FindAll() {
		
		return recommendationsRepository.findAll();
	}

	@Override
	@Transactional
	public Optional<Recommendation> FindById(int theId) {
		
    Optional<Recommendation> rec = recommendationsRepository.findById(theId);
		
		if(rec == null)
		{
			
			throw new RuntimeException("Did Not Find Farmer Id:--"+theId);
		}
		return rec;
	}
	

	@Override
	@Transactional
	public void save(Recommendation rec) { 
		
		recommendationsRepository.save(rec);
	}

	@Override
	@Transactional
	public String DeleteById(int theId) {
		
		recommendationsRepository.deleteById(theId);
		
		return "Deleted Recommenmdation Id :"+theId;
	}



}
