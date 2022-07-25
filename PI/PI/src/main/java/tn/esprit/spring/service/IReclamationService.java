package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;
import tn.esprit.spring.entity.Reclamation;

public interface IReclamationService {
	public List<Reclamation> retreiveAllReclamation() ;
	public Reclamation addOrUpdateReclamation(Reclamation rcl); 
	public void  deleteReclamation(Long id);
	public Optional<Reclamation> getReclamationById(Long id);
}
