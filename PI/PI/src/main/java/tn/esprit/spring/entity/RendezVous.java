package tn.esprit.spring.entity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RendezVous implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="Objet")
	private String objet;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="Createur")
	private String createur;
	
	@Column(name="Inviter")
	private String inviter;
	

}
