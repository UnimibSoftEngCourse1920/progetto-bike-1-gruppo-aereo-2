package edu.progetto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.progetto.entity.Cliente;
import edu.progetto.service.ClienteService;

@RestController
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	

	@RequestMapping("/clienti")
	public List<Cliente> getAllClienti(){
		return clienteService.getAllclienti();
	}
	
	@RequestMapping("/clienti/{id}")
	public Cliente getCliente(@PathVariable Integer id)
	{
		return clienteService.getCliente(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/clienti")
	public void addCliente(@RequestBody Cliente c) {
		clienteService.addCliente(c);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/clienti/{id}")
	public void updateVolo(@RequestBody Cliente c, Integer id) {
		clienteService.updateCliente(id,c);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/clienti/{id}")
	public void deleteCliente(@PathVariable Integer id) {
		clienteService.deleteCliente(id);
	}

}

