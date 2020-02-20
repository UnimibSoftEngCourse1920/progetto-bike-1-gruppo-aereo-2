package edu.progetto.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.progetto.entity.Cliente;
import edu.progetto.repository.ClienteRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private ClienteRepository clienteRepo;
		
	@Override
	public UserDetails loadUserByUsername(String username){
		Cliente cliente = clienteRepo.findByUsername(username);
		 if(cliente == null) {
	        	throw new UsernameNotFoundException("username not found");
	        }

	        return UserDetailsImpl.build(cliente);
	}
}
