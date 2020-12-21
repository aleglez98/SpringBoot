package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.domain.Videojuego;

public interface VideojuegoRepository extends JpaRepository<Videojuego,Integer> {
	
//  @Query(value = "select * from "formacion".videojuego order by nombre)		//SQL
	@Query("select v from Videojuego v order by v.nombre")			//JPQL
	List<Videojuego> BuscarTodos();
	
	
	@Query("select v from Videojuego v where v.distribuidor.id = ?1 order by v.nombre")
	List<Videojuego> buscarPorDistribuidor(int distribuidor);
	
//	@Query("from Videojuego v wherev.nombre like %?1%")
	List<Videojuego> findByNombreContaining(String consulta);
	
}
