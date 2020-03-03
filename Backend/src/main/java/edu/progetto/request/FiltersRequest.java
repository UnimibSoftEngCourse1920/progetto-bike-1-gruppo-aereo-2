package edu.progetto.request;

import java.io.Serializable;

public class FiltersRequest implements Serializable{

	private static final long serialVersionUID = -6814726609941812230L;

	private String ruolo;
	
	private String posizioneInizio;

	private String oraInizio;

	private String oraFine;

	public FiltersRequest() {

	}

	public FiltersRequest(String ruolo, String posizioneInizio, String oraInizio, String oraFine) {
		this.ruolo = ruolo;
		this.posizioneInizio = posizioneInizio;
		this.oraInizio = oraInizio;
		this.oraFine = oraFine;
	}
	
	

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public String getPosizioneInizio() {
		return posizioneInizio;
	}

	public void setPosizioneInizio(String posizioneInizio) {
		this.posizioneInizio = posizioneInizio;
	}

	public String getOraInizio() {
		return oraInizio;
	}

	public void setOraInizio(String oraInizio) {
		this.oraInizio = oraInizio;
	}

	public String getOraFine() {
		return oraFine;
	}

	public void setOraFine(String oraFine) {
		this.oraFine = oraFine;
	}



}
