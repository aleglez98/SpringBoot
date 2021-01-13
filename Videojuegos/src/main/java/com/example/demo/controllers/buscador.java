package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.Distribuidor;
import com.example.demo.domain.Estado;
import com.example.demo.domain.Transporte;
import com.example.demo.domain.Videojuego;
import com.example.demo.services.DistribuidorService;
import com.example.demo.services.EstadoService;
import com.example.demo.services.VideojuegoService;


@Controller
public class buscador {
	
	
	private final EstadoService estadoService;
	private final VideojuegoService videojuegoService;
	private final DistribuidorService distribuidorService;

	
	
	public buscador(EstadoService estadoService, VideojuegoService videojuegoService, DistribuidorService distribuidorService) {
		super();
		this.estadoService = estadoService;
		this.videojuegoService = videojuegoService;
		this.distribuidorService = distribuidorService;
	}
	
	private List<Transporte> listatransportes(){
		List<Distribuidor> distribuidores = distribuidorService.buscarTodos();
		List<Transporte> transportes = new ArrayList<>();
		List<Transporte> listaLimpia = new ArrayList<>();
		distribuidores.forEach(distribuidor -> {
			transportes.addAll(distribuidor.getTransportes());
		});
		Map<Integer, Transporte> mapTransporte = new HashMap<Integer, Transporte>(transportes.size());
		for(Transporte p : transportes) {
			 mapTransporte.put(p.getId(), p);
		}
		for(Entry<Integer, Transporte> p : mapTransporte.entrySet()) {
			listaLimpia.add(p.getValue());
		}
		return listaLimpia;
	}
	
	private Model inicialiazar(Model model) {
		model.addAttribute("estados",estadoService.buscarTodos());
		model.addAttribute("categorias", videojuegoService.buscarTodasCategorias());
		model.addAttribute("videojuegos",videojuegoService.buscarDestacados());
		model.addAttribute("distribuciones",distribuidorService.buscarTodos());
		List<Transporte> transportes = listatransportes();
		model.addAttribute("transportes",transportes);
		model.addAttribute("videojuego", new Videojuego());
		return model;
	}
	
	

	@RequestMapping("/buscador/categorias")
	public String mostrarBuscador(Model model){
		model = inicialiazar(model);
		return "buscando";
	}
	
	@RequestMapping("/buscador/categorias/ajax")
	public @ResponseBody List<Transporte> ajaxTransportes(ModelMap model,@RequestParam("distribuidor") Integer distribuidor){
		System.out.println(distribuidor);
		List<Distribuidor> distribuidores = distribuidorService.buscarTodos();
		List<Transporte> transportes = new ArrayList<>();
		distribuidores.forEach(distribuidr -> {
			System.out.println(distribuidr.getId() + " - " + distribuidor);
			if(distribuidr.getId() == distribuidor) {
				transportes.addAll(distribuidr.getTransportes());
				System.out.println(transportes);
			}
		});
		
		model.addAttribute("${videojuego.distribuidor.transportes}",transportes);
		
		return transportes;
	}
	
	@PostMapping("/buscador/categorias")
	public String busqueda(Model model,Videojuego videojuego){
		System.out.println(videojuego);
		List<Videojuego> videojueggos1 = new ArrayList<>();
		List<Videojuego> videojueggos = videojuegoService.buscarPorNombre(videojuego.getNombre());
		if(videojuego.getEstado() != null) {
			videojueggos1 = videojuegoService.buscarPorEstado(videojuego.getEstado().getId());
			videojueggos.retainAll(videojueggos1);
		}
		if(videojuego.getCategoria() != null) {
			videojueggos1 = videojuegoService.buscarPorCategoria(videojuego.getCategoria());
			videojueggos.retainAll(videojueggos1);
		}
		if(videojuego.getDistribuidor().getId() != null) {
			videojueggos1 = videojuegoService.buscarPorDistribuidor(videojuego.getDistribuidor().getId());
			videojueggos.retainAll(videojueggos1);
		}
		if(videojuego.getDistribuidor().getTransportes() != null) {
			for(int i=0;i<videojuego.getDistribuidor().getTransportes().size();i++) {
					videojueggos1 = videojuegoService.buscarPorTransporte(videojuego.getDistribuidor().getTransportes().get(i), listatransportes());
					videojueggos.retainAll(videojueggos1);
			}
		}
		model = inicialiazar(model);
		model.addAttribute("juegos",videojueggos);
		return "buscando";
	}
	
}
