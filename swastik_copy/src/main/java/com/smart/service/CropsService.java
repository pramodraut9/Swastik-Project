package com.smart.service;

import java.util.List;
import java.util.Optional;

import com.smart.Entity.Crops;

public interface CropsService {

	public  List<Crops>FindAll();
	
	public Optional<Crops> findById(int theId);

	public void save(Crops thecrops);
	
	public String deleteById(int theId);
	

	
}
