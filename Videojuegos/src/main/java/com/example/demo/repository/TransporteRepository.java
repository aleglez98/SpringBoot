package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.domain.Transporte;

public interface TransporteRepository extends JpaRepository<Transporte, Integer> {
	List<Transporte> findBynombre(String name);
}
