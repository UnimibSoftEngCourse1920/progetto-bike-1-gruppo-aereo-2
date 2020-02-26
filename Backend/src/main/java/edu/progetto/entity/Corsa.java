package edu.progetto.entity;

import java.util.Date;

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
	
	private Date inizioCorsa;
	
	private Date fineCorsa;
	
	@OneToOne
	private Prenotazione prenotazione;
	
	public Corsa() {
		
	}
	
	public Corsa(Date inizioCorsa, Date fineCorsa, Prenotazione prenotazione) {
		this.inizioCorsa = inizioCorsa;
		this.fineCorsa = fineCorsa;
		this.prenotazione = prenotazione;
	}

	public Date getInizioCorsa() {
		return inizioCorsa;
	}

	public void setInizioCorsa(Date inizioCorsa) {
		this.inizioCorsa = inizioCorsa;
	}

	public Date getFineCorsa() {
		return fineCorsa;
	}

	public void setFineCorsa(Date fineCorsa) {
		this.fineCorsa = fineCorsa;
	}

	public Prenotazione getPrenotazione() {
		return prenotazione;
	}

	public void setPrenotazione(Prenotazione prenotazione) {
		this.prenotazione = prenotazione;
	}
}
