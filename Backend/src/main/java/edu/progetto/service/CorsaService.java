package edu.progetto.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.progetto.entity.Bici;
import edu.progetto.entity.Corsa;
import edu.progetto.entity.Prenotazione;
import edu.progetto.entity.Rastrelliera;
import edu.progetto.entity.StatoPrenotazione;
import edu.progetto.repository.CorsaRepository;

@Service
public class CorsaService {

	private static final String FORMATO_DATA = "yyyy-MM-dd HH:mm";

	@Autowired
	CorsaRepository corsaRepo;


	@Autowired
	PrenotazioneService prenotazioneService;

	@Autowired
	RastrellieraService rastrellieraService;

	@Autowired
	BiciService biciService;

	public LocalDateTime iniziaCorsa(Integer idPrenotazione) {
		Prenotazione p = prenotazioneService.getPrenotazioneById(idPrenotazione);
		p.setStatoPrenotazione(StatoPrenotazione.IN_CORSO);
		prenotazioneService.updatePrenotazione(p.getId(), p);

		Corsa corsa = new Corsa();
		LocalDateTime inizioCorsa = LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern(FORMATO_DATA)),
				DateTimeFormatter.ofPattern(FORMATO_DATA));
		corsa.setInizioCorsa(inizioCorsa);
		corsa.setPrenotazione(p);
		corsaRepo.save(corsa);
		return inizioCorsa;
	}


	public LocalDateTime finisciCorsa(Integer idPrenotazione) {
		Prenotazione p = prenotazioneService.getPrenotazioneById(idPrenotazione);
		Corsa corsa = corsaRepo.findByPrenotazione(p);
		Bici bici = biciService.getBici(p.getBici().getId());
		Rastrelliera rastrellieraPartenza = rastrellieraService.getRastrelliera(p.getRastrellieraPartenza().getId());
		Rastrelliera rastrellieraArrivo = rastrellieraService.getRastrelliera(p.getRastrellieraArrivo().getId());
		rastrellieraService.spostaBici(rastrellieraPartenza, rastrellieraArrivo, bici);
		bici.setDisponibile(true);
		biciService.updateBici(bici.getId(), bici);		
		p.setStatoPrenotazione(StatoPrenotazione.PASSATA);
		prenotazioneService.updatePrenotazione(p.getId(), p);
		LocalDateTime fineCorsa = LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern(FORMATO_DATA)),
				DateTimeFormatter.ofPattern(FORMATO_DATA));
		corsa.setFineCorsa(fineCorsa);
		corsaRepo.save(corsa);
		rastrellieraService.spostaBici(rastrellieraPartenza, rastrellieraArrivo, bici);
		//prenotazioneService.updatePrenotazione(p.getId(), p);	
		return fineCorsa;

	}
	
	public List<Corsa> getAllCorse(){
		List<Corsa> corse= new ArrayList<>();
		for (Corsa c : corsaRepo.findAll()){
			corse.add(c);
		}
		return corse;
	}
}
