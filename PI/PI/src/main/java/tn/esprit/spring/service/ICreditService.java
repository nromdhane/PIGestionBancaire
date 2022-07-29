package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Credit;

public interface ICreditService { 
	 
	List<Credit> retrieveAllCredits(); 
	Credit addCredit(Credit cr);
	void deleteCredit(Long id);
	Credit updateCredit(Credit cr,Long id);
	Credit retrieveCredit(Long id);

} 