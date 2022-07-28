package tn.esprit.spring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.entity.Simulateur;
import tn.esprit.spring.service.impl.SimulateurServiceImpl;

@RestController
public class SimulateurController {
	
	
	@Autowired
	private SimulateurServiceImpl simulateurService;
	
	@GetMapping("/retrieve-all-simulateurs")
	public List<Simulateur> retrieveAllSimulateurs() {
	 
		return simulateurService.retrieveAllSimulateurs();
	}

	@GetMapping("/retrieve-simulateur/{simulateur-id}")
	public Simulateur retrieveSimulateur(@PathVariable("simulateur-id") Long simulateurId) {
		return simulateurService.retrieveSimulateur(simulateurId);
	}

	@PostMapping("/add-simulateur")
	public Simulateur addSimulateur(@RequestBody Simulateur si) {
		Simulateur simulateur = simulateurService.addSimulateur(si);
		return simulateur;
	}

	@DeleteMapping("/remove-simulateur/{simulateur-id}")
	public void deleteSimulateur(@PathVariable("simulateur-id") Long  simulateurId) {
		simulateurService.deleteSimulateur(simulateurId);
	}

	@PutMapping("/update-simulateur/{simulateur-id}")
	public Simulateur updateSimulateur(@RequestBody Simulateur simulateur ,@PathVariable("simulateur-id") Long  simulateurId) {
		return simulateurService.updateSimulateur(simulateur, simulateurId);
	}
	
	@PostMapping("/valider-simulateur")
	public Simulateur validerSimulateur(@RequestBody Simulateur si) {
		Simulateur simulateur = simulateurService.validerSimulateur(si);
		return simulateur;
	}
	
	@PostMapping("/calcul-simulateur")
	public Simulateur calculSimulateur(@RequestBody Simulateur si) {
		Simulateur simulateur = simulateurService.calculSimulateur(si);
		return simulateur;
	}
	
	/*@PutMapping("/calcul-simulateur/{simulateur-id}")
	public Simulateur calcul(@RequestBody Simulateur simulateur ,@PathVariable("simulateur-id") Long  simulateurId) {
		return simulateurService.updateSimulateur(simulateur, simulateurId);
	}*/
	
	

}