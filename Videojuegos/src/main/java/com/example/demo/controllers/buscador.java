package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
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
import com.example.demo.dto.FormularioDTO;
import com.example.demo.dto.ListadoDTO;
import com.example.demo.dto.VideojuegoDTO;
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
		
		return model;
	}
	
	

	@RequestMapping("/buscador/categorias")
	public String mostrarBuscador(Model model){
		model = inicialiazar(model);
		model.addAttribute("form", new FormularioDTO());
		return "buscando";
	}
	
	@RequestMapping("/buscador/categorias/ajax")
	public String ajaxTransportes(ModelMap model,@RequestParam("distribuidor") Integer distribuidor){
		List<Distribuidor> distribuidores = distribuidorService.buscarTodos();
		List<Transporte> transportes = new ArrayList<>();
		distribuidores.forEach(distribuidr -> {
			if(distribuidr.getId() == distribuidor) {
				transportes.addAll(distribuidr.getTransportes());
			}
		});
		
		model.addAttribute("transportes",transportes);
		
		return "buscando :: transportes";
	}
	
	
	@RequestMapping("/buscador/categorias/aja")
	public String busqueda(Model model,@PathParam("nombre") String nombre,@PathParam("categoria") String categoria,@PathParam("estado") String estado,@PathParam("distribuidor") String distribuidor,@PathParam("page") Integer page) {
        String cadena = "";
        System.out.println(nombre);
		List<Videojuego> videojueggos1 = new ArrayList<>();
		List<Videojuego> videojueggos = new ArrayList<>();
		if(nombre != "") {
			videojueggos = videojuegoService.buscarPorNombre(nombre);
		}else {
			videojueggos = videojuegoService.buscarPorNombre(cadena);
		}
		if(estado != "") {
			videojueggos1 = videojuegoService.buscarPorEstado(estado);
			videojueggos.retainAll(videojueggos1);
		}
		if(categoria != "") {
			videojueggos1 = videojuegoService.buscarPorCategoria(categoria);
			videojueggos.retainAll(videojueggos1);
		}
		/*
		 * if(distribuidor != "undefined") { videojueggos1 =
		 * videojuegoService.buscarPorDistribuidor(distribuidor);
		 * videojueggos.retainAll(videojueggos1); }
		 */
		List<VideojuegoDTO> listado = new ArrayList<>();
		videojueggos.forEach(juego -> {
			VideojuegoDTO video = new VideojuegoDTO();
			video.setNombre(juego.getNombre());
			video.setCategoria(juego.getCategoria());
			video.setEstado(juego.getEstado().getEstado());
			video.setDistribuidor(juego.getDistribuidor().getNombre());
			List<String> tr = new ArrayList<>();
			juego.getDistribuidor().getTransportes().forEach(transporte -> {
				tr.add(transporte.getNombre());
			});
			video.setTransportes(tr);
			listado.add(video);
		});
		int currentPage;
		if(page != null) {
			currentPage = page;
		}else {
			currentPage = 1;
		}
        int pageSize = 5;
        Pageable pageable=PageRequest.of(currentPage, pageSize,Sort.by("nombre").ascending());
		int start = (int) pageable.getOffset() - 5;
		int end;
		if((start+pageSize) > listado.size()) {
			end = listado.size();
		}
		else {
			end = start+pageSize;
		}
		
		Page<VideojuegoDTO> pages = new PageImpl<VideojuegoDTO>(listado.subList(start, end), pageable, listado.size());
		int totalPages = pages.getTotalPages();
		List<Integer> pageNumbers = new ArrayList<>();
        if (totalPages > 0) {
            pageNumbers = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());
        }
		model = inicialiazar(model);
		//model.addAttribute("lista",pages);
		VideojuegoDTO videojuego = new VideojuegoDTO();
		model.addAttribute("lista",new ListadoDTO(pageNumbers,listado.size(),totalPages,pages,videojuego));
		//model.addAttribute("form", videojuego);
		 
		return "buscando :: tabla";
	}
	
}
