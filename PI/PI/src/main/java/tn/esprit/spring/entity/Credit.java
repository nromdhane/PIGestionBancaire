package tn.esprit.spring.entity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@DiscriminatorValue("1") //(Hérite de l'opération)
public class Credit extends Operation implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="Montant")
	private Long montant;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "Date", nullable = false)
	private Date date;
	
	@Column(name="status")
	private String status;
	
	@Column(name="type")
	private String type;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMontant() {
		return montant;
	}

	public void setMontant(Long montant) {
		this.montant = montant;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Credit [id=" + id + ", montant=" + montant + ", date=" + date + ", status=" + status + ", type=" + type
				+ ", getStatus()=" + getStatus() + ", getType()=" + getType() + ", getId()=" + getId()
				+ ", getMontant()=" + getMontant() + ", getDate()=" + getDate() + "]";
	}



	


}
