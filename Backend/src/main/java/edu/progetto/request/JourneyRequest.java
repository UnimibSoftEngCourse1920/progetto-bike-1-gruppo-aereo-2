package edu.progetto.request;

import java.io.Serializable;

public class JourneyRequest implements Serializable  {

	private static final long serialVersionUID = 8183330199821459375L;
	
	private Integer idPrenotazione;

	
	public JourneyRequest() {
		
	}
	
	public JourneyRequest(Integer idPrenotazione) {
		this.idPrenotazione = idPrenotazione;
	}

	public Integer getIdPrenotazione() {
		return idPrenotazione;
	}

	public void setIdPrenotazione(Integer idPrenotazione) {
		this.idPrenotazione = idPrenotazione;
	}
	
	
}
