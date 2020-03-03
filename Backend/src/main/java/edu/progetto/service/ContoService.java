package edu.progetto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


	public Double getSaldoDisponibile(String username) {
		Conto conto = contoRepo.findByCliente(clienteRepo.findByUsername(username));
		return conto.getSaldo();
	}
	
	public void addConto(Conto c) {
		contoRepo.save(c);
	}
	
	
	
	
	
	
	
	
}
