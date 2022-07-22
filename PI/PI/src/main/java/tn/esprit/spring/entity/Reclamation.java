package tn.esprit.spring.entity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Reclamation implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="Description")
	private String description;
	
	
	@Column(name="Objet")
	private String objet;
     
	
	@OneToOne
	private TypeReclamation typeReclamation;

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getObjet() {
		return objet;
	}


	public void setObjet(String objet) {
		this.objet = objet;
	}


	public Reclamation(Long id, String description, String objet) {
		super();
		this.id = id;
		this.description = description;
		this.objet = objet;
	}


	public Reclamation() {
		super();
	}


	@Override
	public String toString() {
		return "Reclamation [id=" + id + ", description=" + description + ", objet=" + objet + "]";
	}
	
}
