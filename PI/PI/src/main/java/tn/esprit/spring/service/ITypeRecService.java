package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entity.TypeReclamation;

public interface ITypeRecService {
	public List<TypeReclamation> retreiveAllTypeReclamation();
	public TypeReclamation addOrUpdateTypeReclamation(TypeReclamation rcl); 
	public void  deleteTypeReclamation(Long id);
	public Optional<TypeReclamation> getTypeReclamationById(Long id);
}
