package edu.progetto.request;

import java.io.Serializable;

public class SubscriptionRequest implements Serializable{

	private static final long serialVersionUID = -3076746626266084107L;

	private String username;
	
	private String tipo;
	
	public SubscriptionRequest() {
		
	}

	public SubscriptionRequest(String username, String tipo) {
		this.username = username;
		this.tipo = tipo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
