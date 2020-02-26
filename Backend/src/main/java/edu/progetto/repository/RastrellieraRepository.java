package edu.progetto.repository;

import org.springframework.data.repository.CrudRepository;

import edu.progetto.entity.Rastrelliera;

public interface RastrellieraRepository extends CrudRepository<Rastrelliera,Integer>{
	public Rastrelliera findByPosizione(String posizione);
	
}
