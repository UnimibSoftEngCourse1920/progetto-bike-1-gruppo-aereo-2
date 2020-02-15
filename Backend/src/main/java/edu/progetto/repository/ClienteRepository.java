package edu.progetto.repository;

import org.springframework.data.repository.CrudRepository;

import edu.progetto.entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente,Integer>{
	public Cliente findByUsername(String username);
	
	public Cliente findByEmail(String email);
}
