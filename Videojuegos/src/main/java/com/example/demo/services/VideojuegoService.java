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
		return videojuegoRepository.BuscarTodos();
	}
	public List<Videojuego> buscar(String consulta){
		return videojuegoRepository.findByNombreContaining(consulta);
	}
	
	public List<Videojuego> buscarPorDistribuidor(int distribuidorId){
		return videojuegoRepository.buscarPorDistribuidor(distribuidorId);
	}
	
	public Videojuego guardar(Videojuego videojuego) {
		return videojuegoRepository.save(videojuego);
	}
}
