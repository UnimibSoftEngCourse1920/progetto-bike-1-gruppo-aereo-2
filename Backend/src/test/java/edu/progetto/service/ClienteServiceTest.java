package edu.progetto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import edu.progetto.entity.Cliente;
import edu.progetto.entity.Ruolo;
import edu.progetto.repository.ClienteRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ClienteService.class})
public class ClienteServiceTest {

	@Autowired
	ClienteService clienteService;

	@MockBean
	ClienteRepository clienteRepo;

	@Before
	public void setUp() {
		final Cliente cliente = new Cliente("Oleg","Stoianov","test@test.it", "tester","passw", Ruolo.ROLE_PERSONALE);
		Mockito.when(clienteRepo.findByUsername(cliente.getUsername())).thenReturn(cliente);
		Mockito.when(clienteRepo.existsByEmail(cliente.getEmail())).thenReturn(true);
		Mockito.when(clienteRepo.existsByEmail(cliente.getUsername())).thenReturn(true);
		Mockito.when(clienteRepo.findAll()).thenReturn(new ArrayList<Cliente>(Arrays.asList(cliente)));

	}

	@Test
	public void findClienteByUsername() {
		String username = "tester";
		Cliente clienteTrovato = clienteService.findByUsername(username);
		assertThat(clienteTrovato.getUsername()).isEqualTo(username);
	}

	@Test
	public void existByEmail() {
		String email = "test@test.it";
		assertThat(clienteService.existsByEmail(email)).isTrue();
	}

	@Test
	public void existByUsername() {
		String username = "tester";
		assertThat(clienteService.existsByEmail(username)).isTrue();
	}

	@Test
	public void getAllClienti() {
		String nome = "Oleg";
		assertThat(clienteService.getAllClienti().size()).isEqualTo(1);
		assertThat(clienteService.getAllClienti().get(0).getNome()).isEqualTo(nome);
	}

}
