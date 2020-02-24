package edu.progetto.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "rastrelliera")
public class Rastrelliera {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	private String posizione;
	
	private Integer numBici;
	
	@OneToMany
	private List<Bici> biciDisponibili;
	
	public Rastrelliera() {
		
	}
	
	public Rastrelliera(String posizione, Integer numBici, List<Bici> biciDisponibili) {
		this.posizione = posizione;
		this.numBici = numBici;
		this.biciDisponibili = biciDisponibili;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPosizione() {
		return posizione;
	}

	public void setPosizione(String posizione) {
		this.posizione = posizione;
	}

	public Integer getNumBici() {
		return numBici;
	}

	public void setNumBici(Integer numBici) {
		this.numBici = numBici;
	}

	public List<Bici> getBiciDisponibili() {
		return biciDisponibili;
	}

	public void setBiciDisponibili(List<Bici> biciDisponibili) {
		this.biciDisponibili = biciDisponibili;
	}

}
