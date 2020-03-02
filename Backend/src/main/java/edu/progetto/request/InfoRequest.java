package edu.progetto.request;

import java.io.Serializable;

public class InfoRequest implements Serializable{
	
	private static final long serialVersionUID = 1704343924896164741L;

	private String username;

	
	public InfoRequest() {
		
	}
	
	public InfoRequest(String username) {
		this.username = username;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
