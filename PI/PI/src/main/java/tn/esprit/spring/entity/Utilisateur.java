package tn.esprit.spring.entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;


@Entity
public class Utilisateur implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="UTILISATEUR_NOM")
	private String nom;
	
	@Column(name="UTILISATEUR_PRENOM")
	private String prenom;
	
	  @Temporal(TemporalType.DATE)
	    @Column(name = "DateNaissance", nullable = false)
	    private Date dateNaissance;
	  
		@Column(name="UTILISATEUR_TELEPHONE")
		private String telephone;
		
		@Column(name="UTILISATEUR_EMAIL")
		private String email;
		@ManyToOne
		Emploi emplois;
		
		@ManyToOne
		Role roles;
		
		@OneToMany(cascade = CascadeType.ALL, mappedBy="Utilisateurs")
		private Set<Compte> comptes;	
	
		@OneToMany(cascade = CascadeType.ALL)
		private Set<RendezVous> rendezvous;

		@OneToMany(cascade = CascadeType.ALL)
		private Set<Reclamation> reclamation;

}
