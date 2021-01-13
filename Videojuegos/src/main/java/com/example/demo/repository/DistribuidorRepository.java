package com.example.demo.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.domain.Distribuidor;


public interface DistribuidorRepository extends JpaRepository<Distribuidor,Integer> {
	List<Distribuidor> findBynombre(String nombre);	
}
