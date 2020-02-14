package edu.progetto.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(	name = "cliente", 
uniqueConstraints = { 
	@UniqueConstraint(columnNames = "username"),
	@UniqueConstraint(columnNames = "email") 
})
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String cognome;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String username;
	
	@NotBlank
	private String password;
	
	
	public Cliente() {
	}
	
	public Cliente(String nome, String cognome, String email,String username, String password) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	
	public Integer getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCognome() {
		return cognome;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	
	public String getUsername() {
		return username;
	}
	
	
	
	
}