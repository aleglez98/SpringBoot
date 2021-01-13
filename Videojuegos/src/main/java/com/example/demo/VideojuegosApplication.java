package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.domain.Distribuidor;
import com.example.demo.domain.Transporte;
import com.example.demo.repository.DistribuidorRepository;
import com.example.demo.repository.TransporteRepository;

@SpringBootApplication
public class VideojuegosApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideojuegosApplication.class, args);
	}

}
