package edu.progetto;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import edu.progetto.entity.Bici;
import edu.progetto.entity.Cliente;
import edu.progetto.entity.Rastrelliera;
import edu.progetto.entity.Ruolo;
import edu.progetto.repository.BiciRepository;
import edu.progetto.repository.ClienteRepository;
import edu.progetto.repository.RastrellieraRepository;

@Component
@ConditionalOnProperty(name = "app.db-init", havingValue = "true")
public class DbInitializer implements CommandLineRunner {
	
	private RastrellieraRepository rastrellieraRepo;
	private ClienteRepository clienteRepo;
	private BiciRepository biciRepo;
	
	@Autowired
	private PasswordEncoder bcryptoEncoder;

	public DbInitializer(RastrellieraRepository rastrellieraRepo, ClienteRepository clienteRepo,BiciRepository biciRepo) {
		this.rastrellieraRepo = rastrellieraRepo;
		this.clienteRepo = clienteRepo;
		this.biciRepo = biciRepo;
	}


	@Override
	public void run(String... args) throws Exception {

		
		this.clienteRepo.deleteAll();
		this.rastrellieraRepo.deleteAll();
		this.biciRepo.deleteAll();
		
		Cliente cliente1 = new Cliente("Oleg","Stoianov","oleg.stoianov@babbo.it","oleghinho",bcryptoEncoder.encode("1234"),Ruolo.ROLE_GENERICO);
		Cliente cliente2 = new Cliente("Lorenzo","Nosotti","lollo.noso@babbo.it","lollonoso",bcryptoEncoder.encode("4321"),Ruolo.ROLE_ADMIN);
		
		this.clienteRepo.save(cliente1);
		this.clienteRepo.save(cliente2);
		
		Rastrelliera rastrelliera1 = new Rastrelliera("Via Carducci");
		Rastrelliera rastrelliera2 = new Rastrelliera("Via Manzoni");
		
		Bici bici1 = new Bici(true,5);
		Bici bici2 = new Bici(true,4);
		Bici bici3 = new Bici(true,5);
		Bici bici4 = new Bici(true,4);
		
		this.biciRepo.save(bici1);
		this.biciRepo.save(bici2);	
		this.biciRepo.save(bici3);
		this.biciRepo.save(bici4);
		
		rastrelliera1.addBici(bici1);
		rastrelliera1.addBici(bici2);
		rastrelliera1.addBici(bici3);
		rastrelliera2.addBici(bici4);
		
		this.rastrellieraRepo.save(rastrelliera1);
		this.rastrellieraRepo.save(rastrelliera2);
		
		
	}
	
	

}
