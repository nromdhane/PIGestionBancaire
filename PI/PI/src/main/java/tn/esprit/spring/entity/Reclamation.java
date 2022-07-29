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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="Description")
	private String description;
	
	
	@Column(name="Objet")
	private String objet;
	
	@Column(name="sentiment")
	private String sentiment;
	
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





	public String getSentiment() {
		return sentiment;
	}


	public void setSentiment(String sentiment) {
		this.sentiment = sentiment;
	}


	public TypeReclamation getTypeReclamation() {
		return typeReclamation;
	}


	public void setTypeReclamation(TypeReclamation typeReclamation) {
		this.typeReclamation = typeReclamation;
	}


	public Reclamation(Long id, String description, String objet, String sentiment, TypeReclamation typeReclamation) {
		super();
		this.id = id;
		this.description = description;
		this.objet = objet;
		this.sentiment = sentiment;
		this.typeReclamation = typeReclamation;
	}


	public Reclamation() {
		super();
	}


	@Override
	public String toString() {
		return "Reclamation [id=" + id + ", description=" + description + ", objet=" + objet + ", sentiment="
				+ sentiment + ", typeReclamation=" + typeReclamation + "]";
	}



	
}
