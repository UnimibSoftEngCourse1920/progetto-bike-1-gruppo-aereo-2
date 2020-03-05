package edu.progetto.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.progetto.entity.Cliente;
import edu.progetto.entity.Conto;
import edu.progetto.repository.ClienteRepository;
import edu.progetto.repository.ContoRepository;

@Service
public class ContoService {

	@Autowired
	private ContoRepository contoRepo;
	
	@Autowired
	private ClienteRepository clienteRepo;
	
	
	public String ricarica(String username, Double importo) {
		this.addebita(username, - importo);
		return "Ricarica avvenuta con successo";
	}


	private void updateConto(Integer id, Conto conto) {
		contoRepo.findById(id);
		contoRepo.save(conto);	
	}
	
	public void addebita(String username, Double importo) {
		Conto conto = contoRepo.findByCliente(clienteRepo.findByUsername(username));
		conto.setSaldo(conto.getSaldo() - importo);
		this.updateConto(conto.getId(),conto);
	}
	
	public Conto findByCliente(Cliente cliente) {
		return contoRepo.findByCliente(cliente);
	}


	public Double getSaldoDisponibile(String username) {
		Conto conto = contoRepo.findByCliente(clienteRepo.findByUsername(username));
		return BigDecimal.valueOf(conto.getSaldo())
	            .setScale(3, RoundingMode.HALF_UP)
	            .doubleValue();
	}
	
	public void addConto(Conto c) {
		contoRepo.save(c);
	}


	public void addebita(Cliente cliente, Double costo) {
		this.addebita(cliente.getUsername(), costo);
	}
	
	
	
	
	
	
	
	
}
