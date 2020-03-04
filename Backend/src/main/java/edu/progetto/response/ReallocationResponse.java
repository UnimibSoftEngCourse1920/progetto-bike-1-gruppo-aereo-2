package edu.progetto.response;

import java.io.Serializable;

public class ReallocationResponse implements Serializable{

	private static final long serialVersionUID = -2536103310726477753L;
	
	private String posizione;
	
	private Integer numBici;
	
	public ReallocationResponse() {
		
	}

	public ReallocationResponse(String posizione, Integer numBici) {
		this.posizione = posizione;
		this.numBici = numBici;
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
}
