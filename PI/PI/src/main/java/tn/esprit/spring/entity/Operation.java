package tn.esprit.spring.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Table;

@Entity
@Table( name = "T_OPERATIONS" )
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )  //héritage (opération c'est la classe mère)
@DiscriminatorColumn( name="discriminator", discriminatorType = DiscriminatorType.INTEGER )
public abstract class  Operation implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	  @Temporal(TemporalType.DATE)
	    @Column(name = "Date", nullable = false)
	    private Date date;
	  
		@Column(name="Type")
		private String type;
		
		@Column(name="Status")
		private String status;

		@ManyToMany(mappedBy="operations", cascade = CascadeType.ALL)
		private Set<Compte> comptes;
}
