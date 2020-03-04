package edu.progetto.response;

import java.io.Serializable;

public class HistogramResponse implements Serializable{

	private static final long serialVersionUID = 5080173510031235561L;

	private long y;
	
	private String label;
	
	public HistogramResponse() {
		
	}
	
	public HistogramResponse(long y,String label) {
		this.y = y;
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public long getY() {
		return y;
	}

	public void setY(long y) {
		this.y = y;
	}



}
