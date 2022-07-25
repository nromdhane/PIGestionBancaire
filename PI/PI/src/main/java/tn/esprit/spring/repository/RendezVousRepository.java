package tn.esprit.spring.repository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring.entity.RendezVous;
import org.springframework.stereotype.Repository;


@Repository
public interface RendezVousRepository extends  CrudRepository<RendezVous, Long> {

}
