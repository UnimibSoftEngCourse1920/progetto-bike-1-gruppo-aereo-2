package edu.progetto.request;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class ReservationRequest implements Serializable {

	private static final long serialVersionUID = -8892729993882809980L;
	
	private String posizionePartenza;
	
	private String posizioneArrivo;
	
	private String username;
	
	private Integer idBici;
	
	private String oraInizio;
	
	private String oraFine;

	public String getPosizionePartenza() {
		return posizionePartenza;
	}

	public void setPosizionePartenza(String posizionePartenza) {
		this.posizionePartenza = posizionePartenza;
	}

	public String getPosizioneArrivo() {
		return posizioneArrivo;
	}

	public void setPosizioneArrivo(String posizioneArrivo) {
		this.posizioneArrivo = posizioneArrivo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getIdBici() {
		return idBici;
	}

	public void setIdBici(Integer idBici) {
		this.idBici = idBici;
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

	public ReservationRequest(String posizionePartenza, String posizioneArrivo, String username, Integer idBici,
			String oraInizio, String oraFine) {
		this.posizionePartenza = posizionePartenza;
		this.posizioneArrivo = posizioneArrivo;
		this.username = username;
		this.idBici = idBici;
		this.oraInizio = oraInizio;
		this.oraFine = oraFine;
	}
	
	public ReservationRequest() {
		
	}
	
	
	
	
	
	

}
