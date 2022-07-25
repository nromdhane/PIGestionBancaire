package tn.esprit.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.TypeReclamation;
import tn.esprit.spring.service.TypeRecServiceImpl;

@RestController
public class TypeRecController {
	
	@Autowired
	TypeRecServiceImpl impl;
	
@GetMapping(value = "/retrieves-all-TypeReclamation")
public List<TypeReclamation> getTypeReclamation() {
	
	List<TypeReclamation> list = impl.retreiveAllTypeReclamation();
	System.out.print("list TypeReclamation"+list);
	return list;
}

@GetMapping(value = "/retrieves-TypeReclamation-by-id/{id}")
public Optional<TypeReclamation> getTypeReclamationById(@PathVariable("id") Long id) {
	
	 
	return impl.getTypeReclamationById(id);
}

@PostMapping(value = "/save-updsate-TypeReclamation")
public TypeReclamation addOrUpdateTypeReclamation(@RequestBody TypeReclamation rclm) {
	System.out.print("new reclamation"+rclm);
	return impl.addOrUpdateTypeReclamation(rclm);
	
	
}
@DeleteMapping(value = "/delete-TypeReclamation/{id}")
public void deleteReclamation(@PathVariable("id") Long id) {
	impl.deleteTypeReclamation(id);
	
}
}
