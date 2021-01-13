package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Estado;
import com.example.demo.repository.EstadoRepository;

@Service
public class EstadoService {

	private final EstadoRepository estadoRepository;

	public EstadoService(EstadoRepository estadoRepository) {
		super();
		this.estadoRepository = estadoRepository;
	}
	
	public List<Estado> buscarTodos(){
		List<Estado> estados = new ArrayList<>();
		Estado estado = new Estado();
		estados.add(estado);
		estados.addAll(estadoRepository.findAll());
		return estados;
	}
	

}
