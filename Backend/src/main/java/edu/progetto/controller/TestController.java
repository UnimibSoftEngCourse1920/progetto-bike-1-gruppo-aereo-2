package edu.progetto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.progetto.entity.Rastrelliera;
import edu.progetto.service.RastrellieraService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private RastrellieraService rastrellieraService;
	
	@GetMapping("/user/rastrelliere")
	@PreAuthorize("hasRole('STUDENT')")
	public List<String> userAccess() {
		return rastrellieraService.getVieRastrelliere();
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('GENERIC')")
	public String moderatorAccess() {
		return "Generic Board.";
	}

	@GetMapping("/admin/prova")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
}
