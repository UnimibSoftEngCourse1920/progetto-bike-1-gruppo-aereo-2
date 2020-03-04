package edu.progetto.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "rastrelliera")
public class Rastrelliera implements Serializable {

	private static final long serialVersionUID = -1866764767306444352L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	private String posizione;
	
	@OneToMany
	private List<Bici> listaBici;
	
	public Rastrelliera() {
		
	}
	
	public Rastrelliera(String posizione) {
		this.posizione = posizione;
		this.listaBici = new ArrayList<>();
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

	public List<Bici> getListaBici() {
		return listaBici;
	}

	public void setListaBici(List<Bici> listaBici) {
		this.listaBici = listaBici;
	}

	public void addBici(Bici bici) {
		listaBici.add(bici);
	}
	
	public void removeBici(Bici bici) {
		listaBici.remove(bici);
	}

}
