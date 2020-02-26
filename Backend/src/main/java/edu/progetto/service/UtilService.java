package edu.progetto.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

@Service
public class UtilService {
	
	public LocalDateTime calcolaData(String ora) {
		LocalDate giorno = LocalDate.now();
		String completa = giorno.toString()+" "+ ora;
		return LocalDateTime.parse(completa, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		
	}
}
