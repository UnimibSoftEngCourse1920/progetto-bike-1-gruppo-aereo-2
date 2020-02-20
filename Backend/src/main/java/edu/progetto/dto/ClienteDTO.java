package edu.progetto.dto;

import edu.progetto.entity.Ruolo;

public class ClienteDTO {
	 private String nome;
	 private String cognome;
	 private String email;
	 private String username;
	 private String password;
	 private Ruolo ruolo;
	 

	public ClienteDTO(String nome, String cognome, String email, String username, String password, Ruolo ruolo) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.username = username;
		this.password = password;
		this.ruolo = ruolo;
	}
	public Ruolo getRuolo() {
		return ruolo;
	}
	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
