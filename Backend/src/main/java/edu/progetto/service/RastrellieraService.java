package edu.progetto.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.progetto.entity.Bici;
import edu.progetto.entity.Rastrelliera;
import edu.progetto.repository.RastrellieraRepository;
import edu.progetto.response.ReallocationResponse;

@Service
public class RastrellieraService {

	@Autowired
	private RastrellieraRepository rastrellieraRepo;


	public List<Rastrelliera> getAllRastrelliere() {
		List<Rastrelliera> rastrelliere = new ArrayList<>();
		for (Rastrelliera r : rastrellieraRepo.findAll()){
			rastrelliere.add(r);
		}
		return rastrelliere;
	}


	public List<String> getVieRastrelliere(){
		List<String> vieRastrelliere = new ArrayList<>();

		for(Rastrelliera r : rastrellieraRepo.findAll()) {
			vieRastrelliere.add(r.getPosizione());
		}

		return vieRastrelliere;
	}

	public Rastrelliera findByPosizione(String posizione) {
		return rastrellieraRepo.findByPosizione(posizione);
	}

	public List<Bici> getAllBiciDisponibili(String posizione){
		Rastrelliera rastrelliera = rastrellieraRepo.findByPosizione(posizione);
		List<Bici> bici = new ArrayList<>();
		for(Bici b : rastrelliera.getListaBici()) {
			if(b.isDisponibile() && b.getStatoBici() > 2)
				bici.add(b);
		}
		return bici;
	}

	public void updateRastrelliera(Integer id, Rastrelliera r) {
		rastrellieraRepo.findById(id);
		rastrellieraRepo.save(r);
	}


	public void rialloca() {
		for (Rastrelliera r : rastrellieraRepo.findAll())
			if (r.getListaBici().size() > 5) 
				for(Rastrelliera r2 : rastrellieraRepo.findAll()) 
					if (r2.getListaBici().size() < 5) {
						spostaBici(r, r2, r.getListaBici().get(0));
					}
	}

	public void spostaBici(Rastrelliera r1 , Rastrelliera r2, Bici bici) {
		r1.removeBici(bici);
		this.updateRastrelliera(r1.getId(), r1);
		r2.addBici(bici);
		this.updateRastrelliera(r2.getId(), r2);
	}


	public Rastrelliera getRastrelliera(Integer id) {
		return rastrellieraRepo.findById(id).
				orElseThrow(() -> new EntityNotFoundException());
	}


	public List<ReallocationResponse> getPosizioneNumBici(){
		List<ReallocationResponse> listReallocationResp = new ArrayList<>();
		for(Rastrelliera r : rastrellieraRepo.findAll()) {
			ReallocationResponse reallocationResponse = new
					ReallocationResponse(r.getPosizione(),r.getListaBici().size());
			listReallocationResp.add(reallocationResponse);
		}
		return listReallocationResp;
	}
}
