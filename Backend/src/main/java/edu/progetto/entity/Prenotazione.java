package edu.progetto.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prenotazione")
public class Prenotazione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@ManyToOne
	private Cliente cliente;
	
	@ManyToOne
	private Rastrelliera rastrellieraPartenza;
	
	@ManyToOne
	private Rastrelliera rastrellieraArrivo;
	
	@OneToOne
	private Bici bici;
	
	private	LocalDateTime oraInizio;
	
	private LocalDateTime oraFine;
	
	

	
	public Prenotazione() {
		
	}	
	
	public Prenotazione(Cliente cliente,Rastrelliera rastrellieraPartenza, Rastrelliera rastrellieraArrivo, Bici bici, LocalDateTime oraInizio, LocalDateTime oraFine) {
		this.cliente = cliente;
		this.rastrellieraPartenza = rastrellieraPartenza;
		this.rastrellieraArrivo = rastrellieraArrivo;
		this.bici = bici;
		this.oraInizio = oraInizio;
		this.oraFine = oraFine;
	}

	public Rastrelliera getRastrellieraPartenza() {
		return rastrellieraPartenza;
	}

	public void setRastrellieraPartenza(Rastrelliera rastrellieraPartenza) {
		this.rastrellieraPartenza = rastrellieraPartenza;
	}

	public Rastrelliera getRastrellieraArrivo() {
		return rastrellieraArrivo;
	}

	public void setRastrellieraArrivo(Rastrelliera rastrellieraArrivo) {
		this.rastrellieraArrivo = rastrellieraArrivo;
	}

	public Bici getBici() {
		return bici;
	}

	public void setBici(Bici bici) {
		this.bici = bici;
		
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDateTime getOraInizio() {
		return oraInizio;
	}

	public void setOraInizio(LocalDateTime oraInizio) {
		this.oraInizio = oraInizio;
	}

	public LocalDateTime getOraFine() {
		return oraFine;
	}

	public void setOraFine(LocalDateTime oraFine) {
		this.oraFine = oraFine;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
