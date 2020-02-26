package edu.progetto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.progetto.entity.Rastrelliera;
import edu.progetto.service.RastrellieraService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class RastrellieraController {
	
	@Autowired
	private RastrellieraService rastrellieraService;
	
	@GetMapping("/rastrelliere")
	public List<String> getVieRastrelliere() {
		return rastrellieraService.getVieRastrelliere();
	}
	
	
	@GetMapping("/rastrelliere/info")
	public List<Rastrelliera> getAllRastrelliere(){
		return rastrellieraService.getAllRastrelliere();
	}
	
	
	@GetMapping("/rastrelliere/rialloca")
	@PreAuthorize("hasRole('ADMIN')")
	public String riallocaRastrelliere() {
		rastrellieraService.rialloca();
		return "Rastrelliere riallocate con successo";
	}
	
	
	
}
