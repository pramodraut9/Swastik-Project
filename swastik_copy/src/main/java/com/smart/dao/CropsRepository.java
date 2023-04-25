package com.smart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smart.Entity.Crops;

@Repository
public interface CropsRepository extends JpaRepository<Crops, Integer>{

}
