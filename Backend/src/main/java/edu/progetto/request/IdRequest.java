package edu.progetto.request;

import java.io.Serializable;

public class IdRequest implements Serializable  {

	private static final long serialVersionUID = 8183330199821459375L;
	
	private Integer id;

	
	public IdRequest() {
		
	}
	
	public IdRequest(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
