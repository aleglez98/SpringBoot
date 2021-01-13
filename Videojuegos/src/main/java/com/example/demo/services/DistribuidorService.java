package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Distribuidor;
import com.example.demo.domain.Estado;
import com.example.demo.repository.DistribuidorRepository;

@Service
public class DistribuidorService {
	private final DistribuidorRepository distribuidorRepository;

	public DistribuidorService(DistribuidorRepository distribuidorRepositoy) {
		super();
		this.distribuidorRepository = distribuidorRepositoy;
	}
	
	public List<Distribuidor> buscarTodos(){
		List<Distribuidor> distribuciones = new ArrayList<>();
		Distribuidor distribuidor = new Distribuidor();
		distribuciones.add(distribuidor);
		distribuciones.addAll(distribuidorRepository.findAll());
		return distribuciones;
	}
}
