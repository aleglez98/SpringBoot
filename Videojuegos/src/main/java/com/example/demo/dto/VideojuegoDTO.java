package com.example.demo.dto;

import java.io.Serializable;
import java.util.List;


public class VideojuegoDTO implements Serializable {

	private String nombre;
	private String estado;
	private String categoria;
	private String distribuidor;
	private List<String> transportes;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getDistribuidor() {
		return distribuidor;
	}
	public void setDistribuidor(String distribuidor) {
		this.distribuidor = distribuidor;
	}
	public List<String> getTransportes() {
		return transportes;
	}
	public void setTransportes(List<String> transportes) {
		this.transportes = transportes;
	}
	
	
}
