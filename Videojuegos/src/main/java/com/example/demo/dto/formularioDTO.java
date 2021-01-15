package com.example.demo.dto;

import java.io.Serializable;

public class formularioDTO implements Serializable{
	
	private String nombre;
	private String categoria;
	private Integer estado;
	private Integer distribuidor;
	private Integer transporte;
	
	public formularioDTO() {
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
	public Integer getTransporte() {
		return transporte;
	}
	public void setTransporte(Integer transporte) {
		this.transporte = transporte;
	}
	
	
}
