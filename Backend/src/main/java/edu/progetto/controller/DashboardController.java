package edu.progetto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import edu.progetto.response.HistogramResponse;
import edu.progetto.response.PieResponse;
import edu.progetto.service.CorsaService;
import edu.progetto.service.PrenotazioneService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/dashboard")
public class DashboardController {
	
	@Autowired
	private PrenotazioneService prenotazioneService;
	
	@Autowired
	private CorsaService corsaService;
	
	@GetMapping(value = "/histogram")
	public List<HistogramResponse> getHistogramData(){
		return prenotazioneService.countByRastrellieraPartenza();
	}
	
	@GetMapping(value = "/pie")
	public List<PieResponse> getPieData(){
		return corsaService.countByTime();
	}
}
