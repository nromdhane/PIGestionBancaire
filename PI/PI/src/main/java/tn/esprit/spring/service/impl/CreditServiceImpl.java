package tn.esprit.spring.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import tn.esprit.spring.entity.Credit;
import tn.esprit.spring.entity.Operation;
import tn.esprit.spring.repository.CreditRepository;
import tn.esprit.spring.service.ICreditService;


@Service
public class CreditServiceImpl implements ICreditService{
	
	private static final Logger l = LogManager.getLogger(CreditServiceImpl.class);
	
	@Autowired
	private CreditRepository creditRepository;

	@Override
	public List<Credit> retrieveAllCredits() {
		// TODO Auto-generated method stub
		
		 
		 List<Credit> credit = null; 
			try {
				
				l.info("In Method retrieveAllCredits :");
				credit = (List<Credit>) creditRepository.findAll(); 
				l.debug("connexion à la DB Ok :"); 
				for (Credit entr : credit) {
					l.debug("entr :" + entr.getMontant() ); 
				} 
				l.info("Out of Method retrieveAllCredits with Success" + credit.size());
			}catch (Exception e) {
				l.error("Out of Method retrieveAllCredits with Errors : " + e); 
			}

			return credit;
	}

	@Override
	public Credit addCredit(Credit cr) {
		// TODO Auto-generated method stub
		
		Credit ent = null; 
		
		try {
			l.info("Process started");
			ent = creditRepository.save(cr); 
			l.info("Saved credit");
			
		} catch (Exception e) {
			 l.error("error in addCredit() : " + cr);
		}
		
		return ent; 
	}

	@Override
	public void deleteCredit(Long id) {
		// TODO Auto-generated method stub
		
		try {
			l.info("Process started");
			creditRepository.deleteById(id); 
			l.info("deleted credit"); 
			
		} catch (Exception e) {
			l.error("error in deleteCredit() : " + e);
		}
		
	}

	@Override
	public Credit updateCredit(Credit cr, Long id) {
		
		Credit creditUpdated = null;
		try {
			l.info(" Process has started");
			Credit credit = creditRepository.findById(id).get();
			credit.setMontant(cr.getMontant());
			credit.setStatus(cr.getStatus());
			credit.setType(cr.getType());
			credit.setDate(cr.getDate());
		    creditUpdated = creditRepository.save(credit);
			l.info("Credit updated");
		} catch (Exception e) {
			l.error("error in updateCredit() : " + cr);
		}
		
		return creditUpdated; 
	}

	@Override
	public Credit retrieveCredit(Long id) {
		// TODO Auto-generated method stub
		
		Credit entr = null;
			
		try {
			l.info("Start process");
			entr = creditRepository.findById(id).get(); 
			l.info("Credit found");
			
		} catch (Exception e) {
			l.error("error in retrieveCredit() : " + e);
		}
		
		return entr; 
	}
	
	/*@GetMapping(value = "/retrieves-all-credit")
	public List<Operation> getgetCredits() {

		List<Operation> list = creditRepository.findAllOperation();
				return list;
	}*/

}