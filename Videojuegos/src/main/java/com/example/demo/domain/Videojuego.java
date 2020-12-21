package com.example.demo.domain;

import javax.persistence.*;
import javax.persistence.Id;


@Entity
@Table(name="videojuego",schema="formacion")
public class Videojuego {
	@Id
	private Integer id;
	private String nombre;
	private String descripcion;
	private String imagenUrl;
	@ManyToOne
	private Distribuidor distribuidor;
	
	public Distribuidor getDistribuidor() {
		return distribuidor;
	}
	public void setDistribuidor(Distribuidor distribuidor) {
		this.distribuidor = distribuidor;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Videojuego [nombre=" + nombre + ", descripcion=" + descripcion + ", imagenUrl=" + imagenUrl + "]";
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getImagenUrl() {
		return imagenUrl;
	}
	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}
	
}
