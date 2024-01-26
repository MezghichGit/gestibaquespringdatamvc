package com.sip.gestibanque.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sip.gestibanque.entities.Banque;
import com.sip.gestibanque.entities.User;

@Repository
public interface BanqueRepository extends CrudRepository<Banque, Integer>{
	
	List<Banque> findByNom(String nom);

}
