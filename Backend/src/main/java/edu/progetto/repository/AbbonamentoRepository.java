package edu.progetto.repository;

import org.springframework.data.repository.CrudRepository;

import edu.progetto.entity.Abbonamento;
import edu.progetto.entity.Cliente;

public interface AbbonamentoRepository extends CrudRepository <Abbonamento,Integer>{
	
	public Abbonamento findByCliente(Cliente cliente);
}
