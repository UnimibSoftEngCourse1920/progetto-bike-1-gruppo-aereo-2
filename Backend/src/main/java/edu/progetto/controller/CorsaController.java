package edu.progetto.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.progetto.entity.Corsa;
import edu.progetto.request.JourneyRequest;
import edu.progetto.service.CorsaService;

@RestController
public class CorsaController {

	@Autowired
	CorsaService corsaService;


	@PostMapping("/inizia-corsa")
	public LocalDateTime iniziaCorsa(@RequestBody JourneyRequest journeyRequest) {
		return corsaService.iniziaCorsa(journeyRequest.getIdPrenotazione());
	}

	@PutMapping("/finisci-corsa")
	public LocalDateTime finisciCorsa(@RequestBody JourneyRequest journeyRequest) {
		return corsaService.finisciCorsa(journeyRequest.getIdPrenotazione());
	}

	@GetMapping("/corse-tutte")
	public List<Corsa> getAllCorse(){
		return corsaService.getAllCorse();
	}
}
