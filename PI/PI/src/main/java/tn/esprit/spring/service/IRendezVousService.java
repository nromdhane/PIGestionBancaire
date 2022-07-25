package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entity.RendezVous;

public interface IRendezVousService {
	public List<RendezVous> retreiveAllRendezVous();
	public RendezVous addOrUpdateRendezVous(RendezVous rcl); 
	public void  deleteRendezVous(Long id);
	public Optional<RendezVous> getRendezVousById(Long id);

}
