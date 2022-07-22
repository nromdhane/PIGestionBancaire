package tn.esprit.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entity.Compte;
import tn.esprit.spring.repository.AccountRepository;

public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
	
	   public Compte getAccountById(Long id) {
	        Optional<Compte> act = accountRepository.findById(id);
	        if (act.isPresent()) {
	            return act.get();
	        } else {
	            return null;
	        }
	    }

}
