package edu.progetto.response;

import java.io.Serializable;

public class PieResponse implements Serializable {

	private static final long serialVersionUID = -6824137585981490403L;
	
	private Integer valore;
	
	private String fasciaOraria;
		
	public PieResponse() {
		
	}

	public PieResponse(Integer valore, String fasciaOraria) {
		this.valore = valore;
		this.fasciaOraria = fasciaOraria;
	}

	public Integer getValore() {
		return valore;
	}

	public void setValore(Integer valore) {
		this.valore = valore;
	}

	public String getFasciaOraria() {
		return fasciaOraria;
	}

	public void setFasciaOraria(String fasciaOraria) {
		this.fasciaOraria = fasciaOraria;
	}
}
