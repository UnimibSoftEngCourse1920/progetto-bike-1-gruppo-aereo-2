package edu.progetto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.progetto.entity.Cliente;
import edu.progetto.entity.Prenotazione;

public interface PrenotazioneRepository extends CrudRepository<Prenotazione,Integer>{
	public List<Prenotazione> findByCliente(Cliente cliente);
}
