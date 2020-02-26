package edu.progetto.response;

import java.io.Serializable;

public class ReservationResponse implements Serializable{
	
	private static final long serialVersionUID = -890419640386907278L;
	
	private Integer idPrenotazione;
	private String posizioneInizio;
	private String posizioneFine;
	private String oraInizio;
	private String oraFine;
	private Integer idBici;
	
	public ReservationResponse(Integer idPrenotazione, String posizioneInizio, String posizioneFine, String oraInizio,
			String oraFine, Integer idBici) {
		this.idPrenotazione = idPrenotazione;
		this.posizioneInizio = posizioneInizio;
		this.posizioneFine = posizioneFine;
		this.oraInizio = oraInizio;
		this.oraFine = oraFine;
		this.idBici = idBici;
	}
	
	
	public Integer getIdPrenotazione() {
		return idPrenotazione;
	}
	public void setIdPrenotazione(Integer idPrenotazione) {
		this.idPrenotazione = idPrenotazione;
	}
	public String getPosizioneInizio() {
		return posizioneInizio;
	}
	public void setPosizioneInizio(String posizioneInizio) {
		this.posizioneInizio = posizioneInizio;
	}
	public String getPosizioneFine() {
		return posizioneFine;
	}
	public void setPosizioneFine(String posizioneFine) {
		this.posizioneFine = posizioneFine;
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


	public Integer getIdBici() {
		return idBici;
	}


	public void setIdBici(Integer idBici) {
		this.idBici = idBici;
	}
	
	
	
}
