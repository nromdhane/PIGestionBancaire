package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.repository.ReclamationRepository;

@Service
public class ReclamationServiceImpl implements IReclamationService {
	@Autowired //injection de dependance
	ReclamationRepository reclamationRepository;
	@Override
	public List<Reclamation> retreiveAllReclamation() {
		// TODO Auto-generated method stub
		return (List<Reclamation>) reclamationRepository.findAll();
	}
	@Override
	public Reclamation addOrUpdateReclamation(Reclamation rcl) {
		// TODO Auto-generated method stub
		return reclamationRepository.save(rcl);
	}
	@Override
	public void deleteReclamation(Long id) {
		// TODO Auto-generated method stub
		reclamationRepository.deleteById(id);
	}
	@Override
	public Optional<Reclamation> getReclamationById(Long id) {
		// TODO Auto-generated method stub
		return reclamationRepository.findById(id);
	}
	

}
