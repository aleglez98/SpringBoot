package com.example.demo.domain;

import javax.persistence.*;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="videojuego",schema="formacion")
public class Videojuego {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String descripcion;
	private String imagenUrl;
	private String categoria;
	@ManyToOne
	@JsonIgnoreProperties
	private Distribuidor distribuidor;
	@ManyToOne
	private Estado estado;
	
	public Videojuego() {
		nombre= null;
		descripcion = null;
		imagenUrl = null;
		categoria = null;
		distribuidor= new Distribuidor();
		estado= new Estado();
	}
	
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
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Estado getEstado() {
		return estado;
	}
	
	@Override
	public String toString() {
		return "Videojuego [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", imagenUrl="
				+ imagenUrl + ", categoria=" + categoria + ", distribuidor=" + distribuidor + ", estado=" + estado
				+ "]";
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

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
}
