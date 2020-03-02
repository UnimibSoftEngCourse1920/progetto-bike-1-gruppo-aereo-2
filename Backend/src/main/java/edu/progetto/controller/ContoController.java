package edu.progetto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.progetto.request.InfoRequest;
import edu.progetto.request.RechargeRequest;
import edu.progetto.response.MessageResponse;
import edu.progetto.service.ContoService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/conto")
public class ContoController {
	
	@Autowired
	private ContoService contoService;
	
	@PostMapping(value = "/ricarica")
	public ResponseEntity<MessageResponse> ricarica(@RequestBody RechargeRequest rechargeRequest) {
		return ResponseEntity.ok(new MessageResponse(contoService.ricarica(rechargeRequest.getUsername(), rechargeRequest.getImporto())));
	}
	
	@GetMapping(value = "/saldo")
	public Double getSaldo(@RequestBody InfoRequest infoRequest) {
		return contoService.getSaldoDisponibile(infoRequest.getUsername());
	}
	
	
	

}
