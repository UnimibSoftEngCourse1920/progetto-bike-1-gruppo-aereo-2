package edu.progetto;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import edu.progetto.entity.Bici;
import edu.progetto.entity.Cliente;
import edu.progetto.entity.Conto;
import edu.progetto.entity.Rastrelliera;
import edu.progetto.entity.Ruolo;
import edu.progetto.entity.TipologiaBici;
import edu.progetto.repository.BiciRepository;
import edu.progetto.repository.ClienteRepository;
import edu.progetto.repository.ContoRepository;
import edu.progetto.repository.RastrellieraRepository;

@Component
@ConditionalOnProperty(name = "app.db-init", havingValue = "true")
public class DbInitializer implements CommandLineRunner {
	
	private RastrellieraRepository rastrellieraRepo;
	private ClienteRepository clienteRepo;
	private BiciRepository biciRepo;
	private ContoRepository contoRepo;
	
	@Autowired
	private PasswordEncoder bcryptoEncoder;

	public DbInitializer(RastrellieraRepository rastrellieraRepo, ClienteRepository clienteRepo,
			BiciRepository biciRepo, ContoRepository contoRepo) {
		this.rastrellieraRepo = rastrellieraRepo;
		this.clienteRepo = clienteRepo;
		this.biciRepo = biciRepo;
		this.contoRepo = contoRepo;
	}


	@Override
	public void run(String... args) throws Exception {

		
		this.clienteRepo.deleteAll();
		this.rastrellieraRepo.deleteAll();
		this.biciRepo.deleteAll();
		this.contoRepo.deleteAll();
		
		Cliente cliente1 = new Cliente("Oleg","Stoianov","oleg.stoianov@babbo.it","oleghinho",bcryptoEncoder.encode("1234"),Ruolo.ROLE_GENERICO);
		Cliente cliente2 = new Cliente("Lorenzo","Nosotti","lollo.noso@babbo.it","lollonoso",bcryptoEncoder.encode("4321"),Ruolo.ROLE_ADMIN);
		
		Conto conto1 = new Conto(cliente1, 0.00);
		Conto conto2 = new Conto(cliente2, 0.00);
		
		this.contoRepo.save(conto1);
		this.contoRepo.save(conto2);
		
		this.clienteRepo.save(cliente1);
		this.clienteRepo.save(cliente2);
		
		
		
		Rastrelliera rastrelliera1 = new Rastrelliera("Via Pitagora");
		Rastrelliera rastrelliera2 = new Rastrelliera("Via Socrate");
		Rastrelliera rastrelliera3 = new Rastrelliera("Via Platone");
		Rastrelliera rastrelliera4 = new Rastrelliera("Via Aristotele");
		Rastrelliera rastrelliera5 = new Rastrelliera("Via Talete");
		
		Bici bici1 = new Bici(true,5,TipologiaBici.CITTA);
		Bici bici2 = new Bici(true,5,TipologiaBici.DA_CORSA);
		Bici bici3 = new Bici(true,5,TipologiaBici.MOUNTAIN_BIKE);
		Bici bici4 = new Bici(true,4,TipologiaBici.CITTA);
		Bici bici5 = new Bici(true,4,TipologiaBici.CITTA);
		
		Bici bici6 = new Bici(true,5,TipologiaBici.CITTA);
		Bici bici7 = new Bici(true,5,TipologiaBici.DA_CORSA);
		Bici bici8 = new Bici(true,5,TipologiaBici.MOUNTAIN_BIKE);
		Bici bici9 = new Bici(true,4,TipologiaBici.CITTA);
		Bici bici10 = new Bici(true,4,TipologiaBici.CITTA);


		Bici bici11 = new Bici(true,5,TipologiaBici.CITTA);
		Bici bici12 = new Bici(true,5,TipologiaBici.DA_CORSA);
		Bici bici13 = new Bici(true,5,TipologiaBici.MOUNTAIN_BIKE);
		Bici bici14 = new Bici(true,4,TipologiaBici.CITTA);
		Bici bici15 = new Bici(true,4,TipologiaBici.CITTA);
		
		Bici bici16 = new Bici(true,5,TipologiaBici.CITTA);
		Bici bici17 = new Bici(true,5,TipologiaBici.DA_CORSA);
		Bici bici18 = new Bici(true,5,TipologiaBici.MOUNTAIN_BIKE);
		Bici bici19 = new Bici(true,4,TipologiaBici.CITTA);
		Bici bici20 = new Bici(true,4,TipologiaBici.CITTA);
		
		Bici bici21 = new Bici(true,5,TipologiaBici.CITTA);
		Bici bici22 = new Bici(true,5,TipologiaBici.DA_CORSA);
		Bici bici23 = new Bici(true,5,TipologiaBici.MOUNTAIN_BIKE);
		Bici bici24 = new Bici(true,4,TipologiaBici.CITTA);
		Bici bici25 = new Bici(true,4,TipologiaBici.CITTA);
		
		this.biciRepo.save(bici1);
		this.biciRepo.save(bici2);	
		this.biciRepo.save(bici3);
		this.biciRepo.save(bici4);
		this.biciRepo.save(bici5);
		
		this.biciRepo.save(bici6);
		this.biciRepo.save(bici7);	
		this.biciRepo.save(bici8);
		this.biciRepo.save(bici9);
		this.biciRepo.save(bici10);
		
		this.biciRepo.save(bici11);
		this.biciRepo.save(bici12);	
		this.biciRepo.save(bici13);
		this.biciRepo.save(bici14);
		this.biciRepo.save(bici15);
		
		this.biciRepo.save(bici16);
		this.biciRepo.save(bici17);	
		this.biciRepo.save(bici18);
		this.biciRepo.save(bici19);
		this.biciRepo.save(bici20);
		
		this.biciRepo.save(bici21);
		this.biciRepo.save(bici22);	
		this.biciRepo.save(bici23);
		this.biciRepo.save(bici24);
		this.biciRepo.save(bici25);
		
		
		rastrelliera1.addBici(bici1);
		rastrelliera1.addBici(bici2);
		rastrelliera1.addBici(bici3);
		rastrelliera1.addBici(bici4);
		rastrelliera1.addBici(bici5);
		
		rastrelliera1.addBici(bici6);
		rastrelliera1.addBici(bici7);
		rastrelliera1.addBici(bici8);
		rastrelliera1.addBici(bici9);
		rastrelliera1.addBici(bici10);
		
		rastrelliera1.addBici(bici11);
		rastrelliera1.addBici(bici12);
		rastrelliera1.addBici(bici13);
		rastrelliera1.addBici(bici14);
		rastrelliera1.addBici(bici15);
		
		rastrelliera1.addBici(bici16);
		rastrelliera1.addBici(bici17);
		rastrelliera1.addBici(bici18);
		rastrelliera1.addBici(bici19);
		rastrelliera1.addBici(bici20);
		
		rastrelliera1.addBici(bici21);
		rastrelliera1.addBici(bici22);
		rastrelliera1.addBici(bici23);
		rastrelliera1.addBici(bici24);
		rastrelliera1.addBici(bici25);
		
		this.rastrellieraRepo.save(rastrelliera1);
		this.rastrellieraRepo.save(rastrelliera2);
		this.rastrellieraRepo.save(rastrelliera3);
		this.rastrellieraRepo.save(rastrelliera4);
		this.rastrellieraRepo.save(rastrelliera5);

	}
}
