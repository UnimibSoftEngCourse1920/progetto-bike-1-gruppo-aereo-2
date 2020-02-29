package edu.progetto.repository;

import org.springframework.data.repository.CrudRepository;

import edu.progetto.entity.Corsa;
import edu.progetto.entity.Prenotazione;

public interface CorsaRepository extends CrudRepository<Corsa,Integer>{
	
	public Corsa findByPrenotazione(Prenotazione p);
}
