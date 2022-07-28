package tn.esprit.spring.service.impl;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import tn.esprit.spring.entity.Simulateur;
import tn.esprit.spring.repository.SimulateurRepository;
import tn.esprit.spring.service.ISimulateurService;


@Service
public class SimulateurServiceImpl implements ISimulateurService{
	
	private static final Logger l = LogManager.getLogger(SimulateurServiceImpl.class);
	
	@Autowired
	private SimulateurRepository simulateurRepository;

	@Override
	public List<Simulateur> retrieveAllSimulateurs() {
		// TODO Auto-generated method stub
		
		 
		 List<Simulateur> simulateur = null; 
			try {
				
				l.info("In Method retrieveAllSimulateurs :");
				simulateur = (List<Simulateur>) simulateurRepository.findAll(); 
				l.debug("connexion à la DB Ok :"); 
				for (Simulateur entr : simulateur) {
					l.debug("entr :" + entr.getMontant() ); 
				} 
				l.info("Out of Method retrieveAllSimulateurs with Success" + simulateur.size());
			}catch (Exception e) {
				l.error("Out of Method retrieveAllSimulateurs with Errors : " + e); 
			}

			return simulateur;
	}

	@Override
	public Simulateur addSimulateur(Simulateur si) {
		// TODO Auto-generated method stub
		
		Simulateur ent = null; 
		
		try {
			l.info("Process started");
			ent = simulateurRepository.save(si); 
			l.info("Saved simulateur");
			
		} catch (Exception e) {
			 l.error("error in addSimulateur() : " + si);
		}
		
		return ent; 
	}

	@Override
	public void deleteSimulateur(Long id) {
		// TODO Auto-generated method stub
		
		try {
			l.info("Process started");
			simulateurRepository.deleteById(id); 
			l.info("deleted simulateur"); 
			
		} catch (Exception e) {
			l.error("error in deleteSimulateur() : " + e);
		}
		
	}

	@Override
	public Simulateur updateSimulateur(Simulateur si, Long id) {
		
		Simulateur simulateurUpdated = null;
		try {
			l.info(" Process has started");
			Simulateur simulateur = simulateurRepository.findById(id).get();
			simulateur.setTmm(si.getTmm());
			simulateur.setTaux(si.getTaux());
			simulateur.setMontant(si.getMontant());
			simulateur.setSalaire(si.getSalaire());
		    simulateurUpdated = simulateurRepository.save(simulateur);
			l.info("Simulateur updated");
		} catch (Exception e) {
			l.error("error in updateSimulateur() : " + si);
		}
		
		return simulateurUpdated; 
	}

	@Override
	public Simulateur retrieveSimulateur(Long id) {
		// TODO Auto-generated method stub
		
		Simulateur entr = null;
			
		try {
			l.info("Start process");
			entr = simulateurRepository.findById(id).get(); 
			l.info("Simulateur found");
			
		} catch (Exception e) {
			l.error("error in retrieveSimulateur() : " + e);
		}
		
		return entr; 
	}
	
	@Override
	public Simulateur validerSimulateur(Simulateur si) {
		
		if (si.getSalaire() < 700) {
			si.setStatus("invalide");
			return simulateurRepository.save(si);		
		}else {
			si.setStatus("valide");
			return simulateurRepository.save(si);
		}		
	}
	
	
	@Override
	public Simulateur calculSimulateur(Simulateur si) {
		
		long nmonths = si.getNyears() * 12;
		double mensualite = ((si.getMontant()-si.getAutofin())*si.getTaux()) / nmonths;
		
		if (mensualite > (si.getSalaire() * 60 / 100)){ 
			si.setStatus("invalide");
			return simulateurRepository.save(si);	 
			}else { 
			si.setMensualite(mensualite);
			si.setStatus("valide");
			return simulateurRepository.save(si);
			}
		
	}
	
	/*@Override
	public Simulateur calculSimulateur(Simulateur si, Long id) {
		
		Simulateur simulateurUpdated = null;
		try {
			l.info(" Process has started");
			Simulateur simulateur = simulateurRepository.findById(id).get();
			
			long nmonths = si.getNyears() * 12;
			double mensualite = ((si.getMontant()-si.getAutofin())*si.getTaux()) / nmonths;
			
			if (mensualite > (si.getSalaire() * 60 / 100)){ 
				si.setStatus("invalide");
				return simulateurRepository.save(si);	 
				}else { 
				si.setMensualite(mensualite);
				return simulateurRepository.save(si);
				}
			//l.info("Simulateur updated");
		} catch (Exception e) {
			l.error("error in updateSimulateur() : " + si);
		}
		
		return simulateurUpdated; 
	}*/


}