package tn.esprit.spring.entity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Inheritance;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;

@Entity
@Table( name = "T_Transaction" )
@DiscriminatorValue("2") //Hérite de l'opération)
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )  //héritage (opération c'est la classe mère)
@DiscriminatorColumn( name="discriminatorT", discriminatorType = DiscriminatorType.INTEGER )
public class Transaction  extends Operation implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="Montant")
	private Integer montant;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMontant() {
		return montant;
	}

	public void setMontant(Integer montant) {
		this.montant = montant;
	}
	
	
	

}
