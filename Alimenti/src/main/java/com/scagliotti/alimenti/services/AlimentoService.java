package com.scagliotti.alimenti.services;

import java.util.List;

import com.scagliotti.alimenti.entities.Alimento;

public interface AlimentoService {
//CRUD
	//CRUD
		void addAlimento(Alimento a);
		void updAlimento(Alimento a);
		void delAlimento(int id);
		
		List<Alimento> getAlimenti();
		List<Alimento> getAlimentiByCategoria(String categoria);
		Alimento getAlimentoById(int id);
		List<String> getCategorie();
	
}
