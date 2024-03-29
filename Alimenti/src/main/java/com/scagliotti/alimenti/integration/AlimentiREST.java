package com.scagliotti.alimenti.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scagliotti.alimenti.entities.Alimento;
import com.scagliotti.alimenti.services.AlimentoService;

@RestController
@RequestMapping({"api", "rest"})
public class AlimentiREST {
	@Autowired
	private AlimentoService service;
	
	
	@GetMapping
	public List<Alimento> pippo(){
		return service.getAlimenti();
	}
	
	@GetMapping("cat/{categoria}")
	public List<Alimento> getByCat(@PathVariable("categoria") String category){
		return service.getAlimentiByCategoria(category);
	}
	
	@GetMapping("categorie")
	public List<String> getCategorie(){
		return this.service.getCategorie();
	}
	
	@PostMapping
	public void addAlimento(@RequestBody Alimento a) {
		service.addAlimento(a);
	}
	
	@PutMapping
	public void updAlimento(@RequestBody Alimento a) {
		service.updAlimento(a);
	}
	
	@DeleteMapping("/{id}")
	public void delAlimento(@PathVariable int id) {
		service.delAlimento(id);
	}

}
