package org.formation.spring.controller;

import java.util.List;

import org.formation.spring.model.Client;
import org.formation.spring.service.IPrestiBanqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins...
@RestController
public class RestClientController {

		@Autowired
		IPrestiBanqueService service;
		
		@GetMapping(value = "/clients", produces = "application/json")
		public List<Client> getAllClients() {
			return service.listClients();
		}
	
}
