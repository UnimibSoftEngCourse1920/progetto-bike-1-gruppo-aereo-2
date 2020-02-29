package edu.progetto.entity;



import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import edu.progetto.dto.ClienteDTO;

@Entity
@Table(name = "clienti")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	private String nome;

	private String cognome;

	@Email
	private String email;

	private String username;

	private String password;

	//	@ManyToOne
	//	@JoinTable(	name = "clienti_ruoli", 
	//				joinColumns = @JoinColumn(name = "cliente_id"), 
	//				inverseJoinColumns = @JoinColumn(name = "ruolo_id"))
	@Enumerated(EnumType.STRING)
	private Ruolo ruolo;


	public Ruolo getRuolo() {
		return ruolo;
	}

	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}

	public Cliente() {
	}

	public Cliente(String nome, String cognome, String email,String username, String password, Ruolo ruolo) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.username = username;
		this.password = password;
		this.ruolo = ruolo;
	}

	public Cliente(ClienteDTO clienteDTO) {
		this.nome = clienteDTO.getNome();
		this.cognome = clienteDTO.getCognome();
		this.email = clienteDTO.getEmail();
		this.username = clienteDTO.getUsername();
		this.password = clienteDTO.getPassword();
		this.ruolo = clienteDTO.getRuolo();
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
