package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Videojuego;
import com.example.demo.services.DistribuidorService;
import com.example.demo.services.VideojuegoService;

@Controller
public class VideojuegoAbmController {
	
	private final DistribuidorService distribuidorService;
	private final VideojuegoService videojuegoService;
	
	public VideojuegoAbmController(DistribuidorService distribuidorService,VideojuegoService videojuegoService) {
		super();
		this.distribuidorService = distribuidorService;
		this.videojuegoService = videojuegoService;
	}

	@RequestMapping("/videojuegos/crear")
	public String mostrarFormAlta(Model model){
		model.addAttribute("distribuidores",distribuidorService.buscarTodos());
		model.addAttribute("videojuego", new Videojuego());
		Videojuego video = new Videojuego();
		System.out.println(video);
		return "/formvideojuego";
	}
	
	@PostMapping("/videojuegos/guardar")
	public String guardar(Videojuego videojuego) {
		System.out.println(videojuego);
		videojuegoService.guardar(videojuego);
		return "redirect:/";
	}
	
}
