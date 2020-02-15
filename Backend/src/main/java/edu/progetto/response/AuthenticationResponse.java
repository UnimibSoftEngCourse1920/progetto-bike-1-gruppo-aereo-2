package edu.progetto.response;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {

   
	private static final long serialVersionUID = 7486312091928903850L;
	
	private final String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
