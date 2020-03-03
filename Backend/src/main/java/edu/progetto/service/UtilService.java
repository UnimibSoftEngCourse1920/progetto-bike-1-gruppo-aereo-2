package edu.progetto.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

@Service
public class UtilService {

	private static final String FORMATO_DATA = "yyyy-MM-dd HH:mm";
	
	private static Double costoAlMinuto = 0.10;

	public LocalDateTime calcolaData(String ora) {
		LocalDate giorno = LocalDate.now();
		String completa = giorno.toString()+" "+ ora;
		return LocalDateTime.parse(completa, DateTimeFormatter.ofPattern(FORMATO_DATA));
	}

	public LocalDateTime getData() {
		return LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern(FORMATO_DATA)),
				DateTimeFormatter.ofPattern(FORMATO_DATA));
	}

	public Double calcolaImporto(String oraInizio, String oraFine) {
		return this.calcolaImporto(this.calcolaData(oraInizio), this.calcolaData(oraFine));
	}


	public Double calcolaImporto(LocalDateTime oraInizio, LocalDateTime oraFine) {
		double differenzaOre = (oraFine.getHour() - oraInizio.getHour()) * costoAlMinuto * 60;
		double differenzaMinuti = (oraFine.getMinute() - oraInizio.getMinute()) * costoAlMinuto;
		return BigDecimal.valueOf(differenzaOre + differenzaMinuti)
	            .setScale(3, RoundingMode.HALF_UP)
	            .doubleValue();
	}
}
