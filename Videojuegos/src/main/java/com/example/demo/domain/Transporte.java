package com.example.demo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="transporte",schema="formacion")
public class Transporte implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private int numero_vehiculos;
	@JsonBackReference
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name = "transporte_distribuidor",schema="formacion",
			joinColumns = { @JoinColumn(name = "transporte_id", referencedColumnName = "id", nullable = false, updatable = false)},
			inverseJoinColumns = { @JoinColumn(name = "distribuidor_id", referencedColumnName = "id", nullable = false, updatable = false)})
	private List<Distribuidor> distribuidor = new ArrayList<>();
	public Transporte() {}
	public Transporte(String nombre, int numero_vehiculos, int id_transporte) {
		super();
		this.nombre = nombre;
		this.numero_vehiculos = numero_vehiculos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNumero_vehiculos() {
		return numero_vehiculos;
	}
	public void setNumero_vehiculos(int numero_vehiculos) {
		this.numero_vehiculos = numero_vehiculos;
	}
	public List<Distribuidor> getDistribuidor() {
		return distribuidor;
	}
	@Override
	public String toString() {
		return "Transporte [id=" + id + ", nombre=" + nombre + ", numero_vehiculos=" + numero_vehiculos + "]";
	}
}
	