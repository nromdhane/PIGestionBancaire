package tn.esprit.spring.entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.io.Serializable;
import java.util.Set;

@Entity
public class Emploi implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="StatutEmploi")
	private String statutEmploi;
	
	@Column(name="Employeur")
	private String employeur;
	
	@Column(name="AddresseEmployeur")
	private String addresseEmployeur;
	
	@Column(name="NombreAnnÃ©eEmployeur")
	private Integer nombreAnneeEmployeur;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="emplois")
	private Set<Utilisateur> Utilisateurs;
}
