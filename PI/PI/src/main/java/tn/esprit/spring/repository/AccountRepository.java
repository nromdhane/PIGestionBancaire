package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import tn.esprit.spring.entity.Compte;

public interface AccountRepository extends CrudRepository<Compte, Long>, PagingAndSortingRepository<Compte, Long>{

}
