package edu.progetto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.progetto.dto.ClienteDTO;
import edu.progetto.entity.Cliente;
import edu.progetto.service.ClienteService;

@RestController
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	

	@GetMapping("/clienti")
	public List<Cliente> getAllClienti(){
		return clienteService.getAllclienti();
	}
	
	@GetMapping("/clienti/{id}")
	public Cliente getCliente(@PathVariable Integer id)
	{
		return clienteService.getCliente(id);
	}
	
	@PostMapping("/clienti")
	public void addCliente(@RequestBody ClienteDTO clienteDTO) {
		Cliente c = new Cliente(clienteDTO);
		clienteService.addCliente(c);
	}
	
	@PutMapping("/clienti/{id}")
	public void updateVolo(@RequestBody ClienteDTO clienteDTO, Integer id) {
		Cliente c = new Cliente(clienteDTO);
		clienteService.updateCliente(id,c);
	}
	
	@DeleteMapping("/clienti/{id}")
	public void deleteCliente(@PathVariable Integer id) {
		clienteService.deleteCliente(id);
	}

}

