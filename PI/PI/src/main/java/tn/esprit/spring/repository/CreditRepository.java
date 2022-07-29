package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.Credit;
import tn.esprit.spring.entity.Operation;

@Repository

public interface CreditRepository extends CrudRepository<Credit, Long> {
	
	//@Query("SELECT e FROM t_operations e where t_operations.discriminator=1")
	//public List<Operation> findAllOperation();
	
}