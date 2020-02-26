package edu.progetto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.progetto.entity.Bici;
import edu.progetto.entity.Prenotazione;
import edu.progetto.repository.ClienteRepository;
import edu.progetto.repository.PrenotazioneRepository;
import edu.progetto.repository.RastrellieraRepository;
import edu.progetto.request.ReservationRequest;

@Service
public class PrenotazioneService {

	@Autowired
	ClienteRepository clienteRepo;

	@Autowired
	PrenotazioneRepository prenotazioneRepo;

	@Autowired
	RastrellieraRepository rastrellieraRepo;

	@Autowired
	BiciService biciService;


	public String prenotaBici(ReservationRequest reservationRequest) {
		try {
			Prenotazione prenotazione = new Prenotazione();
			prenotazione.setCliente(clienteRepo.findByUsername(reservationRequest.getUsername()));
			prenotazione.setRastrellieraPartenza(rastrellieraRepo.findByPosizione(reservationRequest.getPosizionePartenza()));
			prenotazione.setRastrellieraArrivo(rastrellieraRepo.findByPosizione(reservationRequest.getPosizioneArrivo()));
			prenotazione.setOraInizio(reservationRequest.getOraInizio());
			prenotazione.setOraFine(reservationRequest.getOraFine());

			Bici bici = biciService.getBici(reservationRequest.getIdBici());
			bici.setDisponibile(false);
			biciService.updateBici(reservationRequest.getIdBici(), bici);
				
			prenotazione.setBici(bici);
			prenotazioneRepo.save(prenotazione);
			
			return "Prenotazione effettuata con successo";
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return "Errore durante la prenotazione";

	}
	
	
	public List<Prenotazione> getAllPrenotazioni(){
		List<Prenotazione> prenotazioni = new ArrayList<>();
		for (Prenotazione p : prenotazioneRepo.findAll()){
			prenotazioni.add(p);
		}
		return prenotazioni;
		
	}

}
