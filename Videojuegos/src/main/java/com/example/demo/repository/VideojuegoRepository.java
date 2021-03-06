package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.domain.Transporte;
import com.example.demo.domain.Videojuego;

public interface VideojuegoRepository extends JpaRepository<Videojuego,Integer> {
	
//  @Query(value = "select * from "formacion".videojuego order by nombre)		//SQL
	@Query("select v from Videojuego v order by v.nombre")			//JPQL
	List<Videojuego> BuscarTodos();
	
	
	@Query("select v from Videojuego v where v.distribuidor.nombre like ?1 order by v.nombre")
	List<Videojuego> buscarPorDistribuidor(String distribuidor);
	
	@Query("from Videojuego v where v.nombre like %?1% order by v.nombre")
	List<Videojuego> findByNombreContaining(String consulta);

//	@Query("select v from Videojuego v where v.nombre like \'%?1%\'")
	List<Videojuego> findByNombreContainingOrCategoriaContaining(String consulta,String consulta1);
	
	@Query("from Videojuego v where v.categoria like %?1% order by v.nombre")
	List<Videojuego> findByCategoriaContaining(String d);

	@Query("select v from Videojuego v where v.estado.estado like ?1 order by v.nombre")
	List<Videojuego> buscarPorEstado(String id);

	List<String> buscarCategorias();

	
	@Query("select v from Videojuego v where ?1 IN (?2) order by v.nombre")
	List<Videojuego> buscarPorTransporte(Transporte string, List<Transporte> transporte);

	
	
}
