package tn.esprit.spring.entity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Virement implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;

}
