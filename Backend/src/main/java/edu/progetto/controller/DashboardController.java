package edu.progetto.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.progetto.entity.Rastrelliera;
import edu.progetto.response.HistogramResponse;
import edu.progetto.service.PrenotazioneService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/dashboard")
public class DashboardController {
	
	@Autowired
	private PrenotazioneService prenotazioneService;
	
	@GetMapping(value = "/boh")
	public List<HistogramResponse> countByRastrellieraPartenza(){
		return prenotazioneService.countByRastrellieraPartenza();
	}
	
	//ritorna una lista <key,value> con key --> posizioneRastre e value il contPrenotazionibyPosizione
}
