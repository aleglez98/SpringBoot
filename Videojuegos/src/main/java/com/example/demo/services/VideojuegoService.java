package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Videojuego;
import com.example.demo.repository.VideojuegoRepository;

@Service
public class VideojuegoService {
	
	private final VideojuegoRepository videojuegoRepository;
	
	public VideojuegoService(VideojuegoRepository videojuegoRepository){
		this.videojuegoRepository = videojuegoRepository;
	}
	
	public List<Videojuego> buscarDestacados(){
		return videojuegoRepository.findAll();
	}
}
