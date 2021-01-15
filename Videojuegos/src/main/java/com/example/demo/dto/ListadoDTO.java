package com.example.demo.dto;

import java.io.Serializable;

import java.util.*;

public class ListadoDTO implements Serializable{
	
	List<VideojuegoDTO> videojuego = new ArrayList<>();

	public List<VideojuegoDTO> getVideojuego() {
		return videojuego;
	}

	public void setVideojuego(List<VideojuegoDTO> videojuego) {
		this.videojuego = videojuego;
	}

}
