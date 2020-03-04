package edu.progetto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import edu.progetto.entity.Cliente;
import edu.progetto.entity.Prenotazione;
import edu.progetto.response.HistogramResponse;

public interface PrenotazioneRepository extends CrudRepository<Prenotazione,Integer>{
	public List<Prenotazione> findByCliente(Cliente cliente);
	
	@Query(value="SELECT " +
	        "    new edu.progetto.response.HistogramResponse(COUNT(*), r.posizione) " +
	        "FROM " +
	        " Prenotazione p INNER JOIN p.rastrellieraPartenza r "+
	        "GROUP BY r.posizione", nativeQuery = false)
	public List<HistogramResponse> countByRastrellieraPartenza();
	
	
	
	
}