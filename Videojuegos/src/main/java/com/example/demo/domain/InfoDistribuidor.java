package com.example.demo.domain;

import javax.persistence.*;

@Entity
@Table(name="InfoDistribuidor",schema="formacion")
public class InfoDistribuidor {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	private String cif;
	private String ciudad;
	private String pais;
	private String telefono;
	public InfoDistribuidor() {}
	public InfoDistribuidor(String cif, String ciudad, String pais, String telefono) {
		super();
		this.cif = cif;
		this.ciudad = ciudad;
		this.pais = pais;
		this.telefono = telefono;
	}
	public String getCif() {
		return cif;
	}
	public void setCif(String cif) {
		this.cif = cif;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	@Override
	public String toString() {
		return "InfoDistribuidor [id=" + id + ", cif=" + cif + ", ciudad=" + ciudad + ", pais=" + pais + ", telefono="
				+ telefono + "]";
	}
	
	
}
