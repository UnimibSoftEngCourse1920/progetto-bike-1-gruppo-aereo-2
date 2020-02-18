package edu.progetto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.progetto.dto.ClienteDTO;
import edu.progetto.entity.Cliente;
import edu.progetto.exception.ExistingUserException;
import edu.progetto.request.AuthenticationRequest;
import edu.progetto.response.AuthenticationResponse;
import edu.progetto.security.JwtUtil;
import edu.progetto.service.CustomUserDetailsService;

@CrossOrigin(origins = "*")	
@RestController
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	
	@PostMapping(value = "/authenticate")
	public ResponseEntity<AuthenticationResponse> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest){

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new BadCredentialsException("Incorrect username or password", e);
		}


		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
	@PostMapping(value = "/register")
	public ResponseEntity<Cliente> saveUser(@RequestBody ClienteDTO clienteDTO){
		if (userDetailsService.isPresentUsername(clienteDTO.getUsername())){
			 throw new ExistingUserException("Username exists: "+clienteDTO.getUsername());
		}
		if (userDetailsService.isPresentEmail(clienteDTO.getEmail())){
			 throw new ExistingUserException("Email already registered: "+clienteDTO.getEmail());
		}
		
		Cliente cliente = new Cliente(clienteDTO);
		
		
		
		return ResponseEntity.ok(userDetailsService.save(cliente));
	}
}