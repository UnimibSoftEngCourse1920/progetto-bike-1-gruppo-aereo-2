package edu.progetto.service;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.progetto.entity.Cliente;
import edu.progetto.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	public List<Cliente> getAllClienti() {
		List<Cliente> clienti= new ArrayList<>();
		for (Cliente c : clienteRepository.findAll()){
			clienti.add(c);
		}
		return clienti;
	}

	public Cliente getCliente(Integer id) {
		return clienteRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException());
	}
	
	public Cliente getClienteByUsername(String username) {
		return clienteRepository.findByUsername(username);
	}

	public Cliente addCliente(Cliente c) {
		clienteRepository.save(c);
		return c;
	}

	public void updateCliente(Integer id, Cliente c) {
		clienteRepository.findById(id);
		clienteRepository.save(c);
	}
	
	public void deleteCliente(Integer id) {
		clienteRepository.deleteById(id);
	}
	
	public boolean existsByUsername(String username) {
		return clienteRepository.existsByUsername(username);
	}
	
	public boolean existsByEmail(String email) {
		return clienteRepository.existsByEmail(email);
	}
	
	public Cliente findByUsername(String username) {
		return clienteRepository.findByUsername(username);
	}
}

