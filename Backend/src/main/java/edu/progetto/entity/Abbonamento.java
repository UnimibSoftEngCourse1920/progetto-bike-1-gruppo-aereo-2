package edu.progetto.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "abbonamento")
public class Abbonamento {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@OneToOne(fetch = FetchType.LAZY)
    @MapsId
	private Cliente cliente;
	
	private LocalDate scadenza;
	
	public Abbonamento() {
		
	}

	public Abbonamento(Cliente cliente, LocalDate scadenza) {
		this.cliente = cliente;
		this.scadenza = scadenza;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDate getScadenza() {
		return scadenza;
	}

	public void setScadenza(LocalDate scadenza) {
		this.scadenza = scadenza;
	}

}
