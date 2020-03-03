package edu.progetto.response;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ReservationResponse implements Serializable{

	private static final long serialVersionUID = -890419640386907278L;

	private Integer idPrenotazione;
	private String posizioneInizio;
	private String posizioneFine;
	private LocalDateTime oraInizio;
	private LocalDateTime oraFine;
	private String statoPrenotazione;
	private Integer idBici;
	private Double importo;

	public ReservationResponse(Integer idPrenotazione, String posizioneInizio, String posizioneFine, LocalDateTime oraInizio,
			LocalDateTime oraFine, Integer idBici, Double importo) {
		this.idPrenotazione = idPrenotazione;
		this.posizioneInizio = posizioneInizio;
		this.posizioneFine = posizioneFine;
		this.oraInizio = oraInizio;
		this.oraFine = oraFine;
		this.idBici = idBici;
		this.importo = importo;
	}
	public ReservationResponse() {
		
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
	public LocalDateTime getOraInizio() {
		return oraInizio;
	}
	public void setOraInizio(LocalDateTime oraInizio) {
		this.oraInizio = oraInizio;
	}
	public LocalDateTime getOraFine() {
		return oraFine;
	}
	public void setOraFine(LocalDateTime oraFine) {
		this.oraFine = oraFine;
	}


	public String getStatoPrenotazione() {
		return statoPrenotazione;
	}


	public void setStatoPrenotazione(String statoPrenotazione) {
		this.statoPrenotazione = statoPrenotazione;
	}


	public Integer getIdBici() {
		return idBici;
	}


	public void setIdBici(Integer idBici) {
		this.idBici = idBici;
	}


	public Double getImporto() {
		return importo;
	}


	public void setImporto(Double importo) {
		this.importo = importo;
	}
}
