package edu.progetto.service;


import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.progetto.entity.Bici;
import edu.progetto.entity.Corsa;
import edu.progetto.entity.Prenotazione;
import edu.progetto.entity.Ruolo;
import edu.progetto.entity.StatoPrenotazione;
import edu.progetto.repository.CorsaRepository;

@Service
public class CorsaService {

	private static DecimalFormat df2 = new DecimalFormat("#.##");

	@Autowired
	CorsaRepository corsaRepo;

	@Autowired
	PrenotazioneService prenotazioneService;

	@Autowired
	RastrellieraService rastrellieraService;

	@Autowired
	BiciService biciService;

	@Autowired
	ContoService contoService;

	@Autowired
	UtilService utilService;

	public LocalDateTime iniziaCorsa(Integer idPrenotazione) {
		Prenotazione p = prenotazioneService.getPrenotazioneById(idPrenotazione);
		p.setStatoPrenotazione(StatoPrenotazione.IN_CORSO);
		prenotazioneService.updatePrenotazione(p.getId(), p);
		Corsa corsa = new Corsa();
		LocalDateTime inizioCorsa = utilService.getData();
		corsa.setInizioCorsa(inizioCorsa);
		corsa.setPrenotazione(p);
		corsaRepo.save(corsa);
		return inizioCorsa;
	}


	public String finisciCorsa(Integer idPrenotazione) {
		Prenotazione p = prenotazioneService.getPrenotazioneById(idPrenotazione);
		Corsa corsa = corsaRepo.findByPrenotazione(p);
		Bici bici = biciService.getBici(p.getBici().getId());
		rastrellieraService.spostaBici(p.getRastrellieraPartenza(), p.getRastrellieraArrivo(), bici);
		bici.setDisponibile(true);
		bici.setStatoBici(bici.getStatoBici() - 1);
		biciService.updateBici(bici.getId(), bici);		
		p.setStatoPrenotazione(StatoPrenotazione.PASSATA);
		prenotazioneService.updatePrenotazione(p.getId(), p);
		LocalDateTime fineCorsa = utilService.getData();
		corsa.setFineCorsa(fineCorsa);
		corsaRepo.save(corsa);
		
		Double importoFineCorsa = utilService.calcolaImporto(p.getOraFine(), fineCorsa);
		if (importoFineCorsa > 0.0 && !p.getCliente().getRuolo().equals(Ruolo.ROLE_PERSONALE) ) {
			contoService.addebita(p.getCliente().getUsername(), importoFineCorsa);
			return "Ti è stato addebitata una sanzione di " + df2.format(importoFineCorsa) +
					"€ perchè hai ritardato la consegna prevista alle: "+p.getOraFine()+
					" mentre hai riconsegnato alle: "+ fineCorsa;
		}

		return "Corsa terminata correttamente";

	}

	public List<Corsa> getAllCorse(){
		List<Corsa> corse= new ArrayList<>();
		for (Corsa c : corsaRepo.findAll()){
			corse.add(c);
		}
		return corse;
	}
}
