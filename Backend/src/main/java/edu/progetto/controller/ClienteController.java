package edu.progetto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import edu.progetto.dto.ClienteDTO;
import edu.progetto.entity.Cliente;
import edu.progetto.entity.Conto;
import edu.progetto.exception.ExistingUserException;
import edu.progetto.request.AuthenticationRequest;
import edu.progetto.response.AuthenticationResponse;
import edu.progetto.response.MessageResponse;
import edu.progetto.security.JwtUtil;
import edu.progetto.service.ClienteService;
import edu.progetto.service.ContoService;
import edu.progetto.service.UserDetailsImpl;
import edu.progetto.service.UserDetailsServiceImpl;


@CrossOrigin(origins = "*")	
@RestController
@RequestMapping("/clienti")
public class ClienteController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ContoService contoService;
	
	
	@PostMapping(value = "/signin")
	public ResponseEntity<AuthenticationResponse> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest){
		Authentication authentication;
		try {
				authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new BadCredentialsException("Incorrect username or password", e);
		}

		SecurityContextHolder.getContext().setAuthentication(authentication);
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		
		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt,
															userDetails.getUsername(),
															clienteService.findByUsername(userDetails.getUsername()).getRuolo().name()));
	}
	
	@PostMapping(value = "/signup")
	public ResponseEntity<MessageResponse> saveUser(@RequestBody ClienteDTO clienteDTO){
		if (Boolean.TRUE.equals(clienteService.existsByUsername(clienteDTO.getUsername()))){
			 throw new ExistingUserException("Username exists: "+clienteDTO.getUsername());
		}
		if (Boolean.TRUE.equals(clienteService.existsByEmail(clienteDTO.getEmail()))){
			 throw new ExistingUserException("Email already registered: "+clienteDTO.getEmail());
		}
		
		clienteDTO.setPassword(encoder.encode(clienteDTO.getPassword()));
		Cliente cliente = new Cliente(clienteDTO);
		Conto conto = new Conto(cliente, 0.00);
		contoService.addConto(conto);
		clienteService.addCliente(cliente);
		
		
		
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}