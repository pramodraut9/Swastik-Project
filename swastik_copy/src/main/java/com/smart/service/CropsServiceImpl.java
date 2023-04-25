package com.smart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.smart.Entity.Crops;
import com.smart.dao.CropsRepository;

import jakarta.transaction.Transactional;

@Service
public class CropsServiceImpl implements CropsService {
	
	@Autowired
	private CropsRepository cropsRepository;

	@Override
	@Transactional
	public List<Crops> FindAll() {
		
		return cropsRepository.findAll();
	}

	@Override
	@Transactional
	public Optional<Crops> findById(@PathVariable int theId) {
		
		Optional<Crops> thecrops = cropsRepository.findById(theId);
		
		if(thecrops == null)
		{
			
			throw new RuntimeException("Did Not Find Crop Id:--"+theId);
		}
		return thecrops;
	}

	@Override
	@Transactional
	public void save(Crops thecrops) {
		
		cropsRepository.save(thecrops);
		
	}

	@Override
	@Transactional
	public String deleteById(int theId) {
		
		cropsRepository.deleteById(theId);
		
		return "Deleted id"+theId;
		
	}

}
