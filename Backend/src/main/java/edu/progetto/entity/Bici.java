package edu.progetto.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bici")
public class Bici {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private boolean disponibile;

	private Integer statoBici;


	public Bici() {

	}
	
	public Bici(boolean disponibile, Integer statoBici) {
		this.disponibile = disponibile;
		this.statoBici = statoBici;
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
}
