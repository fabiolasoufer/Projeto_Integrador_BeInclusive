package org.beinclusive.beinclusive.controller;

import java.util.List;

import org.beinclusive.beinclusive.model.Tema;
import org.beinclusive.beinclusive.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin (origins = "*", allowedHeaders = "*")
@RequestMapping("/temas")
public class TemaController {
	
	@Autowired
	private TemaRepository repository;
	
	@GetMapping
   public ResponseEntity<List<Tema>> getAll(){
	   return ResponseEntity.ok(repository.findAll());
	   
   }
}
