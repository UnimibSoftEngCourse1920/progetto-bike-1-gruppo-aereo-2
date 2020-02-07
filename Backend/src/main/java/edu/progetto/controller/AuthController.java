package edu.progetto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.progetto.entity.Cliente;
import edu.progetto.exception.EmailAlreadyRegistered;
import edu.progetto.exception.UserAlreadyRegistered;
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
	
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}


		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody Cliente cliente) throws Exception {
		if (userDetailsService.isPresentUsername(cliente.getUsername())){
			 throw new UserAlreadyRegistered("Username exists: "+cliente.getUsername());
		}
		if (userDetailsService.isPresentEmail(cliente.getEmail())){
			 throw new EmailAlreadyRegistered("Email already registered: "+cliente.getEmail());
		}
		
		
		return ResponseEntity.ok(userDetailsService.save(cliente));
	}
}