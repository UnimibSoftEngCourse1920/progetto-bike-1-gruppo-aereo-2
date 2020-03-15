package edu.progetto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.progetto.request.InfoRequest;
import edu.progetto.request.SubscriptionRequest;
import edu.progetto.response.MessageResponse;
import edu.progetto.service.AbbonamentoService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/abbonamento")
public class AbbonamentoController {

	@Autowired
	AbbonamentoService abbonamentoService;
	//getScadenza

	@PostMapping("/scadenza")
	public ResponseEntity<MessageResponse> getScadenza(@RequestBody InfoRequest infoRequest) {
		return ResponseEntity.ok(new MessageResponse(
				abbonamentoService.getScadenza(infoRequest.getUsername())));
	}

	@PostMapping("/ricarica")
	public ResponseEntity<MessageResponse> ricaricaAbbonamento(@RequestBody SubscriptionRequest subscriptionRequest) {
		return ResponseEntity.ok(new MessageResponse(
				abbonamentoService.ricarica(subscriptionRequest.getUsername(),subscriptionRequest.getTipo())));
	}




}
