package com.smart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smart.Entity.Farmers;

@Repository
public interface FarmersRepository extends JpaRepository<Farmers, Integer> {

}
