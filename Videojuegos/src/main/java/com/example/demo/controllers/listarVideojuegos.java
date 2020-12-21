package com.example.demo.controllers;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Videojuego;
import com.example.demo.services.VideojuegoService;


@Controller
public class listarVideojuegos {
	
	private final VideojuegoService videojuegoService;
	
	public listarVideojuegos(VideojuegoService videojuegoService) {
		super();
		this.videojuegoService = videojuegoService;
	}

	
	@RequestMapping("/")
	public String ListarVideojuegos(Model model) {
		List<Videojuego> destacados = videojuegoService.buscarDestacados();
		model.addAttribute("videojuegos",destacados);
		return "listado";
	}
	
	@RequestMapping("/videojuegoPorDistribucion")
	public String listarVideojuegosPorDistribucion(int distribuidorId, Model model) {
		List<Videojuego> juegos = videojuegoService.buscarPorDistribuidor(distribuidorId);
		model.addAttribute("videojuegos",juegos);
		return "listado";
	}
	
	@RequestMapping("/buscar")
	public String buscar(@RequestParam("q") String consulta, Model model) {
		List<Videojuego> juegos = videojuegoService.buscar(consulta);
		model.addAttribute("videojuegos",juegos);
		return "listado";
	}
}
