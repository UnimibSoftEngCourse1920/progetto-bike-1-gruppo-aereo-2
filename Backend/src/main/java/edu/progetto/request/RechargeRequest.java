package edu.progetto.request;

import java.io.Serializable;

public class RechargeRequest implements Serializable {

	private static final long serialVersionUID = 5280113865825658959L;
	
	private String username;
	
	private Double importo;
	
	public RechargeRequest() {
		
	}

	public RechargeRequest(String username, Double importo) {
		this.username = username;
		this.importo = importo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Double getImporto() {
		return importo;
	}

	public void setImporto(Double importo) {
		this.importo = importo;
	}

}
