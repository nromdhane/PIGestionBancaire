package tn.esprit.spring.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Optional;

import javax.validation.Valid;

import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.service.ReclamationServiceImpl;
@CrossOrigin
@RestController
public class ReclamationController {
	@Autowired
	ReclamationServiceImpl impl;
	
	
	
	
	@GetMapping(value = "/retrieves-all-reclamation")
	public List<Reclamation> getReclamation() {
		
		List<Reclamation> list = impl.retreiveAllReclamation();
		System.out.print("list reclamation"+list);
		return list;
	}
	
	@GetMapping(value = "/retrieves-reclamation-by-id/{id}")
	public Optional<Reclamation> getReclamationById(@PathVariable("id") Long id) {
		
		 
		return impl.getReclamationById(id);
	}
	
	@PostMapping(value = "/save-update-reclamation")
	public Reclamation addOrUpdateReclamation(@Valid @RequestBody Reclamation rclm) throws IOException, InterruptedException {
		rclm.setSentiment(SentimentalAnalysisController.getSentiment(rclm.getDescription()));
		return impl.addOrUpdateReclamation(rclm);
		
		
	}
	@DeleteMapping(value = "/delete-reclamation/{id}")
	public void deleteReclamation(@PathVariable("id") Long id) {
		impl.deleteReclamation(id);
		
		
	}
}
