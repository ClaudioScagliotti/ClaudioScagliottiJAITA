package com.scagliotti.alimenti.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scagliotti.alimenti.entities.Alimento;
@Repository
public interface AlimentoDAO extends JpaRepository<Alimento, Integer> { //repo di Alimento, con chiave
	//primaria di tipo int, oggetto Integer
	
	List<Alimento> findByCategoria(String categoria);
	//List<String> findDistinctByCategoria();
	

}
