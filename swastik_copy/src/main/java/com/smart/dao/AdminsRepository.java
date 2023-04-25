package com.smart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smart.Entity.Admins;

@Repository
public interface AdminsRepository extends JpaRepository<Admins, Integer> {

}
