package com.example.demo.dto;

import java.io.Serializable;
import java.util.List;

public class FormularioDTO implements Serializable{
	
	private String nombre;
	private String categoria;
	private Integer estado;
	private Integer distribuidor;
	private List<String> transporte;
	
	public FormularioDTO() {
		super();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	public Integer getDistribuidor() {
		return distribuidor;
	}
	public void setDistribuidor(Integer distribuidor) {
		this.distribuidor = distribuidor;
	}
	public List<String> getTransporte() {
		return transporte;
	}
	public void setTransporte(List<String> transporte) {
		this.transporte = transporte;
	}
	
	
}
