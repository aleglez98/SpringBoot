package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Videojuego;

public interface VideojuegoRepository extends JpaRepository<Videojuego,Integer> {
	
}
