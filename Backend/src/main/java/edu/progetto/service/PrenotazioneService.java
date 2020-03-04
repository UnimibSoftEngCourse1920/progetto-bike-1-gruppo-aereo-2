package edu.progetto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.progetto.entity.Bici;
import edu.progetto.entity.Prenotazione;
import edu.progetto.entity.Rastrelliera;
import edu.progetto.entity.Ruolo;
import edu.progetto.entity.StatoPrenotazione;
import edu.progetto.repository.PrenotazioneRepository;
import edu.progetto.request.FiltersRequest;
import edu.progetto.request.ReservationRequest;
import edu.progetto.response.FiltersResponse;
import edu.progetto.response.HistogramResponse;
import edu.progetto.response.ReservationResponse;

@Service
public class PrenotazioneService {

	@Autowired
	ClienteService clienteService;

	@Autowired
	PrenotazioneRepository prenotazioneRepo;

	@Autowired
	RastrellieraService rastrellieraService;

	@Autowired
	BiciService biciService;

	@Autowired
	UtilService utilService;

	@Autowired
	ContoService contoService;



	public String prenotaBici(ReservationRequest reservationRequest) {
		try {
			Bici bici = biciService.getBici(reservationRequest.getIdBici());
			if(bici.isDisponibile()) {
				if (contoService.getSaldoDisponibile(reservationRequest.getUsername()) <= reservationRequest.getImporto()) {
					Prenotazione prenotazione = new Prenotazione();
					prenotazione.setCliente(clienteService.findByUsername(reservationRequest.getUsername()));
					prenotazione.setRastrellieraPartenza(rastrellieraService.findByPosizione(
							reservationRequest.getPosizionePartenza()));
					prenotazione.setRastrellieraArrivo(rastrellieraService.findByPosizione(
							reservationRequest.getPosizioneArrivo()));
					prenotazione.setOraInizio(utilService.calcolaData(reservationRequest.getOraInizio()));
					prenotazione.setOraFine(utilService.calcolaData(reservationRequest.getOraFine()));
					prenotazione.setStatoPrenotazione(StatoPrenotazione.DA_INIZIARE);
					prenotazione.setImporto(reservationRequest.getImporto());

					bici.setDisponibile(false);
					biciService.updateBici(reservationRequest.getIdBici(), bici);

					prenotazione.setBici(bici);
					prenotazioneRepo.save(prenotazione);

					contoService.addebita(reservationRequest.getUsername(), reservationRequest.getImporto());

					return "Prenotazione effettuata con successo";
				}
				return "Il saldo non è sufficiente per effettuare la prenotazione";
			}
			return "Bici già prenotata";
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
		List<Prenotazione> miePrenotazione = prenotazioneRepo.findByCliente
				(clienteService.findByUsername(username));
		List<ReservationResponse> listPrenotazioneResponse = new ArrayList<>();
		for(Prenotazione p : miePrenotazione) {
			ReservationResponse prenotazioneResponse= new ReservationResponse();
			prenotazioneResponse.setIdPrenotazione(p.getId());
			prenotazioneResponse.setPosizioneInizio(p.getRastrellieraPartenza().getPosizione());
			prenotazioneResponse.setPosizioneFine(p.getRastrellieraArrivo().getPosizione());
			prenotazioneResponse.setOraInizio(p.getOraInizio());
			prenotazioneResponse.setOraFine(p.getOraFine());
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

	public FiltersResponse searchFilters(FiltersRequest filtersRequest) {
		FiltersResponse filtersResponse = new FiltersResponse();
		filtersResponse.setListaBici(rastrellieraService.getAllBiciDisponibili(
				filtersRequest.getPosizioneInizio()));
		if(filtersRequest.getRuolo().equals(Ruolo.ROLE_PERSONALE.toString()))
			filtersResponse.setImporto(0.00);
		else 
			filtersResponse.setImporto(utilService.calcolaImporto(filtersRequest.getOraInizio(),filtersRequest.getOraFine()));
		return filtersResponse;
	}
	
	public List<HistogramResponse> countByRastrellieraPartenza(){
		return prenotazioneRepo.countByRastrellieraPartenza();
	}
}
