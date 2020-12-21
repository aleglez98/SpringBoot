package com.example.vdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ListadoController {
	
	@RequestMapping("/")
	public String listarVideojuegos() {
		//Busqueda de videojuegos
		return "listado";
	}
}
