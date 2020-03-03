package edu.progetto.response;

import java.io.Serializable;
import java.util.List;

import edu.progetto.entity.Bici;

public class FiltersResponse implements Serializable{

	private static final long serialVersionUID = -572760084248835847L;

	private List<Bici> listaBici;

	private Double importo;

	public FiltersResponse() {

	}

	public FiltersResponse(List<Bici> listaBici, Double importo) {
		this.listaBici = listaBici;
		this.importo = importo;
	}

	public List<Bici> getListaBici() {
		return listaBici;
	}

	public void setListaBici(List<Bici> listaBici) {
		this.listaBici = listaBici;
	}

	public Double getImporto() {
		return importo;
	}

	public void setImporto(Double importo) {
		this.importo = importo;
	}

}
