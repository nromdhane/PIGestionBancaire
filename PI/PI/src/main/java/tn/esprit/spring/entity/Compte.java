package tn.esprit.spring.entity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Compte implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="Numero")
	private Integer numero;
	
	@Column(name="Solde")
	private Long solde;
	
	  @Temporal(TemporalType.DATE)
	    @Column(name = "DateOuverture", nullable = false)
	    private Date dateOuverture;

}
