package com.smart.service;

import java.util.List;
import java.util.Optional;


import com.smart.Entity.Farmers;

public interface FarmersService {

	public  List<Farmers>FindAll();
	
	public Optional<Farmers> findById(int theId);

	public void save(Farmers thefarmers);
	
	public String deleteById(int theId);
}
