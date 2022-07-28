package tn.esprit.spring.service;
import java.util.List;
import tn.esprit.spring.entity.Simulateur;


public interface ISimulateurService { 
	 
	List<Simulateur> retrieveAllSimulateurs(); 
	Simulateur addSimulateur(Simulateur si);
	void deleteSimulateur(Long id);
	Simulateur updateSimulateur(Simulateur si,Long id);
	Simulateur retrieveSimulateur(Long id);
	public Simulateur  validerSimulateur(Simulateur si);
	public Simulateur  calculSimulateur(Simulateur si);

} 