package com.example.demo.dto;

import java.io.Serializable;

import java.util.*;

import org.springframework.data.domain.Page;

public class ListadoDTO implements Serializable{
	
	private List<Integer> pageNumbers;
	private Integer TotalItems;
	private Integer TotalPages;
	private Page<VideojuegoDTO> page;
	private VideojuegoDTO videojuego;
	
	
	
	public ListadoDTO(List<Integer> pageNumbers, Integer totalItems, Integer totalPages, Page<VideojuegoDTO> page, VideojuegoDTO videojuego) {
		super();
		this.pageNumbers = pageNumbers;
		this.TotalItems = totalItems;
		this.TotalPages = totalPages;
		this.page = page;
		this.setVideojuego(videojuego);
	}
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
	
	public Page<VideojuegoDTO> getPage() {
		return page;
	}
	public void setPage(Page<VideojuegoDTO> page) {
		this.page = page;
	}
	public VideojuegoDTO getVideojuego() {
		return videojuego;
	}
	public void setVideojuego(VideojuegoDTO videojuego) {
		this.videojuego = videojuego;
	}

	

}
