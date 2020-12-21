package com.example.demo.controllers;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


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
}
