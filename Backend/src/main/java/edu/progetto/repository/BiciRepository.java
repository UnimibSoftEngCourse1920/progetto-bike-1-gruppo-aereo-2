package edu.progetto.repository;

import org.springframework.data.repository.CrudRepository;

import edu.progetto.entity.Bici;

public interface BiciRepository extends CrudRepository <Bici,Integer> {
	
}
