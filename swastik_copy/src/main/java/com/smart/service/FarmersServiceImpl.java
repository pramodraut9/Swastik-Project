package com.smart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.Entity.Farmers;
import com.smart.dao.FarmersRepository;

import jakarta.transaction.Transactional;

@Service
public class FarmersServiceImpl implements FarmersService {

	@Autowired
	private FarmersRepository farmersRepository;
	
	@Override
	@Transactional
	public List<Farmers> FindAll() {
		
		return farmersRepository.findAll();
	}

	@Override
	@Transactional
	public Optional<Farmers> findById(int theId) {
		
		Optional<Farmers> thefarmers = farmersRepository.findById(theId);
	
		
		if(thefarmers == null)
		{
			
			throw new RuntimeException("Did Not Find Farmer Id:--"+theId);
		}
		return thefarmers;
	}

	@Override
	@Transactional
	public void save(Farmers thefarmers) {
		
		farmersRepository.save(thefarmers);
		
	}

	@Override
	@Transactional
	public String deleteById(int theId) {
		
		return "Deleted Id " +theId;
	}

}
