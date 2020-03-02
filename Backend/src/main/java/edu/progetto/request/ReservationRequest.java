package edu.progetto.request;

import java.io.Serializable;

public class ReservationRequest implements Serializable {

	private static final long serialVersionUID = -8892729993882809980L;

	private String posizionePartenza;

	private String posizioneArrivo;

	private String username;

	private Integer idBici;

	private String oraInizio;

	private String oraFine;

	private Double importo;

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

	public Double getImporto() {
		return importo;
	}

	public void setImporto(Double importo) {
		this.importo = importo;
	}

	public ReservationRequest(String posizionePartenza, String posizioneArrivo, String username, Integer idBici,
			String oraInizio, String oraFine, Double importo) {
		this.setPosizionePartenza(posizionePartenza);
		this.setPosizioneArrivo(posizioneArrivo);
		this.setUsername(username);
		this.setIdBici(idBici);
		this.setOraInizio(oraInizio);
		this.setOraFine(oraFine);
		this.setImporto(importo);
	}

	public ReservationRequest() {

	}







}
