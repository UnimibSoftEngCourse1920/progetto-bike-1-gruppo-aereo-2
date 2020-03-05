package edu.progetto.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.progetto.entity.Abbonamento;
import edu.progetto.entity.Cliente;
import edu.progetto.entity.Conto;
import edu.progetto.entity.TipoAbbonamento;
import edu.progetto.repository.AbbonamentoRepository;

@Service
public class AbbonamentoService {

	@Autowired 
	private AbbonamentoRepository abbonamentoRepo;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ContoService contoService;


	public void addAbbonamento(Abbonamento a) {
		this.abbonamentoRepo.save(a);
	}

	public void updateAbbonamento(Integer id, Abbonamento a) {
		this.abbonamentoRepo.findById(id);
		this.abbonamentoRepo.save(a);
	}

	public Abbonamento findAbbonamentoByCliente(Cliente c) {
		return this.abbonamentoRepo.findByCliente(c);
	}
	public String ricarica(String username,String tipoAbbonamento) {
		Cliente cliente = clienteService.findByUsername(username);
		Conto conto = contoService.findByCliente(cliente);
		Double costo = this.calcolaCosto(tipoAbbonamento);
		if(costo <= conto.getSaldo()) {
			contoService.addebita(cliente, costo);
			try {
				Abbonamento abbonamento = this.abbonamentoRepo.findByCliente(cliente);
				if(!this.isValido(abbonamento)) 
					abbonamento.setScadenza(LocalDate.now());
				this.aggiungiMesi(abbonamento, tipoAbbonamento);
				return "L'abbonamento è stato ricaricato correttamente";
			}
			catch(Exception e) {
				Abbonamento nuovoAbbonamento = new Abbonamento();
				nuovoAbbonamento.setCliente(cliente);
				nuovoAbbonamento.setScadenza(LocalDate.now());
				abbonamentoRepo.save(nuovoAbbonamento);
				this.aggiungiMesi(nuovoAbbonamento, tipoAbbonamento);
				return "L'abbonamento è stato acquistato correttamente";
			}
		}
		return "Il saldo sul conto non è sufficiente per l'acquisto"
		+ " ricarica il conto per completare l'acquisto";
	}

	private double calcolaCosto(String tipoAbbonamento) {
		if(tipoAbbonamento.equals(TipoAbbonamento.MENSILE.toString()))
			return 30.00;
		if(tipoAbbonamento.equals(TipoAbbonamento.SEMESTRALE.toString()))
			return 150.00;
		return 280.00;
	}

	private void aggiungiMesi(Abbonamento abbonamento, String tipoAbbonamento) {
		if(tipoAbbonamento.equals(TipoAbbonamento.MENSILE.toString()))
			abbonamento.setScadenza(abbonamento.getScadenza().plusMonths(1));
		if(tipoAbbonamento.equals(TipoAbbonamento.SEMESTRALE.toString()))
			abbonamento.setScadenza(abbonamento.getScadenza().plusMonths(6));
		if(tipoAbbonamento.equals(TipoAbbonamento.ANNUALE.toString()))
			abbonamento.setScadenza(abbonamento.getScadenza().plusMonths(12));
		this.updateAbbonamento(abbonamento.getId(), abbonamento);
	}

	public String getScadenza(String username) {
		try {
			Abbonamento abbonamento = this.abbonamentoRepo.findByCliente(
					clienteService.findByUsername(username));
			if (this.isValido(abbonamento))
				return "L'abbonamento scade il " + abbonamento.getScadenza();
			return "L'abbonamento è scaduto il" + abbonamento.getScadenza();
		}
		catch(Exception e) {
			return "/";
		}
	}

	public boolean isValido(Abbonamento abbonamento) {
		return abbonamento.getScadenza().isAfter((LocalDate.now()));
	}
}
