package edu.progetto.response;

import java.io.Serializable;

public class PieResponse implements Serializable {

	private static final long serialVersionUID = -6824137585981490403L;
	
	private Integer y;
	
	private String name;
		
	public PieResponse() {
		
	}

	public PieResponse(Integer y, String name) {
		this.y = y;
		this.name = name;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
