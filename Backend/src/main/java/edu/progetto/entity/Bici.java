package edu.progetto.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bici")
public class Bici implements Serializable{
	
	private static final long serialVersionUID = -3794941021812850097L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	private boolean disponibile;
	
	private Integer statoBici;
	
	private TipologiaBici  tipologia;


	public Bici() {

	}
	
	public Bici(boolean disponibile, Integer statoBici, TipologiaBici tipologia) {
		this.disponibile = disponibile;
		this.statoBici = statoBici;
		this.tipologia = tipologia;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStatoBici() {
		return statoBici;
	}

	public void setStatoBici(Integer statoBici) {
		this.statoBici = statoBici;
	}

	public boolean isDisponibile() {
		return disponibile;
	}

	public void setDisponibile(boolean disponibile) {
		this.disponibile = disponibile;
	}

	public TipologiaBici getTipologia() {
		return tipologia;
	}

	public void setTipologia(TipologiaBici tipologia) {
		this.tipologia = tipologia;
	}
}
