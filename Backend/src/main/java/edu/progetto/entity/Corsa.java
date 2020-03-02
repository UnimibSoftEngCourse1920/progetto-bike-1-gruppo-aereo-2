package edu.progetto.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "corsa")
public class Corsa {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	private LocalDateTime inizioCorsa;
	
	private LocalDateTime fineCorsa;
	
	@OneToOne
	private Prenotazione prenotazione;
	
	
	public Corsa() {
		
	}
	
	public Corsa(LocalDateTime inizioCorsa, LocalDateTime fineCorsa, Prenotazione prenotazione) {
		this.inizioCorsa = inizioCorsa;
		this.fineCorsa = fineCorsa;
		this.prenotazione = prenotazione;
	}

	public LocalDateTime getInizioCorsa() {
		return inizioCorsa;
	}

	public void setInizioCorsa(LocalDateTime inizioCorsa) {
		this.inizioCorsa = inizioCorsa;
	}

	public LocalDateTime getFineCorsa() {
		return fineCorsa;
	}

	public void setFineCorsa(LocalDateTime fineCorsa) {
		this.fineCorsa = fineCorsa;
	}

	public Prenotazione getPrenotazione() {
		return prenotazione;
	}

	public void setPrenotazione(Prenotazione prenotazione) {
		this.prenotazione = prenotazione;
	}
}
