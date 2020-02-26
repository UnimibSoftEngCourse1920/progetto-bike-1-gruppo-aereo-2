package edu.progetto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.progetto.entity.Prenotazione;
import edu.progetto.request.ReservationRequest;
import edu.progetto.service.PrenotazioneService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/preno")
public class PrenotazioneController {

	@Autowired
	PrenotazioneService prenotazioneService;
	
	
	@PostMapping(value = "/prenota")
	@PreAuthorize("hasRole('GENERICO')")
	public String prenotaBici(@RequestBody ReservationRequest reservationRequest) {
		return prenotazioneService.prenotaBici(reservationRequest);
	}
	
	
	@GetMapping(value = "/prenotazioni")
	public List<Prenotazione> getAllPrenotazioni(){
		return prenotazioneService.getAllPrenotazioni();
	}
	
	
	
	
}
