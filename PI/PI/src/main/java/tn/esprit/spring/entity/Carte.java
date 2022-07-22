package tn.esprit.spring.entity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Carte implements Serializable{

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="NumeroCarte")
	private Integer numeroCarte;
	
	  @Temporal(TemporalType.DATE)
	    @Column(name = "DateExpiration", nullable = false)
	    private Date dateExpiration;
	  
		@Column(name="CodeSecurite")
		private Integer codeSecurite;
		
		  @ManyToOne
		  Compte comptes;
}
