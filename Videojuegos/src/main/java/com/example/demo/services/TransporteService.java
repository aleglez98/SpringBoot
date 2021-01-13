package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.repository.TransporteRepository;

@Service
public class TransporteService {
	
	private final TransporteRepository transporteRepository;
	
	TransporteService(TransporteRepository transporteRepository){
		this.transporteRepository = transporteRepository;
	}
}
