package edu.progetto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.progetto.entity.Bici;
import edu.progetto.request.IdRequest;
import edu.progetto.response.MessageResponse;
import edu.progetto.response.ReallocationResponse;
import edu.progetto.service.BiciService;
import edu.progetto.service.RastrellieraService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/manutenzione")
public class ManutenzioneController {

	@Autowired
	private RastrellieraService rastrellieraService;
	
	@Autowired
	private BiciService biciService;

	@GetMapping("/rialloca")
	public ResponseEntity<MessageResponse> riallocaRastrelliere() {
		rastrellieraService.rialloca();
		return ResponseEntity.ok(new MessageResponse("Rastrelliere riallocate con successo"));
	}

	@GetMapping("/rastrelliere-bici")
	public List<ReallocationResponse> getPosizioneNumBici(){
		return this.rastrellieraService.getPosizioneNumBici();
	}
	
	
	@GetMapping("/bici")
	public List<Bici> getBiciDaRiparare(){
		return this.biciService.getBiciDaRiparare();
	}
	
	@PostMapping("/ripara")
	public ResponseEntity<MessageResponse> riparaBici(@RequestBody IdRequest idRequest) {
		this.biciService.riparaBici(idRequest.getId());
		return ResponseEntity.ok(new MessageResponse("Bici nuovamente disponibile"));
	}
	

}
