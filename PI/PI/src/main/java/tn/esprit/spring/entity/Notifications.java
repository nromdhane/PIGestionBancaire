package tn.esprit.spring.entity;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Notifications implements Serializable{

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="Titre")
	private String titre;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="Type")
	private String type;
	
	@ManyToMany(mappedBy="notifications", cascade = CascadeType.ALL)
	private Set<Compte> comptes;
}
