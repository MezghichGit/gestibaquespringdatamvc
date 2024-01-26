package com.sip.gestibanque.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.sip.gestibanque.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	List<User> findByNom(String nom);
}
