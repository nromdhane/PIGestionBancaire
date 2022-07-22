package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Utilisateur;

public interface UserRepository extends CrudRepository<Utilisateur, Long> {
	
	Utilisateur findBynom(String paramString);

    List<Utilisateur> findAll();

}
