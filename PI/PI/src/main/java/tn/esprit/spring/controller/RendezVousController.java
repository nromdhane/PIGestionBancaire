package tn.esprit.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.RendezVous;
import tn.esprit.spring.service.RendezVousServiceImpl;


@RestController
@RequestMapping("/RendezVous")
public class RendezVousController {
	@Autowired
	RendezVousServiceImpl impl;
	
	
	
	
	@GetMapping(value = "/retrieves-all-RendezVous")
	public List<RendezVous> getRendezVous() {
		
		List<RendezVous> list = impl.retreiveAllRendezVous();
		System.out.print("lists RendezVous"+list);
		return list;
	}
	
	@GetMapping(value = "/retrieves-RendezVous-by-id/{id}")
	public Optional<RendezVous> getRendezVousById(@PathVariable("id") Long id) {
		
		 
		return impl.getRendezVousById(id);
	}
	
	@PostMapping(value = "/save-updsate-RendezVous")
	public RendezVous addOrUpdateRendezVous(@RequestBody RendezVous rclm) {
		System.out.print("new RendezVous"+rclm);
		return impl.addOrUpdateRendezVous(rclm);
		
		
	}
	@DeleteMapping(value = "/delete-RendezVous/{id}")
	public void deleteRendezVous(@PathVariable("id") Long id) {
		impl.deleteRendezVous(id);
		
	}
}
