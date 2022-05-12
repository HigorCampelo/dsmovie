package com.devsuperior.dsmovie.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.services.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {
	
	@Autowired
	private MovieService service;
	
	//Sem paginação
	/*@GetMapping
	public ResponseEntity<List<MovieDTO>> findAll(){
		//List<Category> list = service.findAll();
		return ResponseEntity.ok().body(service.findAll());
	}*/
	
	@GetMapping
	public ResponseEntity<Page<MovieDTO>> findAllPaged(Pageable pageable){
		Page<MovieDTO> list = service.findAllPaged(pageable);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<MovieDTO> findById(@PathVariable Long id){
		//List<Category> list = service.findAll();
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	

}
