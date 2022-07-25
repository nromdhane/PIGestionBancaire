package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.RendezVous;
import tn.esprit.spring.repository.RendezVousRepository;


@Service
public class RendezVousServiceImpl implements IRendezVousService {
	@Autowired
	RendezVousRepository impl;
	@Override
	public List<RendezVous> retreiveAllRendezVous() {
		// TODO Auto-generated method stub
		return (List<RendezVous>) impl.findAll();
	}

	@Override
	public RendezVous addOrUpdateRendezVous(RendezVous rcl) {
		// TODO Auto-generated method stub
		return impl.save(rcl);
	}

	@Override
	public void deleteRendezVous(Long id) {
		// TODO Auto-generated method stub
		impl.deleteById(id);
		
	}

	@Override
	public Optional<RendezVous> getRendezVousById(Long id) {
		// TODO Auto-generated method stub
		return impl.findById(id);
	}

}
