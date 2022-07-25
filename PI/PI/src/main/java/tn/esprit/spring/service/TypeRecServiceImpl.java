package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.TypeReclamation;
import tn.esprit.spring.repository.TypeReclamationRepository;
@Service
public class TypeRecServiceImpl implements ITypeRecService {

	@Autowired
	TypeReclamationRepository impl;
	@Override
	public List<TypeReclamation> retreiveAllTypeReclamation() {
		// TODO Auto-generated method stub
		return (List<TypeReclamation>) impl.findAll();
	}

	@Override
	public TypeReclamation addOrUpdateTypeReclamation(TypeReclamation rcl) {
		// TODO Auto-generated method stub
		return impl.save(rcl);
	}

	@Override
	public void deleteTypeReclamation(Long id) {
		// TODO Auto-generated method stub
		impl.deleteById(id);
	}

	@Override
	public Optional<TypeReclamation> getTypeReclamationById(Long id) {
		// TODO Auto-generated method stub
		return impl.findById(id);
	}

}
