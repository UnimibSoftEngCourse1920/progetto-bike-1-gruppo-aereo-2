package edu.progetto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.progetto.request.InfoRequest;
import edu.progetto.request.ReservationRequest;
import edu.progetto.response.MessageResponse;
import edu.progetto.response.ReservationResponse;
import edu.progetto.service.PrenotazioneService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {

	@Autowired
	PrenotazioneService prenotazioneService;


	@PostMapping(value = "/prenota")
	public ResponseEntity<MessageResponse> prenotaBici(@RequestBody ReservationRequest reservationRequest){
		return ResponseEntity.ok(new MessageResponse(prenotazioneService.prenotaBici(reservationRequest)));
	}


	@PostMapping(value = "/mie")
	public List<ReservationResponse> getAllPrenotazioni(@RequestBody InfoRequest infoRequest){
		return prenotazioneService.getPrenotazioniByUsername(infoRequest.getUsername());
	}




}
