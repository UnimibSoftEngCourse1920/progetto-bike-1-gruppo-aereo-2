package edu.progetto.response;

import java.io.Serializable;

public class HistogramResponse implements Serializable{

	private static final long serialVersionUID = 5080173510031235561L;

	private String label;
	
	private long y;
	
	public HistogramResponse() {
		
	}
	
	public HistogramResponse(String label, long y) {
		this.label = label;
		this.y = y;
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
