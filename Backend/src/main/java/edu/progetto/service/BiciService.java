package edu.progetto.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.progetto.entity.Bici;
import edu.progetto.repository.BiciRepository;


@Service
public class BiciService {

	@Autowired
	BiciRepository biciRepo;
	
	public List<Bici> getAllbici() {
		List<Bici> bici = new ArrayList<>();
		for (Bici b : biciRepo.findAll()){
			bici.add(b);
		}
		return bici;
	}

	public Bici getBici(Integer id) {
		return biciRepo.findById(id)
				.orElseThrow(() -> new EntityNotFoundException());
	}

	public void addBici(Bici b) {
		biciRepo.save(b);
	}

	public void updateBici(Integer id, Bici b) {
		biciRepo.save(b);
	}
	
	public void deleteBici(Integer id) {
		biciRepo.deleteById(id);
	}	
}
