package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Simulateur implements Serializable{
	
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, 
	fetch=FetchType.EAGER)
	private Credit credit;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="TMM")
	private Float tmm;
	
	@Column(name="Taux")
	private Float taux;

	@Column(name="Montant")
	private Double montant;
	
	@Column(name="Salaire")
	private Double salaire;
	
	@Column(name="Status")
	private String status;
	
	@Column(name="Nyears")
	private int nyears;
	
	@Column(name="AutoFin")
	private Double autofin;
	
	@Column(name="Mensualite")
	private Double mensualite;

	public String getStatus() {
		return status;
	}

	
	public int getNyears() {
		return nyears;
	}


	public void setNyears(int nyears) {
		this.nyears = nyears;
	}


	public Double getAutofin() {
		return autofin;
	}


	public void setAutofin(Double autofin) {
		this.autofin = autofin;
	}


	public Double getMensualite() {
		return mensualite;
	}


	public void setMensualite(Double mensualite) {
		this.mensualite = mensualite;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getTmm() {
		return tmm;
	}

	public void setTmm(Float tmm) {
		this.tmm = tmm;
	}

	public Float getTaux() {
		return taux;
	}

	public void setTaux(Float taux) {
		this.taux = taux;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public Double getSalaire() {
		return salaire;
	}

	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}


	@Override
	public String toString() {
		return "Simulateur [id=" + id + ", tmm=" + tmm + ", taux=" + taux + ", montant=" + montant + ", salaire="
				+ salaire + ", status=" + status + ", nyears=" + nyears + ", autofin=" + autofin + ", mensualite="
				+ mensualite + ", getStatus()=" + getStatus() + ", getNyears()=" + getNyears() + ", getAutofin()="
				+ getAutofin() + ", getMensualite()=" + getMensualite() + ", getId()=" + getId() + ", getTmm()="
				+ getTmm() + ", getTaux()=" + getTaux() + ", getMontant()=" + getMontant() + ", getSalaire()="
				+ getSalaire() + "]";
	}



	
	
	
	
}
