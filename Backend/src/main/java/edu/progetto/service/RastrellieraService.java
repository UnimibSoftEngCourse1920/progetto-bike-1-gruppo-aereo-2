package edu.progetto.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.stereotype.Service;

import edu.progetto.entity.Bici;
import edu.progetto.entity.Rastrelliera;
import edu.progetto.repository.RastrellieraRepository;

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


	public List<Bici> getAllBiciDisponibili(String posizione){
		Rastrelliera rastrelliera = rastrellieraRepo.findByPosizione(
				new BasicJsonParser().parseMap(posizione).get("posizione").toString());
		List<Bici> bici = new ArrayList<>();
		for(Bici b : rastrelliera.getListaBici()) {
			if(b.isDisponibile())
				bici.add(b);
		}
		return bici;
	}

	public void updateRastrelliera(Integer id, Rastrelliera r) {
		rastrellieraRepo.save(r);
	}


	public void rialloca() {
		for (Rastrelliera r : rastrellieraRepo.findAll())
			if (r.getListaBici().size() > 2) 
				for(Rastrelliera r2 : rastrellieraRepo.findAll()) 
					if (r2.getListaBici().size() < 2) {
						spostaBici(r, r2, r.getListaBici().get(0));
					}
	}

	public void spostaBici(Rastrelliera r1 , Rastrelliera r2, Bici bici) {
		int indexOfBici = r1.getListaBici().indexOf(bici);
		r2.getListaBici().add(r1.getListaBici().get(indexOfBici));
		r1.getListaBici().remove(bici);
		this.updateRastrelliera(r1.getId(), r1);
		this.updateRastrelliera(r2.getId(), r2);
	}


	public Rastrelliera getRastrelliera(Integer id) {
		return rastrellieraRepo.findById(id).
				orElseThrow(() -> new EntityNotFoundException());
	}

	












}
