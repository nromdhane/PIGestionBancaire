package tn.esprit.spring.entity;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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
	
	
	@ManyToOne
	Utilisateur createur;
	
	
	@ManyToOne
	Utilisateur inviter;
	
	@Column(name="dateDebut")
	private Date dateDebut;
	
	@Column(name="dateFin")
	private Date dateFin;
	
	@Column(name="type")
	private TypeRendezVous type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	


	public Utilisateur getCreateur() {
		return createur;
	}

	public void setCreateur(Utilisateur createur) {
		this.createur = createur;
	}

	public Utilisateur getInviter() {
		return inviter;
	}

	public void setInviter(Utilisateur inviter) {
		this.inviter = inviter;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public TypeRendezVous getType() {
		return type;
	}

	public void setType(TypeRendezVous type) {
		this.type = type;
	}

	public RendezVous(Long id, String objet, String description, Utilisateur createur, Utilisateur inviter, Date dateDebut,
			Date dateFin, TypeRendezVous type) {
		super();
		this.id = id;
		this.objet = objet;
		this.description = description;
		this.createur = createur;
		this.inviter = inviter;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.type = type;
	}

	public RendezVous() {
		super();
	}

	@Override
	public String toString() {
		return "RendezVous [id=" + id + ", objet=" + objet + ", description=" + description + ", createur=" + createur
				+ ", inviter=" + inviter + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", type=" + type + "]";
	}

	
	
	
}
