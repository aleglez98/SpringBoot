package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "distribuidor",schema="formacion")
public class Distribuidor {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	private String nombre;
	private String sitioWeb;
	@ManyToOne
	private InfoDistribuidor infodistribuidor;
	@JsonManagedReference
	@ManyToMany(mappedBy = "distribuidor",fetch = FetchType.EAGER)
	private List<Transporte> transportes = new ArrayList<>();
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
	public String getSitioWeb() {
		return sitioWeb;
	}
	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}
	public List<Transporte> getTransportes() {
		return transportes;
	}
	@Override
	public String toString() {
		return "Distribuidor [id=" + id + ", nombre=" + nombre + ", sitioWeb=" + sitioWeb + ", infodistribuidor="
				+ infodistribuidor + ", transportes=" + transportes + "]";
	}
	
	
	
	
}
