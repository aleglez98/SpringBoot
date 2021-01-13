package com.example.demo.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Transporte;
import com.example.demo.domain.Videojuego;
import com.example.demo.repository.VideojuegoRepository;


@Repository
public class VideojuegoRepositoryImpl implements VideojuegoRepository{
	
	@PersistenceContext
	EntityManager em;
	
	public List<String> buscarCategorias() {
		//List<Videojuego> lista = new ArrayList<>();
		List<String> lista1 = new ArrayList<>();
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Videojuego> cq = cb.createQuery(Videojuego.class);
        Root<Videojuego> juego = cq.from(Videojuego.class);
        //cq.select(juego.get("categoria"));
        TypedQuery<Videojuego> consulta = em.createQuery(cq);
        List<Videojuego> lista = consulta.getResultList();
        lista.forEach((p) -> {
        	if(!lista1.contains(p.getCategoria())) {
        		lista1.add(p.getCategoria());
        	}
        });
		return lista1;
	}

	@Override
	public List<Videojuego> buscarPorTransporte(Transporte string,List<Transporte> transporte) {
		// TODO Auto-generated method stub
		return null;
	}	
	@Override
	public List<Videojuego> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Videojuego> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Videojuego> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Videojuego> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Videojuego> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Videojuego> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Videojuego getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Videojuego> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Videojuego> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Videojuego> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Videojuego> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Videojuego> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Videojuego entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Videojuego> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Videojuego> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Videojuego> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Videojuego> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Videojuego> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Videojuego> BuscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Videojuego> buscarPorDistribuidor(int distribuidor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Videojuego> findByNombreContaining(String consulta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Videojuego> findByNombreContainingOrCategoriaContaining(String consulta, String consulta1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Videojuego> findByCategoriaContaining(String d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Videojuego> buscarPorEstado(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
