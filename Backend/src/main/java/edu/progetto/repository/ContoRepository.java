package edu.progetto.repository;

import org.springframework.data.repository.CrudRepository;

import edu.progetto.entity.Cliente;
import edu.progetto.entity.Conto;

public interface ContoRepository extends CrudRepository<Conto,Integer>{
	
	public Conto findByCliente(Cliente cliente);
}
