package edu.progetto.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.progetto.entity.Bici;
import edu.progetto.entity.Prenotazione;
import edu.progetto.entity.StatoPrenotazione;
import edu.progetto.repository.ClienteRepository;
import edu.progetto.repository.PrenotazioneRepository;
import edu.progetto.repository.RastrellieraRepository;
import edu.progetto.request.ReservationRequest;
import edu.progetto.response.ReservationResponse;

@Service
@SuppressWarnings(value = { })
public class PrenotazioneService {

	@Autowired
	ClienteRepository clienteRepo;

	@Autowired
	PrenotazioneRepository prenotazioneRepo;

	@Autowired
	RastrellieraRepository rastrellieraRepo;

	@Autowired
	BiciService biciService;

	@Autowired
	UtilService utilService;

	@Autowired
	ContoService contoService;



	public String prenotaBici(ReservationRequest reservationRequest) {
		try {
			Prenotazione prenotazione = new Prenotazione();
			prenotazione.setCliente(clienteRepo.findByUsername(reservationRequest.getUsername()));
			prenotazione.setRastrellieraPartenza(rastrellieraRepo.findByPosizione(reservationRequest.getPosizionePartenza()));
			prenotazione.setRastrellieraArrivo(rastrellieraRepo.findByPosizione(reservationRequest.getPosizioneArrivo()));
			prenotazione.setOraInizio(utilService.calcolaData(reservationRequest.getOraInizio()));
			prenotazione.setOraFine(utilService.calcolaData(reservationRequest.getOraFine()));
			prenotazione.setStatoPrenotazione(StatoPrenotazione.DA_INIZIARE);
			prenotazione.setImporto(reservationRequest.getImporto());
			Bici bici = biciService.getBici(reservationRequest.getIdBici());
			bici.setDisponibile(false);
			biciService.updateBici(reservationRequest.getIdBici(), bici);

			prenotazione.setBici(bici);
			prenotazioneRepo.save(prenotazione);

			contoService.addebita(reservationRequest.getUsername(), reservationRequest.getImporto());

			return "Prenotazione effettuata con successo";
		}
		catch(Exception e) {
			return "Errore durante la prenotazione";
		}
	}


	public List<Prenotazione> getAllPrenotazioni(){
		List<Prenotazione> prenotazioni = new ArrayList<>();
		for (Prenotazione p : prenotazioneRepo.findAll()){
			prenotazioni.add(p);
		}
		return prenotazioni;
	}

	public List<ReservationResponse> getPrenotazioniByUsername(String username) {
		List<Prenotazione> miePrenotazione = prenotazioneRepo.findByCliente(clienteRepo.findByUsername(username));
		List<ReservationResponse> listPrenotazioneResponse = new ArrayList<>();
		for(Prenotazione p : miePrenotazione) {
			ReservationResponse prenotazioneResponse= new ReservationResponse();
			prenotazioneResponse.setIdPrenotazione(p.getId());
			prenotazioneResponse.setPosizioneInizio(p.getRastrellieraPartenza().getPosizione());
			prenotazioneResponse.setPosizioneFine(p.getRastrellieraArrivo().getPosizione());
			prenotazioneResponse.setOraInizio(p.getOraInizio().toString());
			prenotazioneResponse.setOraFine(p.getOraFine().toString());
			prenotazioneResponse.setStatoPrenotazione(p.getStatoPrenotazione().toString());
			prenotazioneResponse.setIdBici(p.getBici().getId());
			prenotazioneResponse.setImporto(p.getImporto());
			listPrenotazioneResponse.add(prenotazioneResponse);
		}

		return listPrenotazioneResponse;
	}

	public Prenotazione getPrenotazioneById(Integer idPrenotazione) {
		return prenotazioneRepo.findById(idPrenotazione)
				.orElseThrow(() -> new EntityNotFoundException());

	}


	public void updatePrenotazione(Integer id,Prenotazione p) {
		prenotazioneRepo.findById(id);
		prenotazioneRepo.save(p);
	}

}