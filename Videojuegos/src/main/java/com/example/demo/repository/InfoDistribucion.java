package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Distribuidor;

public interface InfoDistribucion extends JpaRepository<Distribuidor,Integer> {

}
