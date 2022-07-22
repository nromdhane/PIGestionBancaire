package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entity.Utilisateur;
import tn.esprit.spring.repository.UserRepository;

public class UserService {
	
    @Autowired
    private UserRepository userRepository;
	
    public Utilisateur findByUsername(String nom) {
        return userRepository.findBynom(nom);
    }

}
