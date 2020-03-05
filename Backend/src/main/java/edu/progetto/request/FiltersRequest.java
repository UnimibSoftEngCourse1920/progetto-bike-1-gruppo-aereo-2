package edu.progetto.request;

import java.io.Serializable;

public class FiltersRequest implements Serializable{

	private static final long serialVersionUID = -6814726609941812230L;

	private String username;
	
	private String posizioneInizio;

	private String oraInizio;

	private String oraFine;

	public FiltersRequest() {

	}

	public FiltersRequest(String username, String posizioneInizio, String oraInizio, String oraFine) {
		this.username = username;
		this.posizioneInizio = posizioneInizio;
		this.oraInizio = oraInizio;
		this.oraFine = oraFine;
	}
	
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
