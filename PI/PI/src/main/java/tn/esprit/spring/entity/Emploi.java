package tn.esprit.spring.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.io.Serializable;

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
	
	@Column(name="NombreAnnéeEmployeur")
	private Integer nombreAnneeEmployeur;

}
