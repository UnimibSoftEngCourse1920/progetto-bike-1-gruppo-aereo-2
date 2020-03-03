package edu.progetto.response;

import java.io.Serializable;


public class AuthenticationResponse implements Serializable {

   
	private static final long serialVersionUID = 7486312091928903850L;
	
	private final String jwt;
	private String username;
	private String ruolo;

    public AuthenticationResponse(String jwt, String username, String ruolo) {
        this.jwt = jwt;
        this.username = username;
        this.ruolo = ruolo;
    }

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public String getJwt() {
        return jwt;
    }
}
