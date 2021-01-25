package com.example.demo.dto;

import java.io.Serializable;

import java.util.*;

import org.springframework.data.domain.Page;

public class ListadoDTO implements Serializable{
	
	private List<Integer> pageNumbers;
	private Integer TotalItems;
	private Integer TotalPages;
	private Page<VideojuegoDTO> listado;
	private FormularioDTO videojuego;
	
	
	public List<Integer> getPageNumbers() {
		return pageNumbers;
	}
	public void setPageNumbers(List<Integer> pageNumbers) {
		this.pageNumbers = pageNumbers;
	}
	public Integer getTotalItems() {
		return TotalItems;
	}
	public void setTotalItems(Integer totalItems) {
		TotalItems = totalItems;
	}
	public Integer getTotalPages() {
		return TotalPages;
	}
	public void setTotalPages(Integer totalPages) {
		TotalPages = totalPages;
	}
	public Page<VideojuegoDTO> getListado() {
		return listado;
	}
	public void setListado(Page<VideojuegoDTO> listado) {
		this.listado = listado;
	}
	public FormularioDTO getVideojuego() {
		return videojuego;
	}
	public void setVideojuego(FormularioDTO videojuego) {
		this.videojuego = videojuego;
	}

	

}
