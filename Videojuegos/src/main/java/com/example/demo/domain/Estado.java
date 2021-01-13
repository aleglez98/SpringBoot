package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estado",schema="formacion")
public class Estado {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	private String estado;
	public Estado(String estado) {
		super();
		this.estado = estado;
	}
	public Estado() {
		super();
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Estado [id=" + id + ", estado=" + estado + "]";
	}
}
