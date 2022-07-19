package tn.esprit.spring.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

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
		
		
	
	

}
