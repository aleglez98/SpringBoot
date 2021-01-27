package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Estado;
import com.example.demo.domain.Transporte;
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
	public List<Videojuego> buscar(String consulta, String consulta1){
		return videojuegoRepository.findByNombreContainingOrCategoriaContaining(consulta,consulta1);
	}
	public List<Videojuego> buscarPorNombre(String consulta){
		return videojuegoRepository.findByNombreContaining(consulta);
	}
	
	public List<Videojuego> buscarPorDistribuidor(String distribuidorId){
		return videojuegoRepository.buscarPorDistribuidor(distribuidorId);
	}
	
	public List<Videojuego> buscarPorCategoria(String d){
		return videojuegoRepository.findByCategoriaContaining(d);
	}
	
	public Videojuego guardar(Videojuego videojuego) {
		return videojuegoRepository.save(videojuego);
	}

	public List<Videojuego> buscarPorEstado(String id) {
		return videojuegoRepository.buscarPorEstado(id);
	}

	public List<String> buscarTodasCategorias() {
		List<String> categorias = new ArrayList<>();
		String categoria = null;
		categorias.add(categoria);
		categorias.addAll(videojuegoRepository.buscarCategorias());
		return categorias;
	}

	public List<Videojuego> buscarPorTransporte(Transporte string,List<Transporte> transportes) {
		return videojuegoRepository.buscarPorTransporte(string,transportes);
	}

}
