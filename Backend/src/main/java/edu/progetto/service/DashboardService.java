package edu.progetto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.progetto.entity.Corsa;
import edu.progetto.repository.CorsaRepository;
import edu.progetto.repository.PrenotazioneRepository;
import edu.progetto.response.HistogramResponse;
import edu.progetto.response.PieResponse;

@Service
public class DashboardService {

	@Autowired
	CorsaRepository corsaRepo;

	@Autowired
	PrenotazioneRepository prenotazioneRepo;


	public List<HistogramResponse> countByRastrellieraPartenza(){
		return prenotazioneRepo.countByRastrellieraPartenza();
	}


	public List<PieResponse> countByTime() {
		List<PieResponse> listPieResponse = new ArrayList<>();
		int numMattina = 0;
		int numPomeriggio = 0;
		int numSera = 0;
		int numNotte = 0;
		
		for (Corsa corsa : corsaRepo.findAll()){
			int oraInizioCorsa = corsa.getInizioCorsa().getHour();
			if(oraInizioCorsa <= 6)
				numNotte++;
			if(oraInizioCorsa > 6 && oraInizioCorsa <= 12)
				numMattina++;
			if(oraInizioCorsa > 12 && oraInizioCorsa <= 18)
				numPomeriggio++;
			if(oraInizioCorsa > 18)
				numSera++;	
		}
		
		listPieResponse.add(new PieResponse(numNotte, "00:00 - 06:00"));
		listPieResponse.add(new PieResponse(numMattina, "06:00 - 12:00"));
		listPieResponse.add(new PieResponse(numPomeriggio, "12:00 - 18:00"));
		listPieResponse.add(new PieResponse(numSera, "18:00 - 24:00"));

		return listPieResponse;
	}
}
